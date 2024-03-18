package com.assignment.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long orderId;
    private String orderName;
    private BigDecimal amount;
	public Order(Long orderId, String orderName, BigDecimal amount) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.amount = amount;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    

}
