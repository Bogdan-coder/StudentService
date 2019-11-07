package telran.java31.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.java31.student.dto.ScoreDto;
import telran.java31.student.dto.StudentDto;
import telran.java31.student.dto.StudentResponseDto;
import telran.java31.student.dto.StudentUpdateDto;
import telran.java31.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public boolean addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}
	
	@DeleteMapping("/student/{id}")
	public StudentResponseDto removeStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/student/{id}")
	public StudentResponseDto findStudent(@PathVariable int id) {
		return studentService.findStudent(id);
	}
	
	@PutMapping("/student/{id}")
	public StudentDto editStudent(@PathVariable int id,
			@RequestBody StudentUpdateDto studentUpdateDto) {
		return studentService.editStudent(id, studentUpdateDto);
	}
	
	@PutMapping("/score/student/{id}")
	public boolean addScore(int id, ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}

	@GetMapping("/students/name/{name}")
	public List<StudentResponseDto> findStudentsByName(@PathVariable String name)
	{
		return studentService.findStudentsByName(name);
	}

	
	@GetMapping("/students/names")
public long countStudentsByNames(@RequestBody List<String> names)
{
	return studentService.countByNames(names);
}

	@GetMapping("/students/score/{exam}/min/{score}")
	public List<StudentResponseDto> findStudentsByExamScore(@PathVariable String exam, @PathVariable int score)
	{
		return studentService.findStudentsByExam(exam, score);
	}
}
