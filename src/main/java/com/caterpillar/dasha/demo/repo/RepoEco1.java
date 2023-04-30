package com.caterpillar.dasha.demo.repo;


import com.caterpillar.dasha.demo.entity.Eco1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepoEco1 extends JpaRepository<Eco1, Integer> {
}
