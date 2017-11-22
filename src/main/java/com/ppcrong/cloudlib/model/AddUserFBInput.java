package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for AddUserbyFB
 */

public class AddUserFBInput {
    @JsonProperty("FBID")
    String FBID;
    @JsonProperty("FBName")
    String FBName;
    @JsonProperty("FBEmail")
    String FBEmail;
    @JsonProperty("FBToken")
    String FBToken;

    public AddUserFBInput() {
    }

    public String getFBID() {
        return FBID;
    }

    public void setFBID(String FBID) {
        this.FBID = FBID;
    }

    public String getFBName() {
        return FBName;
    }

    public void setFBName(String FBName) {
        this.FBName = FBName;
    }

    public String getFBEmail() {
        return FBEmail;
    }

    public void setFBEmail(String FBEmail) {
        this.FBEmail = FBEmail;
    }

    public String getFBToken() {
        return FBToken;
    }

    public void setFBToken(String FBToken) {
        this.FBToken = FBToken;
    }
}
