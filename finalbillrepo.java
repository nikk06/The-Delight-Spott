package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface finalbillrepo extends  JpaRepository<Model11, Long>{
	/*
	@Query(value="SELECT s FROM Model5 s WHERE s.Dishname= :Dishname")
	List<Model5>findAllByDishname(@Param("Dishname")String dishname);
	*/
	@Query(value="Select s From Model11 s Where s.phoneno= :phoneno")
	List<Model11>findAllByPhoneno(@Param("phoneno")String Phoneno);
	/*
	  @Transactional
	 @Modifying
	 @Query("DELETE FROM Model9 s WHERE s.tphone=:tphone")
	 int deleteByTphone(@Param("tphone")String Tphone);
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Model11 s WHERE s.phoneno= :phoneno")
	int deleteByPhoneno(@Param("phoneno")String Phoneno);
}
