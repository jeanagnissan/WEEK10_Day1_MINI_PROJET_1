package com.adaci.userproject.controller;

import com.adaci.userproject.helper.BodyContent;
import com.adaci.userproject.helper.Help;
import com.adaci.userproject.model.Users;
import com.adaci.userproject.repository.IUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(methods = {}, origins = "http://localhost:4200/")
@Validated
public class UserController {
    @Autowired
    IUser OIUser;
    @GetMapping()
    public List<Users> findAllUser() {
        List<Users> LUser = new ArrayList<Users>();
        OIUser.findAll().forEach(users -> {
            LUser.add(users);
        });
        return LUser;
    }

    @GetMapping("/countUser")
    public int countUser() {
        return this.findAllUser().size();
    }
    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody Users user) {
        OIUser.save(user);
        return ResponseEntity.ok().body(Help.buildHttpBodyRequest(List.
                of(new BodyContent("details", "user successfully register"),
                        new BodyContent("statusCode", String.valueOf(HttpStatus.OK)))));
    }
}
