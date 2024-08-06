//package com.example.ITsupport.service;
//
//import com.example.ITsupport.entity.Admin;
//import com.example.ITsupport.entity.Person;
//import com.example.ITsupport.entity.Technician;
//import com.example.ITsupport.entity.User;
//import com.example.ITsupport.repository.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class CostumUserDetailsService implements UserDetailsService {
//
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Person person = personRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (person instanceof Admin) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else if (person instanceof Technician) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_TECHNICIAN"));
//        } else if (person instanceof User) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                person.getUsername(),
//                person.getPassword(),
//                authorities
//        );
//    }
//}
