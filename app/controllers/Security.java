package controllers;

import models.User;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        User user = User.find("byEmail", username).first();
        return user != null && user.password.equals(password);
    }

    static boolean check(String profile) {
        if ("administrator".equals(profile)
                && "admin@admin.com".equals(connected())) {
            return true;
        } else {
            return false;
        }
    }
}
