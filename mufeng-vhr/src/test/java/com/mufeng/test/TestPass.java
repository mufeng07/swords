package com.mufeng.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/8/4 15:17
 */
public class TestPass {
    @Test
    public void test1(){
        String pass = "123";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);
        //$2a$10$3eCPyR5HRQCl5nOJSJxR.O0Mxs057AIsvg0kpZDRO8/UgFJwWjHaO
        boolean f = bcryptPasswordEncoder.matches("admin",hashPass);
        System.out.println(f);

    }
}
