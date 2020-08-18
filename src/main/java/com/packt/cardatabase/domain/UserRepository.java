package com.packt.cardatabase.domain;

import org.springframework.data.repository.*;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}