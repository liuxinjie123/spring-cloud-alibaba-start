package com.alibaba.cloud.examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foo implements Serializable {
	private static final long serialVersionUID = -7401522271810744924L;

	private int id;

	private String bar;

}
