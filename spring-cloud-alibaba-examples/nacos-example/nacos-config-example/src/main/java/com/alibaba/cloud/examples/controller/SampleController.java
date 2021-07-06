package com.alibaba.cloud.examples.controller;

import com.alibaba.cloud.examples.config.UserConfig;
import com.alibaba.cloud.nacos.NacosConfigManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class SampleController {
    @Resource
    private UserConfig userConfig;
    @Resource
    private NacosConfigManager nacosConfigManager;
    @Resource
    private Environment environment;
    @Value("${user.name:zz}")
    String userName;
    @Value("${user.age:25}")
    Integer age;

    @GetMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age + " [UserConfig]: "
                + userConfig + "!" + nacosConfigManager.getConfigService();
    }

    @GetMapping("/get/{name}")
    public String getValue(@PathVariable String name) {
        return String.valueOf(environment.getProperty(name));
    }

    @GetMapping("/bool")
    public boolean bool() {
        return (Boolean) (userConfig.getMap().get("2"));
    }

}

