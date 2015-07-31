# test
1.完成了spring mvc、mybatis的集成
	需要注意的就是申明式事务管理方面，service不能使用try-catch捕获异常，一但捕获异常事务将不会回滚。
2.添加bootstrap框架
3.完成首页布局功能
	.引入了jerichotab插件，实现tab页效果
	.使用bootstrap3实现左侧菜单栏(手风琴折叠菜单)

4.添加验证码功能
	.生成验证码
		.首先创建BufferedImage 对象 BufferedImage image = new BufferedImage(width, height, BufferedImage.RGB);
		.获取绘图对象Graphics：Graphics g = image.getGraphics();
		.生成背景
			.设置填充颜色 g.setColor(new Color(int, int, int)) 因为使用的是RGB方式，所以颜色是3个整数调和而成
			.进行矩形填充(需要坐标确定) g.fillRect(x,y,x1,y1)
			.绘制干扰线，做一个循环节课 g.drawLine(x,y, x1, y1)
			.获取随机字符，有一个字符数组，随机产生下标获取字符
			.设置字符颜色、字体g.setFont(new Font(....))、绘制字符g.drawString(字符,x, y) xy坐标确定位置
			.完成上述动作,g.dispose();
			.通过输出流输出图片：
				OutputStream out = response.getOutputStream();
				ImageIO.write(image,"JPEG", out);
				out.close();
			.前台调用改方法：
				<img src="${pageContext.request.contextPath}/servlet/validateCodeServlet" >
			.需要配置servlet

5.添加表单验证功能
	.主要是引入jquery.validate.js

6.对用户密码进行加密
	采用的是sha1的方式进行加密，最终形成的密码是盐+密码加密值

