package telran.java31.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import telran.java31.student.dao.StudentRepository;
import telran.java31.student.dto.ScoreDto;
import telran.java31.student.dto.StudentDto;
import telran.java31.student.dto.StudentNotFoundException;
import telran.java31.student.dto.StudentResponseDto;
import telran.java31.student.dto.StudentUpdateDto;
import telran.java31.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean addStudent(StudentDto studentDto) {
			
		if (studentRepository.existsById(studentDto.getId())) {
			Student student = new Student(studentDto.getId(), studentDto.getName(), studentDto.getPassword());
			studentRepository.save(student);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public StudentResponseDto deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDto findStudent(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		return studentToStudentResponseDto(student);
	}

	private StudentResponseDto studentToStudentResponseDto(Student student) {
		return new StudentResponseDto(student.getId(),
				student.getName(), student.getScores());
	}

	@Override
	public StudentDto editStudent(Integer id, StudentUpdateDto studentUpdateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addScore(Integer id, ScoreDto scoreDto) {
//		Student student = studentRepository.findById(id);
//		if (student == null)
//		{
//			throw new StudentNotFoundException(id);
//		}
//		// TODO Auto-generated method stub
//		return false;
		return false;
	}

	@Override
	public List<StudentResponseDto> findStudentsByName(String name) {
		return studentRepository.findByName(name)
				.map(this::studentToStudentResponseDto)
				.collect(Collectors.toList());
	}

	@Override
	public long countByNames(List<String> names) {
		return studentRepository.countByNameIn(names);
	}

	@Override
	public List<StudentResponseDto> findStudentsByExam(String exam, int minScore) {
		return studentRepository.findByExamScore("scores." +exam, minScore)
				.map(this::studentToStudentResponseDto)
				.collect(Collectors.toList());
	}

}
