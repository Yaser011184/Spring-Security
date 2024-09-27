package com.Spring.Security.service;

import com.Spring.Security.model.Role;
import com.Spring.Security.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUsername(String username);
    User save(User user);

    Optional<User> findUserById(Integer id);

    User update(User user);

    void deleteUserById(Integer id);

    List<User> getUsers();

    List<Role> getRoles();

    Role getRoleById(Long id);

    void setRolesToUser(User user, Long[] roles);
}