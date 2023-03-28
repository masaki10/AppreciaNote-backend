package com.taketeru.apprecianote.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public User fetchUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User updatedUser = userRepository.findById(user.getId()).get();
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
