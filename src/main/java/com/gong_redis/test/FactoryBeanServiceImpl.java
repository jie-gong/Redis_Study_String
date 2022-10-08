package com.gong_redis.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//实现类
public class FactoryBeanServiceImpl implements FactoryBeanService {
    /**
     * 测试FactoryBean
     */
    @Override
    public void testFactoryBean() {
        System.out.println("我是FactoryBean的一个测试类。。。。");
    }

    //单测
    @Test
    public void test() {
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("classpath:com/gong/gong_redis/applicationContext.xml");
        FactoryBeanService beanService = cac.getBean(FactoryBeanService.class);
        beanService.testFactoryBean();
    }
}
