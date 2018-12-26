/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.codegen;

import com.google.common.collect.Lists;
import com.rolex.config.*;
import com.rolex.engine.TemplateEngine;
import com.rolex.engine.VelocityTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author rolex
 * @since 2018
 */
@Component
public class CodeGenerator1 {
    
    Config config;
    @Autowired
    DBUtil dbUtil;
    TemplateEngine templateEngine;
    
    public void test() throws IOException {
        
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("rolex");
        globalConfig.setBasePackage("com.rolex");
        globalConfig.setCopyright("2018 bsyonline");
        globalConfig.setDomainName("User");
        globalConfig.setSince("2018");
        
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/test2");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setType("mysql");
        
        DomainConfig domainConfig = new DomainConfig();
        domainConfig.setImports(Lists.newArrayList());
        domainConfig.setPackageName("dao.domain");
        
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(true);
        
        OutputConfig outputConfig = new OutputConfig();
        outputConfig.setOutputPath("src/main/resources/");
        
        globalConfig.domainConfig(domainConfig)
            .dataSourceConfig(dataSourceConfig)
            .templateConfig(templateConfig)
            .outputConfig(outputConfig);
        
        globalConfig.init();
    
        globalConfig.getConfigMap().entrySet().forEach(kv-> System.out.println(kv.getKey() + "\t" + kv.getValue()));
    
        TemplateEngine engine = new VelocityTemplateEngine();
        engine.writer(config);
    }
    
}
