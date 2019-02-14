package student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student.entity.Student;
import student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	// get all student
	@GetMapping("/")
	public String findAllStudent(Model model){
		List<Student> students =studentService.findAllByOrderByLastNameAsc();
		model.addAttribute("students",students);
		return "listStudent";
		
	}
	
	// show the add form for student
	@GetMapping("/showFormAdd")
	public String showStudentFormAdd(Model model){
		Student theStudent =new Student();
		model.addAttribute("student",theStudent);
	  return "addStudent";
		
	}
	

	// get data from the form and save 
	@PostMapping("/saveStudent")
	public String addNewStudent(@ModelAttribute("student") Student theStudent){
		// we add the student
		studentService.addStudent(theStudent);
		// we redirect to prevent duplicate submission
		return "redirect:/";
		
	}
	
	// show form for update
	
	@GetMapping("/showFormUpdate")
	public String showFormupdate(@RequestParam("studentId") int theId,Model model){
		// we find the right student
		  Student theStudent =studentService.findStudentById(theId);
		 // we send the model attribute
		  model.addAttribute("student",theStudent);
		  return "addStudent";
		
	}
	
	
	// this form delete student form the database
	 @GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int theId){
		studentService.deleteStudentById(theId);
		
		return "redirect:/";
	}

}
