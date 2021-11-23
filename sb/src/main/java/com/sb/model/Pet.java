package com.sb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private Integer age;

    public Pet(String name){
        this.name = name;
    }

}
