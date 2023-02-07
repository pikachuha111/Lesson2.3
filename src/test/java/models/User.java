package models;

import Configuration.ReadProperties;

public class User {
    private String username;
    private String password;

    public static class Builder {
        private User newUser;
        private ReadProperties readProperties;

        public Builder() {
            newUser = new User();
        }

        public Builder withEmail(String value) {
            newUser.username = value;

            return this;
        }

        public Builder withPassword(String value) {
            newUser.password = value;

            return this;
        }

        public User build() {
            return newUser;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
