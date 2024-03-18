package com.assignment.entity;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OrderRequest {
	@NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount should be greater than 0")
 private BigDecimal amount;

 @NotNull(message = "Order name is required")
 @Size(max = 200, message = "Order name must not exceed 200 characters")
 //@Pattern(regexp = ^[A-Za-z]+$, message = "Order name should contain only alphabets")
 @Pattern(regexp = "^[A-Za-z]+$", message = "Order name should contain only alphabets")
 private String orderName;

 

 
 
 

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public String getOrderName() {
	return orderName;
}

public void setOrderName(String orderName) {
	this.orderName = orderName;
}



public OrderRequest(BigDecimal amount, String orderName) {
	super();
	this.amount = amount;
	this.orderName = orderName;
}

public OrderRequest() {
	super();
	// TODO Auto-generated constructor stub
}

 
}
