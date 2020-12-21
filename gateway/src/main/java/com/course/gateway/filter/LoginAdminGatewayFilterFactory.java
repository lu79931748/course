package com.course.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import javax.annotation.Resource;

/**
 * Created by luwf on 2020/12/21
 */
public class LoginAdminGatewayFilterFactory extends AbstractGatewayFilterFactory<Object>{

    @Resource
    LoginAdminGatewayFilter loginAdminGatewayFilter;

    @Override
    public GatewayFilter apply(Object config) {
        return loginAdminGatewayFilter;
    }
}
