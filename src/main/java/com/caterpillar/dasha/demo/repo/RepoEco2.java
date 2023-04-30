package com.caterpillar.dasha.demo.repo;

import com.caterpillar.dasha.demo.entity.Eco2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepoEco2 extends JpaRepository<Eco2, Integer> {
}
