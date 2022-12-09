package com.bijw.generator.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bijw.generator.entity.DemoUser;
import com.bijw.generator.mapper.DemoUserMapper;
import com.bijw.generator.service.DemoUserService;
import org.springframework.stereotype.Service;

/**
* <p>
    *  服务实现类
* </p>
*
* @author bb
* @since 2022-10-19
*/
@Service
@DS("master")
public class DemoUserServiceImpl extends ServiceImpl<DemoUserMapper, DemoUser> implements DemoUserService {

    public void test(){

    }
}