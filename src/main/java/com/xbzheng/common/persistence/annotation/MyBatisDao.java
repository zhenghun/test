package com.xbzheng.common.persistence.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Retentionע�⣺˵���������͵�ע��ᱻ�������ĸ��׶Σ�������ֵ��
 *  1.RetentionPolicy.SOURCE ���� �������͵�Annotationsֻ��Դ���뼶����,����ʱ�ͻᱻ����
 *  2.RetentionPolicy.CLASS ���� �������͵�Annotations����ʱ������,��class�ļ��д���,��JVM�������
 *  3.RetentionPolicy.RUNTIME ���� �������͵�Annotations����JVM����,����������������ʱ��JVM������ʹ�÷�����ƵĴ�������ȡ��ʹ��.
 * Target
 * Created by hun on 2015-07-23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {
    String value() default "";
}
