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
public class ServiceConfig {
    
    private String servicePath;
    private String packageName;//包名称
    private List<String> imports;//所引入的包
    private String templatePath = "template/entity.java.vm";

}
