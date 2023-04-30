package com.caterpillar.dasha.demo.repo;


import com.caterpillar.dasha.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Component
@Repository

public interface RepoUsers extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
