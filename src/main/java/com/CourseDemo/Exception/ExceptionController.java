package com.CourseDemo.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController
{
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentException(StudentNotFoundException stExp)
    {
        ExceptionInfo info = new ExceptionInfo(stExp.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());

        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(LoggingFailureAnalysisReporter.class)
    public ResponseEntity<Object> handleDatabaseException(LoggingFailureAnalysisReporter DatabaseExp)
    {
        ExceptionInfo info=new ExceptionInfo(DatabaseExp.getMessage(),HttpStatus.NOT_FOUND,ZonedDateTime.now());

        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }*/
}
