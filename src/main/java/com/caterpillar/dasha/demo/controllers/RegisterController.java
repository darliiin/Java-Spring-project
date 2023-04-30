package com.caterpillar.dasha.demo.controllers;
import com.caterpillar.dasha.demo.entity.Users;
import com.caterpillar.dasha.demo.repo.RepoUsers;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Log4j2
@Controller
public class RegisterController {
    @Autowired
    private RepoUsers repoUsers;

    @GetMapping("/register")
    public String register(){
        return "registr";
    }

    @PostMapping("/register")
    public String registration(  @RequestParam("email") String email, @RequestParam("pass") String pass) {
        log.log(Level.INFO, "REGISTRATION");
        Users user = new Users(email, pass);
        repoUsers.save(user);
        return "forward:/front";
    }




}
