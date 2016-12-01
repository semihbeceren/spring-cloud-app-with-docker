package com.semihbeceren.Service;

import com.semihbeceren.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Semih Beceren on 11/22/2016.
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.accountRepository.findByUsername(username)
                .map(account -> new User(
                        account.getUsername(),
                        account.getPassword(),
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
                ))
                .orElseThrow(()->new UsernameNotFoundException("Username not found:" + username));
    }

}
