package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.domain.User;
import com.example.mybatisplus.service.UserService;
import com.example.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 29382
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-10-30 15:40:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




