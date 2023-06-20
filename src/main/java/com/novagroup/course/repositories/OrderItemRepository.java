package com.novagroup.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novagroup.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
