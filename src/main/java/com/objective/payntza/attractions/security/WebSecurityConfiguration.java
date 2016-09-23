package com.objective.payntza.attractions.security;

import com.objective.payntza.attractions.model.Account;
import com.objective.payntza.attractions.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public void init(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(userDetailService());
  }

  @Bean
  UserDetailsService userDetailService() {
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);
        if (account != null) {
          return new User(account.getUsername(), account.getPassword(), true, true, true, true,
              AuthorityUtils.createAuthorityList("USER"));
        }
        else {
          throw new UsernameNotFoundException(username + " not found");
        }

      }
    };
  }

}
