package com.student.dal.studentDAL.repositories;

import org.springframework.data.repository.CrudRepository;

import com.student.dal.studentDAL.entities.Student;

public interface StudentRepository extends CrudRepository<Student , Long>{

}
