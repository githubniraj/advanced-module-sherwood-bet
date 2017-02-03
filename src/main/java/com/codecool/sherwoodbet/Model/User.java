package com.codecool.sherwoodbet.Model;

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by patrik on 2017.02.02..
 */

@Entity
@Table(name = "users")
public class User {
    private Long ID;
    private String name;
    private String password;
    private String email;
    private String sessions;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getSessions() {
        return sessions;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sessions='" + sessions + '\'' +
                '}';
    }
}