package com.example.ITsupport.implementation;


import com.example.ITsupport.entity.Person;
import com.example.ITsupport.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user =userRepository.findByUsername(username);
        System.out.println(user.getUsername()+"////"+user.getPassword());
        return userRepository.save(user);

    }
}
