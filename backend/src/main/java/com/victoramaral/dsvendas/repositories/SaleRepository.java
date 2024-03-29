package com.victoramaral.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.victoramaral.dsvendas.DTO.SaleSuccessDTO;
import com.victoramaral.dsvendas.DTO.SaleSumDTO;
import com.victoramaral.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.victoramaral.dsvendas.DTO.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+"FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.victoramaral.dsvendas.DTO.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+"FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
