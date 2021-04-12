package com.practice.springbootdemocitravis.service;

import com.practice.springbootdemocitravis.entity.User;
import com.practice.springbootdemocitravis.exception.ResourceNotFoundException;
import com.practice.springbootdemocitravis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public static final String USER_NOT_FOUND = "User not found.";

    @Autowired
    private UserRepository userRepository;

    /**
     * Add a new user
     * @param user
     * @return
     */
    public User addNewUser(User user){

        return userRepository.save(user);
    }

    /**
     * Return all users
     * @return
     */
    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    /**
     * Return a user by ID
     * @return
     */
    public User getById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }

    /**
     * Update a user
     * @return
     */
    public User updateUser(Long id, User newUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));

        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());

        return userRepository.save(user);
    }

    /**
     * Delete a user
     * @return
     */
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
        userRepository.delete(user);
    }

}
