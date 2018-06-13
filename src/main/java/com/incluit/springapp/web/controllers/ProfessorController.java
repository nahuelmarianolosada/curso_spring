package com.incluit.springapp.web.controllers;

import com.incluit.springapp.web.model.domain.ProfessorEntity;
import com.incluit.springapp.web.service.IProfessorService;
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
 * Created by nlosada on 13/06/18.
 */

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    IProfessorService professorService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(sdf, true);
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, "birthday", orderDateEditor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getProfessors(ModelMap model){
        List<ProfessorEntity> professors = professorService.getAll();
        model.put("professors", professors);
        return "/professor/professors";
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public String getProfessor(ModelMap model, @PathVariable("id") int id){
        ProfessorEntity professor = professorService.getById(id);
        model.put("professor", professor);
        return "/professor/add";
    }




    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewProfessorPage(ModelMap model) {
        ProfessorEntity professorEntity= new ProfessorEntity();
        /*model.addAttribute("newProfessorForm", new Form());*/
        model.addAttribute("professor", professorEntity);
        return "/professor/add";
    }


    @RequestMapping(value= "/addProfessor", method = RequestMethod.POST)
    public void add(@ModelAttribute("todo") ProfessorEntity newProfessor,
                    BindingResult result, ModelMap model,
                    HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(newProfessor != null){
            this.professorService.insert(newProfessor);
        }else{
            throw new NullPointerException();
        }

        response.sendRedirect( request.getContextPath() + "/professor");
    }



    @RequestMapping(value="/update/{id}",method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable("id") int id){
        ProfessorEntity professorEntity = professorService.getById(id);
        model.addAttribute("professor", professorEntity);
        return "/professor/detailsEdit";
    }



    @RequestMapping(value= "/update", method = RequestMethod.POST )
    public void editSave(@ModelAttribute("todo") ProfessorEntity editProfessor,
                         BindingResult result, ModelMap model,
                         HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(editProfessor != null){
            this.professorService.update(editProfessor);
        }else{
            throw new NullPointerException();
        }

        response.sendRedirect( request.getContextPath() + "/professor");
    }



    @RequestMapping(value = "/delete/{idProfessor}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int idProfessor,HttpServletRequest request, HttpServletResponse response){
        professorService.delete(idProfessor);
        try {
            response.sendRedirect( request.getContextPath() + "/professor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
