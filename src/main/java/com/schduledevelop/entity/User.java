package com.schduledevelop.entity;

import com.schduledevelop.repository.UserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String mail;
    private String password;

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public void update(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }


}
