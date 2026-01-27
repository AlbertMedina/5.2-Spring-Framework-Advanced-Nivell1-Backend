package com.videostore.videostore.domain.model.user;

import com.videostore.videostore.domain.model.movie.valueobject.*;
import com.videostore.videostore.domain.model.user.valueobject.*;

public class User {

    private final Name name;
    private final Surname surname;
    private final Username username;
    private final Email email;
    private final Password password;

    private User(Name name, Surname surname, Username username, Email email, Password password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    public Username getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public static User create(Name name, Surname surname, Username username, Email email, Password password) {
        return new User(name, surname, username, email, password);
    }
}
