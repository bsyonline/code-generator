/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import java.util.HashMap;

/**
 * @author rolex
 * @since 2018
 */
public interface Config {

    HashMap<String, String> configMap();

    String outputPath();

    TemplateConfig template();
}
