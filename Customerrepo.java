package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Customerrepo extends JpaRepository<Model4, Long>{
	//@Query(value="SELECT s FROM Model2 s WHERE s.Remaill=:Remaill AND s.Rpasssowrd=:Rpasssowrd")
	//Model2 findByRemaillAndRpasssowrd(@Param("Remaill") String remaill,@Param("Rpasssowrd")String rpasssowrd);
	@Query(value="SELECT s FROM Model4 s WHERE s.Cemaill=:Cemaill AND s.Cpasssowrd=:Cpasssowrd")
	Model4 findByCemaillAndCpasssowrd(@Param("Cemaill")String cemaill, @Param("Cpasssowrd") String cpasssowrd);
	
	 @Modifying
	@Transactional
	@Query("UPDATE Model4 s SET s.Cpasssowrd= ?2 WHERE s.Cemaill= ?1")
	 int updatePasswordByEmail1(String Cpasssowrd, String Cemaill);
	
}
