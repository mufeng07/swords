package com.mufeng.test;

import com.mufeng.vhr.StartVhrApplication;
import com.mufeng.vhr.mapper.HrMapper;
import com.mufeng.vhr.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/8/4 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartVhrApplication.class)
public class TestMapper {
    @Resource
    MenuMapper menuMapper;
    @Resource
    HrMapper hrMapper;
    @Test
    public void test1(){
        menuMapper.getMenusByHrId(3);
    }
    @Test
    public void test2(){
        hrMapper.selectByPrimaryKey(3);
    }
}
