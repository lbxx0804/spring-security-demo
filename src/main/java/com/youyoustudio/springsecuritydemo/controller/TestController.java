package com.youyoustudio.springsecuritydemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("test")
    public void test(Page page,String userName){
        System.out.println(page);
        System.out.println(userName);
    }
}
