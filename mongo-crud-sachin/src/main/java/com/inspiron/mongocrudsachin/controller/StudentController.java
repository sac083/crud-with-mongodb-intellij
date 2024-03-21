package com.inspiron.mongocrudsachin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspiron.mongocrudsachin.dto.StudentDto;
import com.inspiron.mongocrudsachin.dto.StudentUpdateDto;
import com.inspiron.mongocrudsachin.entity.Student;
import com.inspiron.mongocrudsachin.response.SuccessResponse;
import com.inspiron.mongocrudsachin.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
	private final StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<SuccessResponse<Student>> saveStudent(@RequestBody StudentDto studentDto) {
		return ResponseEntity.ok(SuccessResponse.<Student>builder().error(false).data(studentService.saveStudent(studentDto))
				.message("Student saved successfully").build());

	}
	@PutMapping("/update/{studentId}")
	public ResponseEntity<SuccessResponse<Student>> updateStudent(@RequestBody StudentUpdateDto studentUpdateDto, @PathVariable("studentId") String studentId) {
		return ResponseEntity.ok(SuccessResponse.<Student>builder().error(false).data(studentService.updateStudent(studentUpdateDto, studentId))
				.message("Student updated successfully").build());

	}
	
	@GetMapping("/get/{studentId}")
	public ResponseEntity<SuccessResponse<Student>> fetchStudent(@PathVariable("studentId") String studentId) {
		return ResponseEntity.ok(SuccessResponse.<Student>builder().error(false).data(studentService.fetchStudent(studentId))
				.message("Student fetched successfully").build());

	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<SuccessResponse<Boolean>> deleteStudent(@PathVariable("studentId") String studentId) {
		return ResponseEntity.ok(SuccessResponse.<Boolean>builder().error(false).data(studentService.deleteStudent(studentId))
				.message("Student delete successfully").build());

	}
}
