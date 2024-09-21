package com.Spring.Security.service;


import com.Spring.Security.model.Role;
import com.Spring.Security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

//@Service
//public class UserService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    private RoleRepository roleRepository;
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                user.getRoles());
//    }
//
//    @Transactional
//    public User findUserById(Long userId) {
//        Optional<User> userFromDb = userRepository.findById(userId);
//        return userFromDb.orElse(new User());
//    }
//
//    @Transactional
//    public List<User> allUsers() {
//        return userRepository.findAll();
//    }
//
//    @Transactional
//    public boolean saveUser(User user) {
//        User userFromDB = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role()));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }
//
//    @Transactional
//    public boolean deleteUser(Long userId) {
//        if (userRepository.findById(userId).isPresent()) {
//            userRepository.deleteById(userId);
//            return true;
//        }
//        return false;
//    }
//
//    @Transactional
//    public List<User> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
//}
public interface UserService {

    User findByUsername(String username);
    User save(User user);

    Optional<User> findUserById(Integer id);

    User update(User user, Integer id);

    void deleteUserById(Integer id);

    List<User> getUsers();

    List<Role> getRoles();

    Role getRoleById(Long id);

    void setRolesToUser(User user, Long[] roles);
}