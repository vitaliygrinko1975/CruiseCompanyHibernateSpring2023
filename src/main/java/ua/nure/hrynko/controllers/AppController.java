package ua.nure.hrynko.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.hrynko.db.dao.MySqlUsersDAO;
import ua.nure.hrynko.db.models.Cruise;
import ua.nure.hrynko.db.models.User;
import ua.nure.hrynko.servise.interfaces.CruiseService;
import ua.nure.hrynko.servise.interfaces.RoleService;
import ua.nure.hrynko.servise.interfaces.UserService;
import java.util.Collection;
import java.util.List;


@Controller
public class AppController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private CruiseService cruiseService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = {"/", "welcome"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        return new ModelAndView("welcome");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login1");
    }

    @GetMapping("/registrationPage")
    public ModelAndView registration() {
        return new ModelAndView("client_registration_page");
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
            model.setViewName("login1");
        }
        return model;
    }

    @GetMapping("/signUpPage")
    public ModelAndView signUpPage() {
        return new ModelAndView("sign_up_page");
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
