package com.alibaba.cloud.examples.config;

import com.alibaba.cloud.examples.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "user")
@Configuration
@Data
@NoArgsConstructor
public class UserConfig {

    private int age;

    private String name;

    private String hr;

    private Map<String, Object> map;

    private List<User> users;


}