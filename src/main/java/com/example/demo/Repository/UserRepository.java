package com.example.demo.Repository;

import com.example.demo.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.lang.ScopedValue;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
    void delete(Long id);

    Account findByName(String username);
}
