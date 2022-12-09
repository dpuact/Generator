package com.bijw.generator.common.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class GenerateExecutor {
    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("demo_user");    //数据库表名


        FastAutoGenerator.create("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true","root","")
                .globalConfig(builder -> {
                    builder.author("bijw")               //作者
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java")    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                            .disableOpenDir();
//                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {
                    builder.parent("com.bijw.generator")
                            .moduleName("")     //${package.
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    //配置要生成的表
                    builder.addInclude(tables)
                            //过滤表名前缀
                            .addTablePrefix("")
                            //service策略配置
                            .serviceBuilder()
                            //service类名，%s适配，根据表明替换
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            //实体策略配置
                            .entityBuilder()
                            //开始lombok
                            .enableLombok()
                            //说明逻辑删除是哪个字段
                            .logicDeleteColumnName("is_deleted")
                            //属性加上说明注释
                            .enableTableFieldAnnotation()
                            //controller策略配置
                            .controllerBuilder()
                            // 映射路径使用连字符格式，而不是驼峰
                            .enableHyphenStyle()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            //mapper策略配置
                            .mapperBuilder()
                            //生成通用的resultMap
                            .enableBaseResultMap()
                            //继承哪个父类
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            //@Mapper开启
                            .enableMapperAnnotation()
                            //xml名
                            .formatXmlFileName("%sMapper");
                })
                .templateConfig(new Consumer<TemplateConfig.Builder>() {
                    @Override
                    public void accept(TemplateConfig.Builder builder) {
                        // 类使用自定义模板
                        builder.entity("templates/entity.java");
                        builder.controller("templates/controller.java");
                        builder.service("templates/service.java");
                        builder.serviceImpl("templates/serviceImpl.java");
                    }
                })
                .templateEngine(new FreemarkerTemplateEngine())// 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
