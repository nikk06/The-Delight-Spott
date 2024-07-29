package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
public interface repo1 extends JpaRepository<Model9, Long> {
	/*
	 @Query(value="SELECT s FROM Model7 s WHERE s.Reqphone=:Reqphone")
	List<Model7> findAllByReqphone(@Param("Reqphone") String reqphone);
	 */
	
	@Query(value="SELECT s FROM Model9 s WHERE s.tableNo= :tableNo")
	List<Model9>findAllByTableNo(@Param("tableNo")String table);
	
	
	 @Transactional
	 @Modifying
	 @Query("DELETE FROM Model9 s WHERE s.tphone=:tphone")
	 int deleteByTphone(@Param("tphone")String Tphone);
	 
}
