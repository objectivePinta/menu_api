package com.objective.payntza.attractions.repositories;


import com.objective.payntza.attractions.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {

    public Account findByUsername(String username);
}
