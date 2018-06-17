package com.incluit.springapp.web.controllers;

import com.incluit.springapp.web.model.domain.StudentEntity;
import com.incluit.springapp.web.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nlosada on 24/05/18.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    IStudentService studentService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(sdf, true);
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, "birthday", orderDateEditor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getStudents(ModelMap model){
        List<StudentEntity> students = studentService.getAll();
        model.put("students", students);
        return "student/students";
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public String getStudent(ModelMap model, @PathVariable("id") int id){
        StudentEntity student = studentService.getById(id);
        model.put("student", student);
        return "student/add";
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewStudentPage(ModelMap model) {
        StudentEntity studentEntity= new StudentEntity();
        /*model.addAttribute("newStudentForm", new Form());*/
        model.addAttribute("student", studentEntity);
        return "student/add";
    }


    @RequestMapping(value= "/addStudent", method = RequestMethod.POST)
    public void add(@ModelAttribute("todo") StudentEntity newStudent,
                      BindingResult result, ModelMap model,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(newStudent != null){
            this.studentService.insert(newStudent);
        }else{
            throw new NullPointerException();
        }

        response.sendRedirect( request.getContextPath() + "/student");
    }



    @RequestMapping(value="/update/{id}",method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable("id") int id){
        StudentEntity studentEntity = studentService.getById(id);
        model.addAttribute("student", studentEntity);
        return "student/detailsEdit";
    }



    @RequestMapping(value= "/update", method = RequestMethod.POST )
    public void editSave(@ModelAttribute("todo") StudentEntity editStudent,
                    BindingResult result, ModelMap model,
                    HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(editStudent != null){
            this.studentService.update(editStudent);
        }else{
            throw new NullPointerException();
        }


        response.sendRedirect( request.getContextPath() + "/student");
    }



    @RequestMapping(value = "/delete/{idStudent}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int idStudent,HttpServletRequest request, HttpServletResponse response){
        try {
            studentService.delete(idStudent);
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(404);
            e.printStackTrace();
        }
    }

}
