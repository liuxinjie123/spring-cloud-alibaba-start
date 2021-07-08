package com.alibaba.cloud.examples.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Order implements Serializable {

	/**
	 * id.
	 */
	public long id;

	/**
	 * user id.
	 */
	public String userId;

	/**
	 * commodity code.
	 */
	public String commodityCode;

	/**
	 * count.
	 */
	public int count;

	/**
	 * money.
	 */
	public int money;

}
