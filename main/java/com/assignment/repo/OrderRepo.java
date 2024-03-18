package com.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
