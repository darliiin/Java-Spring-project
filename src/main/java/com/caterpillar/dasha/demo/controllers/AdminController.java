package com.caterpillar.dasha.demo.controllers;


import com.caterpillar.dasha.demo.entity.Eco2;
import com.caterpillar.dasha.demo.repo.RepoEco2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
public class AdminController {
    @Autowired
    RepoEco2 repoEco2;


    @GetMapping("/admin")
    String adminTable(Model model){
//        log.log(Level.WARN, "WE ARE ADMIN!");
        log.info("Это таблица Эко2: {}", repoEco2
                .findAll()
                .stream()
                .filter(Eco2::isCheck_text)
                .collect(Collectors.toList()));
        model.addAttribute("table", repoEco2
                                                            .findAll()
                                                            .stream()
                                                            .filter(Eco2::isCheck_text)
                                                            .collect(Collectors.toList()));
        return "admin";
    }

    @PostMapping
    String forAdd(){
        return "redirect:/admin/eco2/new";
    }

    @GetMapping("/admin/eco2/new")
    String allTables(Model model){
        model.addAttribute("table_eco2",
                                        repoEco2
                                                .findAll()
                                                .stream()
                                                .filter(Eco2::isCheck_text)
                                                .collect(Collectors.toList()));
        return "addNew";
    }

    @PostMapping("/admin/eco2/new")
    String addNew(@RequestParam("level") String level) {
        repoEco2.save(new Eco2(level));
        return "redirect:/admin";
    }
    @GetMapping("/admin/eco2/{id}/delete")
    String get_for_delete(@PathVariable("id") int id) {
        Eco2 e = repoEco2.findById(id).orElseThrow();
        e.setCheck_text(false);
        repoEco2.save(e);
        return "forward:/admin";
    }

    @GetMapping("/admin/eco2/{id}/edit")
    String getElement(@PathVariable("id") int id, Model model){
        model.addAttribute("eco2", repoEco2.findById(id).orElseThrow());
        return "editNew";
    }
//    @PersistenceContext
//    EntityManager entityManager;
    @PostMapping("/admin/eco2/{id}/edit")
    String updateElement(@ModelAttribute("eco2") Eco2 bp){
        repoEco2.save(bp);
//        System.out.println("-------------\n\n\n" + level + "\n\n\n---------------------");
//        bp.setLevel(level);
//        entityManager.persist(bp);
        return "redirect:/admin";
    }

}
