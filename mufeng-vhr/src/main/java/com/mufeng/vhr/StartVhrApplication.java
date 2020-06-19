package com.mufeng.vhr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/18 16:26
 */
@SpringBootApplication
@Slf4j
public class StartVhrApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartVhrApplication.class,args);
        log.info("mufeng-vhr start success.....");
    }
}
