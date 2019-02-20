package student.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import student.entity.StudentErroResponse;
import student.entity.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHanlder {
	
	@ExceptionHandler
	public ResponseEntity<StudentErroResponse> handlerException(StudentNotFoundException exc){
		StudentErroResponse error= new StudentErroResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErroResponse> handleAllException(Exception exc){
		 StudentErroResponse error=new StudentErroResponse();
		 error.setStatus(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(exc.getMessage());
		 error.setTimestamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<StudentErroResponse>(error,HttpStatus.BAD_REQUEST);
	}

}
