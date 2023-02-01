package ua.nure.hrynko.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
    @RequestMapping(value = {"/", "welcome"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        return new ModelAndView("welcome");
    }

//    @GetMapping("/login")
//    public ModelAndView loginPage() {
//        return new ModelAndView("login");
//    }

}
