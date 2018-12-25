/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import lombok.Data;

/**
 * @author rolex
 * @since 2018
 */
@Data
public class DataSourceConfig {

    String type;
    String driverName;
    String username;
    String password;
    String url;

}
