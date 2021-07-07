package com.alibaba.cloud.examples.config;

import com.alibaba.cloud.examples.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "user")
@Data
@NoArgsConstructor
public class UserConfig implements Serializable {
    private static final long serialVersionUID = 6538373437565784001L;

    private int age;

    private String name;

    private String hr;

    private Map<String, Object> map;

    private List<User> users;


}