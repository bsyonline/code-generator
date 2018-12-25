/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import lombok.Data;

import java.util.List;

/**
 * @author rolex
 * @since 2018
 */
@Data
public class DomainConfig extends GlobalConfig {

    private String controllerPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init() {
        packageName = basePackage + ".dao.domain";
        controllerPathTemplate = System.getProperty("user.dir") + "/" + packageName.replace(".", "/") + "/" + domainName + "Entity.java";
    }

    public static void main(String[] args) {
        DomainConfig config = new DomainConfig();
        config.domainName = "User";
        config.basePackage = "com.rolex";
        config.init();
        System.out.println(config.controllerPathTemplate);
    }
}
