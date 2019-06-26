package com.danghuy.controller;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CustomLoader implements ResourceLoaderAware{
    private ResourceLoader resource;
    public void setResourceLoader(ResourceLoader resourceLoader) {
        resource = resourceLoader;
    }
    public Resource getResource(String url){

        return resource.getResource(url);
    }
}
