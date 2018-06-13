package com.incluit.springapp.web.controllers.rest;

import com.incluit.springapp.web.model.domain.StudentEntity;
import com.incluit.springapp.web.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nlosada on 12/06/18.
 */

@RestController
@RequestMapping(value = "/api/student")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;


    @RequestMapping(value = "/byCourse/{idCourse}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> getStudentsByCourse(@PathVariable("idCourse") int idCourse){
        List<StudentEntity> list = studentService.getAllSignedToCourse(idCourse);
        if(list.isEmpty() || list == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getAll(){
        List<StudentEntity> list = studentService.getAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
