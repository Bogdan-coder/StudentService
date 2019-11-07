package telran.java31.student.service;

import java.util.List;

import telran.java31.student.dto.ScoreDto;
import telran.java31.student.dto.StudentDto;
import telran.java31.student.dto.StudentResponseDto;
import telran.java31.student.dto.StudentUpdateDto;

public interface StudentService {

	boolean addStudent(StudentDto studentDto);

	StudentResponseDto deleteStudent(Integer id);

	StudentResponseDto findStudent(Integer id);

	StudentDto editStudent(Integer id, StudentUpdateDto studentUpdateDto);

	boolean addScore(Integer id, ScoreDto scoreDto);
	
	List<StudentResponseDto> findStudentsByName(String name);
	
	long countByNames(List<String> names);

	List<StudentResponseDto> findStudentsByExam(String exam, int minScore);
}
