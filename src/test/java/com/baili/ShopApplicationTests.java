package com.baili;

import com.alibaba.fastjson.JSON;
import com.baili.pojo.TbUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class ShopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        TbUser tbUser = new TbUser();
        tbUser.setUserId(1);
        tbUser.setUserName("zhangsan");

        TbUser tbUser1 = new TbUser();
        tbUser1.setUserId(2);
        tbUser1.setUserName("lisi");

        List<TbUser> tbUsers = new LinkedList<>();
        tbUsers.add(tbUser);
        tbUsers.add(tbUser1);

        System.out.println(tbUsers);

        stringRedisTemplate.opsForValue().set("test", JSON.toJSONString(tbUsers));
        String test = stringRedisTemplate.opsForValue().get("test");
        System.out.println(test);
        List<TbUser> tbUsers1 = JSON.parseArray(test, TbUser.class);
        System.out.println(tbUsers1.get(0));

    }
}
