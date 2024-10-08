package com.example.ITsupport.service;

import com.example.ITsupport.Dto.SignupRequest;
import com.example.ITsupport.entity.Technician;
import com.example.ITsupport.entity.User;
import com.example.ITsupport.enums.role;
import com.example.ITsupport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

import static net.andreinc.mockneat.types.enums.StringType.ALPHA_NUMERIC;
import static net.andreinc.mockneat.types.enums.StringType.HEX;
import static net.andreinc.mockneat.unit.text.Strings.strings;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public String newUser(SignupRequest signupRequest){
        String hashedPassword = passwordEncoder.encode(signupRequest.password());
        User user = new User();
        user.setUsername(signupRequest.username());
        user.setPhone(signupRequest.phone());
        user.setEmail(signupRequest.email());
        user.setPassword(hashedPassword);
        user.setRole(role.USER);
        userRepository.save(user);
        return "user added successfully";

    }
    public User updateUser(Integer id , SignupRequest technicianRequest) {
        User user = userRepository.findById(id).get();
        user.setUsername(technicianRequest.username());
        user.setEmail(technicianRequest.email());
        user.setPhone(technicianRequest.phone());
        user.setPassword(technicianRequest.password());
        return userRepository.save(user);
    }
    public String removeUser(Integer id)
    {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return "delete success";
    }


    public User findUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
