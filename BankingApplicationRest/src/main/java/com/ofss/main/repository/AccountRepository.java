package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account,Integer>{
}
