package com.wz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wz.log4j.Log;
import com.wz.services.UserService;

@Controller
public class SpringmvcController {
    
    @Autowired
    UserService userServiceImpl;
    
    @RequestMapping(value="/springmvc")
    public String springmvc() {
	
	Log.d(userServiceImpl.selectUserById(2));
	
	return "springmvc";
    }
}
