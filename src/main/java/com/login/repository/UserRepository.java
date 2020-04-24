package com.login.repository;

import com.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//userRepository is extending to Jparepository to inherit it's functions
public interface UserRepository extends JpaRepository<User, Long > {
    User findByEmail(String email);
    User findByUserName(String userName);
}
