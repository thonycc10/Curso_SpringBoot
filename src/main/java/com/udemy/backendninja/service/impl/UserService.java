package com.udemy.backendninja.service.impl;


import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       // llama al repository
    	   com.udemy.backendninja.entity.User user = userRepository.findByUsername(s);
    	   List<GrantedAuthority> authorities = buildAuthority(user.getUserRole());
    	   return buildUser(user, authorities);
    }
    
    private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authority) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authority);
    }

    // transforma set de userRoles
    private List<GrantedAuthority> buildAuthority (Set<UserRole> userRoles){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoles){
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }
}
