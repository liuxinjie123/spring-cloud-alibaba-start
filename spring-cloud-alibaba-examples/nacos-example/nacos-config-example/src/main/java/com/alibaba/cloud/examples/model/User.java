package com.alibaba.cloud.examples.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;

    private String hr;

    private String avg;
}
