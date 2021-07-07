package com.alibaba.cloud.examples.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 8925091178654350821L;

    private String name;

    private String hr;

    private String avg;
}
