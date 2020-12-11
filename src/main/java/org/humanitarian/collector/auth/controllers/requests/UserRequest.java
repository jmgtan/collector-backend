package org.humanitarian.collector.auth.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class UserRequest {
    private String username;

    private String password;

    @JsonProperty("role_names")
    private Set<String> roleNames;

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

    public Set<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }
}
