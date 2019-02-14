package student.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student.entity.Student;
import student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	@Autowired
	private StudentService studentService;
	
	
	// get all students from the crud app
	@GetMapping("/students")
	private List<Student> getAllStudents(){
		List<Student> students =studentService.findAllByOrderByLastNameAsc();
		return students;	
	}
	
	// get the student by id and the retour 
	@GetMapping("/students/{studentId}")
	public Student getStudent( @PathVariable int studentId){
		Student theStudent =studentService.findStudentById(studentId);
		return theStudent;
		
	}
	// add new student 
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent){
		studentService.addStudent(theStudent);
		return theStudent;
	}
	
	// update a student
	 @PutMapping("/students")
	public Student updateStudent(@RequestBody Student teStudent){
		 studentService.addStudent(teStudent);
		 return teStudent;
		
	}
	 // get the student and delete
	 @DeleteMapping("/students/{studentId}")
	 public String deleteStudent(@PathVariable int studentId){
		 studentService.deleteStudentById(studentId);
		 return  "Deleted the student id "+studentId;
		 
	 }
	
	
	

}
