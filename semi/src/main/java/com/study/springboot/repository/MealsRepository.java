package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Meals;

public interface MealsRepository extends JpaRepository<Meals, Long> {
}