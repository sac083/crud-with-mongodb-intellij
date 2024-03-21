package com.inspiron.mongocrudsachin.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspiron.mongocrudsachin.dto.StudentDto;
import com.inspiron.mongocrudsachin.dto.StudentUpdateDto;
import com.inspiron.mongocrudsachin.entity.Student;
import com.inspiron.mongocrudsachin.exception.StudentAlreadyExistsEception;
import com.inspiron.mongocrudsachin.exception.StudentNotFoundException;
import com.inspiron.mongocrudsachin.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepository;

	@Override
	public Student saveStudent(StudentDto studentDto) {
		Optional<Student> studentOptional = studentRepository.findByStudentNameAndStudentAge(studentDto.getStudentName(), studentDto.getStudentAge());
		if(studentOptional.isPresent()) {
			throw new StudentAlreadyExistsEception("Student already exists");
		}
		else {
			Student student = new Student();
			BeanUtils.copyProperties(studentDto, student);
			return studentRepository.save(student);
		}
	}

	@Override
	public Student updateStudent(StudentUpdateDto studentUpdateDto,String studentId) {
		Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
		if(studentOptional.isPresent()) {
			Student student = studentOptional.get();
			BeanUtils.copyProperties(studentUpdateDto, student);
			student.setStudentName(studentUpdateDto.getStudentName());
			student.setStudentAge(studentUpdateDto.getStudentAge());
			return studentRepository.save(student);
		}
		else {
			throw new StudentNotFoundException("Student not found");
		}
	}

	@Override
	public Student fetchStudent(String studentId) {
		Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
		if(studentOptional.isPresent()) {
			return studentOptional.get();
		}
		else {
			throw new StudentNotFoundException("Student not found");
		}
	}

	@Override
	@Transactional
	public Boolean deleteStudent(String studentId) {
		Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
		if(studentOptional.isPresent()) {
			log.info("Deleting student with id {}", studentId);
			studentRepository.delete(studentOptional.get());;
			return true;
		}
		else {
			throw new StudentNotFoundException("Student not found");
		}
	}

}
