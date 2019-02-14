package student.service;

import java.util.List;

import student.entity.Student;

public interface StudentService {

	public List<Student> findAllStudent();
	public Student findStudentById(int studentId);
	public void addStudent(Student thestudent);
	public void deleteStudentById(int studentId);
	public List<Student> findAllByOrderByLastNameAsc();

}
