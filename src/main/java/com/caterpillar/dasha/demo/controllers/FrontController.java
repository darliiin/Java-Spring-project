package com.caterpillar.dasha.demo.controllers;//package com.caterpillar.controllers;
//
//import com.caterpillar.entity.Users;
//import com.caterpillar.repo.RepoUsers;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import lombok.extern.log4j.Log4j2;
//import org.apache.logging.log4j.Level;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Log4j2
//@Controller
//public class FrontController {
//    @PersistenceContextCould not autowire. No beans of 'RepoUsers' type found.
//    EntityManager entityManager;
//
//    @Autowired
//    RepoUsers repoUsers;
//
//    @GetMapping("/")
//    public String redir(){
//        log.log(Level.WARN, "Я ТУТ! ПРИВЕТ ОТ РЕДИРЕКТА");
//        return "forward:/front";
//    }
//    @GetMapping("/front")
//    String site(Model model){
//        return "front";
//    }
//    @PostMapping("/front")
//    public String front(@RequestParam String email, @RequestParam String pass, Model model){
//        log.log(Level.WARN, "ПРИВЕТ НА ФРОНТЕ ПОСТОВОМ!");
//        log.log(Level.WARN, entityManager);
////        log.log(Level.WARN,repoUsers.authorization(email, pass, entityManager));
//        switch (repoUsers.authorization(email, pass, entityManager)){
//            case "admin": {log.log(Level.WARN,"Bye admin");return "redirect:/admin";}
//            case "user": {
//                log.log(Level.WARN,"Bye user");
//                return "redirect:/user";
//            }
//        }
//        log.log(Level.WARN,"Bye NULL");
//        return "lose";
//    }
//}
