package com.alibaba.cloud.examples.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Order implements Serializable {

	/**
	 * order id.
	 */
	private long id;

	/**
	 * user id.
	 */
	private String userId;

	/**
	 * commodity code.
	 */
	private String commodityCode;

	/**
	 * count.
	 */
	private int count;

	/**
	 * money.
	 */
	private int money;


}
