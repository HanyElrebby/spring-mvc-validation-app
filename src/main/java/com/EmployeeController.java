package com;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView model  = new ModelAndView("index");
        return model;
    }

    @RequestMapping("/empForm")
    public ModelAndView empForm() {
        Employee employee = new Employee();
        ModelAndView model  = new ModelAndView("empForm");
        model.addObject(employee);
        return model;
    }

    @RequestMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute Employee employee, BindingResult br) {
        ModelAndView model  = new ModelAndView();
        if (br.hasErrors()) {
            model.addObject("employee", employee);
            model.setViewName("empForm");
        } else {
            model.addObject("employee", employee);
            model.setViewName("final");
        }
        return model;
    }
}
