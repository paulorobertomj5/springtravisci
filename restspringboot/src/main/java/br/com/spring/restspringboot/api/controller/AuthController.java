package br.com.spring.restspringboot.api.controller;

import br.com.spring.restspringboot.api.entity.request.AuthRequest;
import br.com.spring.restspringboot.api.service.impl.ClientServiceImpl;
import br.com.spring.restspringboot.api.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);


    @RequestMapping("/")
    public String logged() {
        return "Welcome";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            logger.info("Accessing AuthController generateToken");

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception e) {
            logger.info("Accessing AuthController generateToken error = " + e.getMessage());
            throw new Exception("Invalid username or password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
