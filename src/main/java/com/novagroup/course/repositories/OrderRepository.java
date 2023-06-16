package com.novagroup.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novagroup.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
