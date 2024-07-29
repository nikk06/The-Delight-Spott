package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Menurepo extends JpaRepository<Model5,Long>{
	@Query(value="SELECT s FROM Model5 s WHERE s.Dishname= :Dishname")
	List<Model5>findAllByDishname(@Param("Dishname")String dishname);
	 @Transactional
	 @Modifying
	 @Query("DELETE FROM Model5 s WHERE s.Dishname=:Dishname")
	 int deleteByDishname(@Param("Dishname")String dishname);
	 
	 @Query(value="SELECT s. DishPrice FROM Model5 s WHERE s.Dishname= :Dishname AND s.DishQuantity= :DishQuantity")
	 String findDishPricebyDishnameAndDishQuantity(@Param("Dishname")String dishname,@Param("DishQuantity")String dishQuantity);
    
}