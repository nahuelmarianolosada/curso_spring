package com.incluit.springapp.web.controllers.rest;

import com.incluit.springapp.web.model.domain.CourseEntity;
import com.incluit.springapp.web.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nlosada on 13/06/18.
 */
@RestController
@RequestMapping(value = "/api/course")
public class CourseRestController {
    @Autowired
    private ICourseService courseService;


    @RequestMapping(value = "/byProfessor/{idProfessor}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> getStudentsByCourse(@PathVariable("idProfessor") int idProfessor){
        List<CourseEntity> list = courseService.getByProfessorId(idProfessor);
        if(list.isEmpty() || list == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
