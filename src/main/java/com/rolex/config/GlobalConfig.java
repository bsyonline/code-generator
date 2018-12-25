/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import com.google.common.collect.Maps;
import lombok.Data;

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

    public Map<String, String> getConfiguration() {
        Map<String, String> map = Maps.newHashMap();
        return map;
    }
}
