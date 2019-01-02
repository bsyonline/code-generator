/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.velocity.app.VelocityEngine;

import java.util.List;
import java.util.Map;

/**
 * @author rolex
 * @since 2018
 */
@Data
public class GlobalConfig {
    
    protected String domainName;
    protected String basePackage;
    protected String copyright;
    protected String author;
    protected String since;
    List<String> generateCodeTables;
    
    ControllerConfig controllerConfig;
    DomainConfig domainConfig;
    ServiceConfig serviceConfig;
    ServiceImplConfig serviceImplConfig;
    DaoConfig daoConfig;
    
    TemplateConfig templateConfig;
    DataSourceConfig dataSourceConfig;
    OutputConfig outputConfig;
    
    VelocityEngine engine;
    
    Map<String, Object> configMap = Maps.newHashMap();
    
    public void init() {
        configMap.put("domainName", domainName);
        configMap.put("basePackage", basePackage);
        configMap.put("copyright", copyright);
        configMap.put("author", author);
        configMap.put("since", since);
        
        if (templateConfig.isEntity()) {
            configMap.put("domain.packageName", basePackage + "." + domainConfig.getPackageName());
            configMap.put("domain.imports", domainConfig.getImports());
            configMap.put("domain.templatePath", domainConfig.getTemplatePath());
            configMap.put("domain.entityPath", outputConfig.getOutputPath() + (basePackage + "." + domainConfig.getPackageName()).replace(".", "/") + "/" + domainName + "Entity.java");
        }
        if (templateConfig.isController()) {
            configMap.put("controller.packageName", basePackage + "." + controllerConfig.getPackageName());
            configMap.put("controller.imports", controllerConfig.getImports());
            configMap.put("controller.templatePath", domainConfig.getTemplatePath());
            configMap.put("controller.entityPath", outputConfig.getOutputPath() + (basePackage + "." + domainConfig.getPackageName()).replace(".", "/") + "/" + domainName + "Controller.java");
        }
        if (templateConfig.isService()) {
            configMap.put("service.packageName", basePackage + "." + serviceConfig.getPackageName());
            configMap.put("service.imports", serviceConfig.getImports());
            configMap.put("service.templatePath", serviceConfig.getTemplatePath());
            configMap.put("service.entityPath", outputConfig.getOutputPath() + (basePackage + "." + serviceConfig.getPackageName()).replace(".", "/") + "/" + domainName + "Service.java");
            configMap.put("serviceImpl.packageName", basePackage + "." + serviceImplConfig.getPackageName());
            configMap.put("serviceImpl.imports", serviceImplConfig.getImports());
            configMap.put("serviceImpl.templatePath", serviceImplConfig.getTemplatePath());
            configMap.put("serviceImpl.entityPath", outputConfig.getOutputPath() + (basePackage + "." + serviceImplConfig.getPackageName()).replace(".", "/") + "/" + domainName + "ServiceImp.java");
        }
        if (templateConfig.isDao()) {
            configMap.put("dao.packageName", basePackage + "." + daoConfig.getPackageName());
            configMap.put("dao.imports", daoConfig.getImports());
            configMap.put("dao.templatePath", daoConfig.getTemplatePath());
            configMap.put("dao.entityPath", outputConfig.getOutputPath() + (basePackage + "." + daoConfig.getPackageName()).replace(".", "/") + "/" + domainName + "Repository.java");
        }
        
        
        configMap.put("outputPath", outputConfig.getOutputPath());
        
        configMap.put("db.url", dataSourceConfig.getUrl());
        configMap.put("db.username", dataSourceConfig.getUsername());
        configMap.put("db.password", dataSourceConfig.getPassword());
        configMap.put("db.driverName", dataSourceConfig.getDriverName());
        configMap.put("db.generateCodeTables", generateCodeTables);
        configMap.put("db.type", "mysql");
        configMap.put("db.infoClass", "com.rolex.db.MySQLInfo");
        
        
    }
    
    public GlobalConfig domainConfig(DomainConfig domainConfig) {
        this.domainConfig = domainConfig;
        return this;
    }
    
    public GlobalConfig templateConfig(TemplateConfig templateConfig) {
        this.templateConfig = templateConfig;
        return this;
    }
    
    public GlobalConfig dataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
        return this;
    }
    
    public GlobalConfig outputConfig(OutputConfig outputConfig) {
        this.outputConfig = outputConfig;
        return this;
    }
}
