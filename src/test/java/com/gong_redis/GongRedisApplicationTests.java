package com.gong_redis;

import com.gong_redis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GongRedisApplicationTests {

    public static String getType(Object object){
        return object.getClass().getName().toString();
    }
    @Test
    void contextLoads() {
//        Object i=1;
//        Object a="qwe";
//        System.out.println(getType(a));
//        System.out.println(getType(i));
    }

}
