package com.wz.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.entities.User;
import com.wz.mappers.UserMapper;
import com.wz.services.DemoService;

@Service
public class DemoServiceImpl implements DemoService{
    
    private static final Logger logger = (Logger) LogManager.getLogger(DemoServiceImpl.class);
    
    @Autowired
    private UserMapper userMapper;

    public boolean insert(User user) {
	
	int result = userMapper.insert(user);
	
	if(result > 0)
	    return true;
	else
	    return false;
    }

    public boolean delete(int id) {
	
	int result = userMapper.deleteByPrimaryKey(id);
	
	if(result > 0)
	    return true;
	else
	    return false;
    }

    public boolean update(User user) {
	
	int result = userMapper.updateByPrimaryKey(user);
	
	if(result > 0)
	    return true;
	else
	    return false;
    }

    public User selectUserById(int id) {
	return userMapper.selectByPrimaryKey(id);
    }
}
