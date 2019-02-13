package com.wz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wz.entities.User;
import com.wz.log4j.Log;
import com.wz.services.UserService;

@Controller
public class SpringmvcController {

    @Autowired
    UserService userServiceImpl;

    @RequestMapping(value="/springmvc")
    public String springmvc() {
	return "springmvc";
    }

    @ResponseBody
    @RequestMapping(value="/insert")
    public String insert() {

	User user = new User();
	user.setId(4);
	user.setUsername("小东");
	user.setPassword("xiaodong");
	user.setIdentityCard("12345");
	user.setPhoneNumber("54321");
	user.setJob("研发部经理");

	try {
	    userServiceImpl.insert(user);
	    return "insert success";	    
	} catch (Exception e) {
	    return "insert failed,may be user that id=4 existed.";
	}
    }

    @ResponseBody
    @RequestMapping(value="/update")
    public String update() {

	try {
	    User user = userServiceImpl.selectUserById(4);
	    user.setUsername("大东");
	    user.setJob("小兵");
	    userServiceImpl.update(user);
	    return "update success";	    
	} catch (Exception e) {
	    return "update failed,user that id=4 is not exist.";
	}
    }

    @ResponseBody
    @RequestMapping(value="/select",produces="text/plain;charset=UTF-8",method=RequestMethod.GET)
    public String select() {

	try {
	    User user = userServiceImpl.selectUserById(4);
	    String tmp = "select success! \n";
	    tmp += "User: \n";
	    tmp += "id: ";
	    tmp += user.getId();
	    tmp += "\n";
	    tmp += "username: ";
	    tmp += user.getUsername();
	    tmp += "\n";
	    tmp += "password: ";
	    tmp += user.getPassword();
	    tmp += "\n";
	    tmp += "identity_card: ";
	    tmp += user.getIdentityCard();
	    tmp += "\n";
	    tmp += "phone_number: ";
	    tmp += user.getPhoneNumber();
	    tmp += "\n";
	    tmp += "job: ";
	    tmp += user.getJob();
	    tmp += "\n";

	    return tmp; 
	} catch (Exception e) {
	    return "Seleted failed,user that id=4 is not exist.";
	}
    }

    @ResponseBody
    @RequestMapping(value="/delete")
    public String delete() {

	userServiceImpl.delete(4);	    
	return "delete success";
    }
}
