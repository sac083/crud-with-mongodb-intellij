package com.inspiron.mongocrudsachin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inspiron.mongocrudsachin.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	public Optional<Student> findByStudentNameAndStudentAge(String studentName, Integer studentAge);

	public Optional<Student> findByStudentId(String studentId);

	public Student deleteByStudentId(String studentId);

}
