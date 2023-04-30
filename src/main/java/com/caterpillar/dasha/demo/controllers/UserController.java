package com.caterpillar.dasha.demo.controllers;


import com.caterpillar.dasha.demo.repo.RepoEco1;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class UserController {
    @Autowired
    RepoEco1 repoEco1;


    @GetMapping("/user")
    String adminTable(Model model){
        log.log(Level.WARN, "WE ARE USER!");
        model.addAttribute("table", repoEco1.findAll().toString());
        return "users";
    }
}
