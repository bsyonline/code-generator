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
public class ControllerConfig extends CommonConfig {

    private String controllerPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init() {
        packageName = basePackage + ".controllor";
        controllerPathTemplate = System.getProperty("user.dir") + "/" + packageName.replace(".", "/") + "/" + domainName + "Controller.java";
    }

    public static void main(String[] args) {
        ControllerConfig config = new ControllerConfig();
        config.domainName = "User";
        config.basePackage = "com.rolex";
        config.init();
        System.out.println(config.controllerPathTemplate);
    }
}
