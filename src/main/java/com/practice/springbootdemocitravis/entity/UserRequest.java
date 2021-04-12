package com.practice.springbootdemocitravis.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String firstName;

    private String lastName;

    public User toEntity(){

        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);

        return user;
    }
}
