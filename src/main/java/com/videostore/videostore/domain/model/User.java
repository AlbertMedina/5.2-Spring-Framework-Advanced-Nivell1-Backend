package com.videostore.videostore.domain.model;

import com.videostore.videostore.domain.model.valueobject.Email;
import com.videostore.videostore.domain.model.valueobject.Name;
import com.videostore.videostore.domain.model.valueobject.Surname;
import com.videostore.videostore.domain.model.valueobject.UserName;

public class User {

    private final Name name;
    private final Surname surname;
    private final UserName username;
    private final Email email;

    private User(Name name, Surname surname, UserName username, Email email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    public UserName getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }
}
