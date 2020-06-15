package com.mufeng.blog;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/15 17:04
 */
@SpringBootApplication
@MapperScan("com.mufeng.blog.dao")
@Slf4j
public class StartBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartBlogApplication.class,args);
        log.info("first-blog start success.....");
    }
}
