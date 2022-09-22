package com.portfoliohh.portfolio_hh.Security.Controller;

import com.portfoliohh.portfolio_hh.Security.DTO.JWTokenDTO;
import com.portfoliohh.portfolio_hh.Security.DTO.NewUser;
import com.portfoliohh.portfolio_hh.Security.DTO.UserLogin;
import com.portfoliohh.portfolio_hh.Security.Entity.Role;
import com.portfoliohh.portfolio_hh.Security.Entity.User;
import com.portfoliohh.portfolio_hh.Security.Enums.RoleName;
import com.portfoliohh.portfolio_hh.Security.JWT.JWTokenProvider;
import com.portfoliohh.portfolio_hh.Security.Service.RoleService;
import com.portfoliohh.portfolio_hh.Security.Service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    JWTokenProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()) 
            return new ResponseEntity(new Message("Wrong input or invalid email"),HttpStatus.BAD_REQUEST); 
        
        if(userService.existsByUserName(newUser.getUserName()))
            return new ResponseEntity(new Message("Username allready exists"), HttpStatus.BAD_REQUEST);
        
        
        if(userService.existsByEmail(newUser.getEmail())) 
            return new ResponseEntity(new Message ("Email allready exists"), HttpStatus.BAD_REQUEST);
        
        
        User user = new User(newUser.getName(), newUser.getUserName(),
            newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        
        if(newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        
        return new ResponseEntity(new Message("Saved user"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JWTokenDTO> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Wrong 1111input"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        userLogin.getUserName(), userLogin.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JWTokenDTO jwtDTO = new JWTokenDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    } 
}
    
