package com.videostore.videostore.domain.model.user;

import com.videostore.videostore.domain.model.user.valueobject.Email;
import com.videostore.videostore.domain.model.user.valueobject.Name;
import com.videostore.videostore.domain.model.user.valueobject.Surname;
import com.videostore.videostore.domain.model.user.valueobject.Username;

public class User {

    private final Name name;
    private final Surname surname;
    private final Username username;
    private final Email email;

    private User(Name name, Surname surname, Username username, Email email) {
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

    public Username getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }
}
