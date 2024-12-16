/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author remib
 */
@Controller
public class IndexController {
    
    @RequestMapping(value="index.do")
    public ModelAndView handleIndexGet() {
        return new ModelAndView("index");
    }
    
//    // Using parameters from the request
//    @RequestMapping(value="login.do", method=RequestMethod.POST)
//    public ModelAndView handleLoginPost(HttpServletRequest request){
//        ModelAndView returned;
//        
//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//        
//        if ((login != null) && (password !=null) && (login.equals("admin")) && (password.equals("admin"))){
//            returned = new ModelAndView("users");
//        }
//        else {
//            returned = new ModelAndView("index");
//        }
//        return returned;
//    }
    
    // Using parameters from an object
    @RequestMapping(value="login.do", method=RequestMethod.POST)
    public ModelAndView handleLoginPost(MyUser user){
        ModelAndView returned;
        
        String login = user.getLogin();
        String password = user.getPassword();
        
        if ((login != null) && (password !=null) && (login.equals("admin")) && (password.equals("admin"))){
            returned = new ModelAndView("users");
        }
        else {
            returned = new ModelAndView("index");
        }
        return returned;
    }
}
