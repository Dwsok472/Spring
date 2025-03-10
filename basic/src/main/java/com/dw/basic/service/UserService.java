package com.dw.basic.service;

import com.dw.basic.Repository.UserRepository;
import com.dw.basic.UserDTO.UserDTO;
import com.dw.basic.mode.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
            if (user == null)
            {
                throw new RuntimeException("찾을수 없음");
        }
        return userRepository.save(user);
    }
}
