package com.victoramaral.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoramaral.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
