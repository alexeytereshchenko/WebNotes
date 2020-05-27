package org.moren.spring.service;

import org.moren.spring.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void delete(User user);
    boolean save(User user);
    void update(User user);
    List<User> getAll();
    Optional<User> findById(Integer id);
}
