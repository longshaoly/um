package com.um.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.um.test.service.impl.UserServiceImpl;

@RequestMapping("/test")
@Controller  
public class TestController {
	
	@Autowired
	UserServiceImpl userService;
	
    @ResponseBody
    @RequestMapping(value ="/test1")  
    public JSONObject test(HttpServletRequest request,HttpServletResponse response) { 
		JSONObject result =new JSONObject();
        Map<String,String> testMap =new HashMap<>();
        testMap.put("test", "111");
        result.put("result", testMap);
        return result;  
    }
    
    @ResponseBody
    @RequestMapping(value ="/test2")  
    public JSONObject findUserById(HttpServletRequest request,HttpServletResponse response) { 
		JSONObject result =new JSONObject();
		//查询数据
        result.put("refdsfsdssultr232422242esult",userService.getUser(1));
        return result;  
    } 
}
