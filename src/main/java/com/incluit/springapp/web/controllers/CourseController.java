package com.incluit.springapp.web.controllers;

import com.incluit.springapp.web.model.domain.CourseEntity;
import com.incluit.springapp.web.service.ICourseService;
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
 * Created by nlosada on 12/06/18.
 */

@Controller
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    ICourseService courseService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(sdf, true);
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, "birthday", orderDateEditor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCourses(ModelMap model){
        List<CourseEntity> courses = courseService.getAll();
        model.put("courses", courses);
        return "course/courses";
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public String getCourse(ModelMap model, @PathVariable("id") int id){
        CourseEntity course = courseService.getById(id);
        model.put("course", course);
        return "/course/add";
    }




    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewCoursePage(ModelMap model) {
        CourseEntity courseEntity= new CourseEntity();
        /*model.addAttribute("newCourseForm", new Form());*/
        model.addAttribute("course", courseEntity);
        return "/course/add";
    }


    @RequestMapping(value= "/addCourse", method = RequestMethod.POST)
    public void add(@ModelAttribute("todo") CourseEntity newCourse,
                    BindingResult result, ModelMap model,
                    HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(newCourse != null){
            this.courseService.insert(newCourse);
        }else{
            throw new NullPointerException();
        }

        response.sendRedirect( request.getContextPath() + "/course");
    }



    @RequestMapping(value="/update/{id}",method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable("id") int id){
        CourseEntity courseEntity = courseService.getById(id);
        model.addAttribute("course", courseEntity);
        return "/course/detailsEdit";
    }



    @RequestMapping(value= "/update", method = RequestMethod.POST )
    public void editSave(@ModelAttribute("todo") CourseEntity editCourse,
                         BindingResult result, ModelMap model,
                         HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(editCourse != null){
            this.courseService.update(editCourse);
        }else{
            throw new NullPointerException();
        }

        response.sendRedirect( request.getContextPath() + "/course");
    }



    @RequestMapping(value = "/delete/{idCourse}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int idCourse,HttpServletRequest request, HttpServletResponse response){
        courseService.delete(idCourse);
        try {
            response.sendRedirect( request.getContextPath() + "/course");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
