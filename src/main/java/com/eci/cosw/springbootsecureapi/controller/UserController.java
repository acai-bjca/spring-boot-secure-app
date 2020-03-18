package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author Santiago Carrillo 8/21/17.
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login(@RequestBody User login) throws ServletException {
        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        System.out.println(email + "   " + password);

        // TODO implement logic to verify user credentials
        User user = userService.findUserByEmail(email);

        if (user == null) {
            throw new ServletException("User username not found.");
        }
        
        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        // Código donde creo que se produce excepción
        jwtToken = Jwts
            .builder()
            .setSubject(email)
            .claim("roles", "user")
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey")
            .compact();

        return new Token(jwtToken);
    }
    /*
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public Token login2(@RequestBody Token token) throws ServletException {
        String jwtToken = "";        
        // Código donde creo que se produce excepción
        System.out.println("################Iguales");
        jwtToken = Jwts
            .builder()
            .setSubject(email)
            .claim("roles", "user")
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey")
            .compact();

        return new Token(jwtToken);
    }*/

    public class Token {

        String accessToken;

        public Token(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String access_token) {
            this.accessToken = access_token;
        }
    }
    

}
