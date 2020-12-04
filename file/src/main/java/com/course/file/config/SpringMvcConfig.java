package com.course.file.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by luwf on 2020/10/30
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Value("${file.path}")
    private String FILE_PATH;

    @Value("${file.mac.path}")
    private String FILE_MAC_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            registry.addResourceHandler("/f/**").addResourceLocations("file:" + FILE_PATH);
        } else {  //linux 和mac
            registry.addResourceHandler("/f/**").addResourceLocations("file:" + FILE_MAC_PATH);
        }
    }
    //http://127.0.0.1:9003/file/f/course/teacher/HNBOaUOW-tupian.jpg
}
