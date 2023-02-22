package ua.nure.hrynko.controllers;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.hrynko.db.models.Cruise;
import ua.nure.hrynko.db.models.User;
import ua.nure.hrynko.servise.interfaces.AccountService;
import ua.nure.hrynko.servise.interfaces.CruiseService;
import ua.nure.hrynko.servise.interfaces.RoleService;
import ua.nure.hrynko.servise.interfaces.UserService;

import java.util.Collection;
import java.util.List;

@Slf4j
@Controller
public class AppController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    protected SessionFactory sessionFactory;

    @RequestMapping(value = {"/", "/goToWelcomePage"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        log.debug("WelcomePage starts");
        log.debug("WelcomePage finished");
        return new ModelAndView("welcome");

    }

    @GetMapping("/forRegistered")
    public ModelAndView forRegistered() {
        ModelAndView model = new ModelAndView();
        if (hasRole("ROLE_ADMIN")) {
            List<User> userList = userService.getAll();
            model.addObject("userList", userList);
            model.setViewName("admin_page");
        } else if (hasRole("ROLE_USER")) {
            List<Cruise> allCruises = cruiseService.getAll();
            model.addObject("allCruises", allCruises);
            model.setViewName("client_page");
        } else {
            model.setViewName("login");
        }
        return model;
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/signUpPage")
    public ModelAndView signUpPage() {
        return new ModelAndView("sign_up_page");
    }

    @PostMapping("/signUpUser")
    public String createOrUpdateUser(@RequestParam("addLoginUser") String login,
                                     @RequestParam("addPasswordUser") String password,
                                     @RequestParam("addFirstNameUser") String firstName,
                                     @RequestParam("addLastNameUser") String lastName,
                                     @RequestParam("addEmailUser") String email,
                                     @RequestParam("addPhoneUser") String phone,
                                     ModelMap model) {
        String message;
        try {
            userService.signUpUserAndAddItemAccount(login, password, firstName, lastName, email, phone);
            message = "The user has been registered";
        } catch (Exception e) {
            message = "The system could not registered user!";
        }
        model.addAttribute("message", message);
        return "message";
    }

    private boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }
}
