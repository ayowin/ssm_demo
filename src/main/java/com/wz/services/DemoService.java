package com.wz.services;

import com.wz.entities.User;

public interface DemoService {
    
    // 增
    boolean insert(User user);
    
    // 删
    boolean delete(int id);
    
    // 改
    boolean update(User user);
    
    // 查
    User selectUserById(int id);
}
