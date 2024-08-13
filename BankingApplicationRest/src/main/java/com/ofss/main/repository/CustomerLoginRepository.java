package com.ofss.main.repository;
import org.springframework.data.repository.CrudRepository;
import com.ofss.main.domain.LoginDetails;

public interface CustomerLoginRepository extends CrudRepository<LoginDetails,Integer>{
    LoginDetails findByUsernameAndPassword(String username,String password);
    LoginDetails findByUsername(String username);
}
