package com.sb.controller;

import com.sb.model.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    @GetMapping("/pet/covert")
    public Pet testConvert(Pet pet){
        return pet;
    }
}
