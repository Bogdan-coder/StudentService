package telran.java31.student.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.java31.student.model.Student;


public interface StudentRepository extends MongoRepository<Student, Integer> {
	
	Stream <Student> findByName(String name); //vsegda Name dolgno sootvetstvovat nazvaniu polya i pishetsy s bolshoy bukvi
	
	long countByNameIn(List<String> names);

	@Query("{'?0':{'$gte':?1}}") //'?0' eto po nomeru String exam i eto key a int score eto value ?1
    Stream<Student> findByExamScore(String exam, int score);
}
