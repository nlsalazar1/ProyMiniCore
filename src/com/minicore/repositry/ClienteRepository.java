package com.minicore.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minicore.model.cliente;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Integer>{

}
