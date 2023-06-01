package com.demo.utils;

import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;
@ApplicationScoped
public class PasswordEncoder {
    public String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean validate(String password, String encodedPassword) {
        return BCrypt.checkpw(password, encodedPassword);
    }
}
