package com.shoppingcart.akshatshop.controller;

import com.shoppingcart.akshatshop.Utils.JwtUtils;
import com.shoppingcart.akshatshop.model.User;
import com.shoppingcart.akshatshop.service.user.UserDetailsServiceImpl;
import com.shoppingcart.akshatshop.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/auth")
@Slf4j
@Tag(name = "Public APIs")
public class PublicController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    @GetMapping("/health-check")
    @Operation(summary = "To check if servers are initalized properly")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/signup")
    @Operation(summary = "To create a new user")
    public void signup(@RequestBody User user){
        userService.saveNewUser(user);
    }

    @PostMapping("/login")
    @Operation(summary = "Login to add products to Cart")
    public ResponseEntity<String> login(@RequestBody User user){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            String jwt=jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred while creatAuthenticationToken",e);
            return new ResponseEntity<>("Incorrect username or password",HttpStatus.BAD_REQUEST);
        }
    }


}
