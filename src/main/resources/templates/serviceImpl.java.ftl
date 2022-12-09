package com.bijw.generator.service.impl;

import ${package.Entity}.${entity};
import ${package.Mapper}.${entity}Mapper;
import ${package.Service}.${entity}Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ${entity}ServiceImpl extends ServiceImpl<${entity}Mapper, ${entity}> implements ${entity}Service {

}