package com.bijw.generator.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bijw.generator.common.exception.BusinessException;
import com.bijw.generator.common.utils.Result;
import com.bijw.generator.entity.DemoUser;
import com.bijw.generator.service.DemoUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* <p>
    *  前端控制器
* </p>
*
* @author bijw
* @since 2022-12-07
*/
@Api(tags = "管理")
@RestController
@RequestMapping("/demo-user")
public class DemoUserController {

    @Autowired
    private DemoUserService demoUserService;

    @Autowired
    private BaseMapper baseMapper;

    /**
    * 列表
    */
    @GetMapping("/list")
    public Object list(@PathVariable Long page,@PathVariable Long limit){
        try {
            PageHelper.startPage(1,2);
            //调用service的方法实现查询所有的操作
            List<DemoUser> list = demoUserService.list(null);
            PageInfo<DemoUser> pageInfo = new PageInfo<>(list);
            Map<String,Object> result = new HashMap<>();
            result.put("data", pageInfo.getList());
            result.put("total", pageInfo.getTotal());
            return Result.success("查询成功",result);
        }catch (Exception e){
            throw new BusinessException("111");
        }
    }

    //根据id查询
    @GetMapping("getById/{id}")
    public Object getById(@PathVariable String id) {
        DemoUser demoUser = demoUserService.getById(id);
        return demoUser;
    }


    /**
    * 保存
    */
    @PostMapping("/save")
    public void save(@RequestBody DemoUser demoUser){
        demoUserService.save(demoUser);
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    public void update(@RequestBody DemoUser demoUser){
        demoUserService.updateById(demoUser);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        demoUserService.removeById(id);
    }
}
