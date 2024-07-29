package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RestroRepo extends JpaRepository<Model2,Long>  {
	
	@Query(value="SELECT s FROM Model2 s WHERE s.Remaill=:Remaill AND s.Rpasssowrd=:Rpasssowrd")
	Model2 findByRemaillAndRpasssowrd(@Param("Remaill") String remaill,@Param("Rpasssowrd")String rpasssowrd);
	
	@Modifying
	@Transactional
	@Query("UPDATE Model2 s SET s.Rpasssowrd= ?2 WHERE s.Remaill= ?1")
   int updatePasswordByEmail(String Remaill,String Rpasssowrd);
}
