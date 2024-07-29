package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface diningrepo extends JpaRepository<Model7, Long> {
	@Query(value="SELECT s FROM Model7 s WHERE s.Reqphone=:Reqphone")
	List<Model7> findAllByReqphone(@Param("Reqphone") String reqphone);
	
	 @Transactional
	 @Modifying
	 @Query("DELETE FROM Model7 s WHERE s.Reqphone=:Reqphone")
	 void deleteByReqphone(@Param("Reqphone") String reqphone);
}
