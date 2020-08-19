package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.TaxEntity;

public interface TaxReposiotry extends JpaRepository<TaxEntity, Long> {

}
