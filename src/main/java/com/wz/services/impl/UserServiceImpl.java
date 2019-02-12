package com.wz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.entities.User;
import com.wz.mappers.UserMapper;
import com.wz.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserMapper userMapper;

    public String selectUserById(int id) {
	
	User user = userMapper.selectByPrimaryKey(id);
	
	String tmp = "{ ";
	tmp += "id: ";
	tmp += user.getId();
	tmp += "; ";
	tmp += "username: ";
	tmp += user.getUsername();
	tmp += "; ";
	tmp += "password: ";
	tmp += user.getPassword();
	tmp += "; ";
	tmp += "identity_card: ";
	tmp += user.getIdentityCard();
	tmp += "; ";
	tmp += "phone_number: ";
	tmp += user.getPhoneNumber();
	tmp += "; ";
	tmp += "job: ";
	tmp += user.getJob();
	tmp += " }";
	
	return tmp;
    }

}
