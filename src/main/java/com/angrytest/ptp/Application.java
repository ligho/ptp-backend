package com.angrytest.ptp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * main:SpringBoot 入口 <br/>
     * @param args 入口参数
     */
    public static void main(String[] args)  {
        LOGGER.info("Starting.");
        ApplicationContext ctx = SpringApplication.run(Application.class,args);
        LOGGER.info("Start success."+ctx.getBeanDefinitionCount()+"beans start.");
    }

}