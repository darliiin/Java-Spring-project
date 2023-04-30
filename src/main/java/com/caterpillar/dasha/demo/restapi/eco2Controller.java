package com.caterpillar.dasha.demo.restapi;

import com.caterpillar.dasha.demo.entity.Eco1;
import com.caterpillar.dasha.demo.entity.Eco2;
import com.caterpillar.dasha.demo.repo.RepoEco1;
import com.caterpillar.dasha.demo.repo.RepoEco2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/restapi/eco2")
public class eco2Controller {
    private final RepoEco2 repoEco2;
    @Autowired
    public eco2Controller(RepoEco2 repoEco2) {
        this.repoEco2 = repoEco2;
    }
    @GetMapping("/{id}")
    Eco2 getElem(@PathVariable int id){
        var eco2 = repoEco2.findById(id).get();
        return eco2.isCheck_text() ? eco2 : null;
    }

    @GetMapping
    List<Eco2> getAll(){
        return repoEco2
                .findAll()
                .stream()
                .filter(Eco2::isCheck_text)
                .collect(Collectors.toList());
    }
    @PostMapping("/{id}")
    Eco2 createElem(@PathVariable int id, @RequestParam("region") String region){
        return repoEco2.save(new Eco2(id,region,true));
    }
    @PatchMapping("/{id}")
    Eco2 updateElem(@PathVariable int id, @RequestParam("level") String level){
        var eco1 = repoEco2.findById(id).get();
        eco1.setLevel(level);
        return repoEco2.save(eco1);
    }
    @DeleteMapping("/{id}")
    Eco2 deleteElem(@PathVariable int id){
        var eco1 = repoEco2.findById(id).get();
        eco1.setCheck_text(false);
        return repoEco2.save(eco1);
    }
}
