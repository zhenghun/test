package com.xbzheng.servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Administrator on 2015/7/16.
 */
public class ValidateCodeServlet extends HttpServlet {
    public static final String VALIDATE_CODE = "validateCode";

    private int width = 70;
    private int height = 26;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String validateCode = req.getParameter(VALIDATE_CODE); // AJAX��֤���ɹ�����true
        if (StringUtils.isNotBlank(validateCode)){
            resp.getOutputStream().print(validate(req, validateCode)?"true":"false");
        }else{
            this.createCheckImg(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public static boolean validate(HttpServletRequest request, String validateCode){
        String code = (String)request.getSession().getAttribute(VALIDATE_CODE);
        return validateCode.toUpperCase().equals(code);
    }

    private void createCheckImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        String w = request.getParameter("width");
        String h = request.getParameter("height");
        if(StringUtils.isNumeric(w) && StringUtils.isNumeric(h)){
            width = NumberUtils.toInt(w);
            height = NumberUtils.toInt(h);
        }

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        //���ɱ���
        createBackground(g);
        //�����ַ�
        String s = createCharacter(g);
        request.getSession().setAttribute(VALIDATE_CODE, s);

        g.dispose();
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        out.close();
    }
    private void createBackground(Graphics g) {
        // ��䱳��
        g.setColor(getRandColor(220,250));//�����������ɫ
        g.fillRect(0, 0, width, height);//���������ɫ
        // �����������
        for (int i = 0; i < 8; i++) {
            g.setColor(getRandColor(40,150));
            Random random = new Random();
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            g.drawLine(x, y, x1, y1);
        }
    }
    private Color getRandColor(int fc,int bc) {
        int f = fc;
        int b = bc;
        Random random=new Random();
        if(f>255) {
            f=255;
        }
        if(b>255) {
            b=255;
        }
        return new Color(f+random.nextInt(b-f),f+random.nextInt(b-f),f+random.nextInt(b-f));
    }
    private String createCharacter(Graphics g) {
        char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
                'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
        String[] fontTypes = {"Arial","Arial Black","AvantGarde Bk BT","Calibri"};
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//���ѡȡһ���ַ�
            g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));//������ɫ
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)],Font.BOLD,26));//��������
            g.drawString(r, 15 * i + 5, 19 + random.nextInt(8));//�ַ�, x����, y����
            sBuilder.append(r);
        }
        return sBuilder.toString();
    }
}
