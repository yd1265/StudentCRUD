package student.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.entity.Student;
import student.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public void addStudent(Student thestudent) {
     studentRepository.save(thestudent);		
	}

	@Override
	public void deleteStudentById(int studentId) {
    studentRepository.deleteById(studentId);	
	}

	@Override
	public List<Student> findAllByOrderByLastNameAsc() {
		return studentRepository.findAllByOrderByLastNameAsc();
	}

}
