package student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import student.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findAllByOrderByLastNameAsc();
	
	
}
