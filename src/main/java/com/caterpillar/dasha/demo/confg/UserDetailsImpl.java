package com.caterpillar.dasha.demo.confg;


import com.caterpillar.dasha.demo.repo.RepoUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
public class UserDetailsImpl implements UserDetailsService {

    final RepoUsers repoUsers;


    @Autowired
    public UserDetailsImpl(RepoUsers repoUsers) {
        this.repoUsers = repoUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repoUsers.findByEmail(email).orElseThrow(
                                        () -> new UsernameNotFoundException("Не найден"));
    }
}
