package com.shoppingcart.akshatshop.service.user;

import com.shoppingcart.akshatshop.model.User;
import com.shoppingcart.akshatshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByuserName(username);

        if(user!=null){
            UserDetails userDetails= org.springframework.security.core.userdetails.User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getRoles().toArray(new String[0])).build();
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found with username"+username);
    }
}
