package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for ReSendUserMail
 */

public class ReSendUserMailInput extends JsonBaseObject {
    @JsonProperty("Email")
    String Email;

    public ReSendUserMailInput() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
