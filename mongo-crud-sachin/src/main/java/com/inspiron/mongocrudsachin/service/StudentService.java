package com.inspiron.mongocrudsachin.service;

import org.springframework.stereotype.Service;

import com.inspiron.mongocrudsachin.dto.StudentDto;
import com.inspiron.mongocrudsachin.dto.StudentUpdateDto;
import com.inspiron.mongocrudsachin.entity.Student;

public interface StudentService {

	public Student saveStudent(StudentDto studentDto);

	public Student updateStudent(StudentUpdateDto studentUpdateDto, String studentId);

	public Student fetchStudent(String studentId);

	public Boolean deleteStudent(String studentId);

}
