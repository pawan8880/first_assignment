package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Order;
import com.assignment.entity.OrderRequest;
import com.assignment.global.NoSuchElementException;
import com.assignment.repo.OrderRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	@Autowired
	OrderRepo repo;

	public Order createOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderName(orderRequest.getOrderName());
		order.setAmount(orderRequest.getAmount());
		return repo.save(order);
	}
//save record in db

	/*
	 * public Order getData(long id) { try { Order orderData =
	 * repo.findById(id).get();
	 * System.out.println("order found -> "+orderData.toString()); return orderData;
	 * } catch (Exception e) { // TODO: handle exception
	 * System.out.println("order data not found."); throw new
	 * NoSuchElementException("Order not found for id: " + id); }
	 * 
	 * }
	 */

	public Order getData(long id) {
		return repo.findById(id).orElseThrow(() -> {
			System.out.println("order data not found");
			return new NoSuchElementException("Order not found for id: " + id);
		});
	}
//get data by id

	public Order updateData(Long id, Order update) {
		Order od = repo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
		od.setOrderName(update.getOrderName());
		od.setAmount(update.getAmount());
		return repo.save(od);
	}

	public void  deleteRecord(Long id) {
		 
		 if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("Record not found id: "+id);
		 }
		 else {
			 repo.deleteById(id);
		 }
			 
	}

}
