package com.novagroup.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novagroup.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
