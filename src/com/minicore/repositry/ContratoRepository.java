package com.minicore.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minicore.model.contrato;

@Repository
public interface ContratoRepository extends JpaRepository<contrato, Integer> {

}
