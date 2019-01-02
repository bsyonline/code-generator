package com.rolex.engine;

import com.rolex.config.GlobalConfig;

import java.io.IOException;

/**
 * @author rolex
 * @since 2018
 */
public interface TemplateEngine {

    void writer(GlobalConfig config) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
