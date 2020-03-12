package com.student.dal.studentDAL.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.dal.studentDAL.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location , Integer>{ 
	@Query("select type,count(type) from Location group by type")
	public List<Object[]> findTypeAndTypeCount();

}
