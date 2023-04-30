package com.caterpillar.dasha.demo.restapi;

import com.caterpillar.dasha.demo.entity.Eco1;
import com.caterpillar.dasha.demo.entity.Eco2;
import com.caterpillar.dasha.demo.repo.RepoEco1;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/restapi/eco1")
@Tag(name = "ECO1")
public class eco1Controller {
    private final RepoEco1 repoEco1;
    @Autowired
    public eco1Controller(RepoEco1 repoEco1) {
        this.repoEco1 = repoEco1;
    }
    @GetMapping("/{id}")
    Eco1 getElem(@PathVariable int id){
        var eco1 = repoEco1.findById(id).get();
        return eco1.isCheck_text() ? eco1 : null;
    }

    @GetMapping
    List<Eco1> getAll(){
        return repoEco1
                .findAll()
                .stream()
                .filter(Eco1::isCheck_text)
                .collect(Collectors.toList());
    }
    @PostMapping("/{id}")
    Eco1 createElem(@PathVariable int id, @RequestParam("region") String region){
        return repoEco1.save(new Eco1(region));
    }
    @PatchMapping("/{id}")
    Eco1 updateElem(@PathVariable int id, @RequestParam("region") String region){
        var eco1 = repoEco1.findById(id).get();
        eco1.setRegion(region);
        return repoEco1.save(eco1);
    }
    @DeleteMapping("/{id}")
    Eco1 deleteElem(@PathVariable int id){
        var eco1 = repoEco1.findById(id).get();
        eco1.setCheck_text(false);
        return repoEco1.save(eco1);
    }
}
