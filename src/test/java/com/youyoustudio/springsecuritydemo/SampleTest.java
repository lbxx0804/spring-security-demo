package com.youyoustudio.springsecuritydemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youyoustudio.springsecuritydemo.entity.User;
import com.youyoustudio.springsecuritydemo.mapper.UserMapper;
import com.youyoustudio.springsecuritydemo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testPagtion(){
        Page<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        IPage<User> userIPage = userMapper.selectPageVo(page,18);
        userIPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("aaa");
        user.setAge(20);
        user.setEmail("aaaa@bbbb.com");
        userService.save(user);
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(6, userList.size());
        userList.forEach(System.out::println);
    }
}
