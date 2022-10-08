package com.gong_redis.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.test.Test01
 * @Date: 2022年10月06日 16:55
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        Object w = 1234567890;
        int i = 1234567890;
        String e = "1234567890";
        System.out.println(i);
        Integer q = 1;
        if (i == q) {
            System.out.println("123");
        } else {
            System.out.println("111");
        }

        byte aa = 1;
        byte bb = 2;
        System.out.println(aa == bb);

        boolean a = true;
        boolean b = false;
        System.out.println(a == b);

        //同类型之间比较
        System.out.println(i == q);
        //int  与  object之间比较
        System.out.println(w.equals(i));
        //String之间相互比较
        /*
        equals与==之间的对比
         */
        //整形与整形
        System.out.println("整形与整形" + q.equals(1));

        //字符串与字符串
        System.out.println(e.equals("1234567890"));

        //字符转与字符串
        System.out.println(e == "1234567890");
    }
}

/**
 * 同步线程
 */
@Component
class SyncThread implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
