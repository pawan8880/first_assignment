package com.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.ApiResponse;
import com.assignment.entity.Order;
import com.assignment.entity.OrderRequest;
import com.assignment.global.ConstraintViolationException;
import com.assignment.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order-service")
@Validated

public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/orders")
	public ResponseEntity<ApiResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest,
			BindingResult bindingResult) {

		logger.info("Received order creation request: {}", orderRequest);
		Order createdOrder = orderService.createOrder(orderRequest);

		logger.info("Order created successfully with ID: {}", createdOrder.getOrderId());

		if (bindingResult.hasErrors()) {
			System.out.println("inside has error");
			throw new ConstraintViolationException();
		}
		ApiResponse response = new ApiResponse(true, "Order created successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Order> getRecords(@PathVariable Long id) {
		Order orderData = orderService.getData(id);
		return ResponseEntity.ok(orderData);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Order> getForUpdate(@PathVariable Long id, @RequestBody Order update) {
		Order orderForUpdate = orderService.updateData(id, update);
		return ResponseEntity.ok(orderForUpdate);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> getDelete(@PathVariable Long id){
		 orderService.deleteRecord(id);
		return ResponseEntity.ok().build();
		
	}

}
