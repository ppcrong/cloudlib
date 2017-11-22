package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for AuthUser
 */

public class AuthUserInput {
    @JsonProperty("Email")
    String Email;
    @JsonProperty("Password")
    String Password;
    @JsonProperty("MacAddress")
    String MacAddress;
    @JsonProperty("IPAddress")
    String IPAddress;

    public AuthUserInput() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String macAddress) {
        MacAddress = macAddress;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }
}
