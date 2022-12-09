package ${package.Controller};

import java.util.*;
import com.bijw.generator.common.utils.R;
import io.swagger.annotations.Api;
import ${package.Entity}.${entity};
import ${package.Service}.${entity}Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
* </p>
*
* @author ${author}
* @since ${date}
*/
@Api(tags = "管理")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Autowired
    private ${table.entityName}Service ${table.entityPath}Service;

    /**
    * 列表
    */
    @GetMapping("/list")
    public Object list(){
        //调用service的方法实现查询所有的操作
        List<${entity}> list = ${table.entityPath}Service.list(null);
        return list;
    }

    //根据id查询
    @GetMapping("getById/{id}")
    public Object getById(@PathVariable String id) {
        ${entity} ${table.entityPath} = ${table.entityPath}Service.getById(id);
        return ${table.entityPath};
    }


    /**
    * 保存
    */
    @PostMapping("/save")
    public void save(@RequestBody ${entity} ${table.entityPath}){
        ${table.entityPath}Service.save(${table.entityPath});
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    public void update(@RequestBody ${entity} ${table.entityPath}){
        ${table.entityPath}Service.updateById(${table.entityPath});
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        ${table.entityPath}Service.removeById(id);
    }
}
</#if>