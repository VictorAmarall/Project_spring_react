package com.victoramaral.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoramaral.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
	

}
