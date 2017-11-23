package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for EditAccountFB
 */

public class EditAccountFBInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("FBID")
    String FBID;
    @JsonProperty("FBName")
    String FBName;
    @JsonProperty("FBEmail")
    String FBEmail;
    @JsonProperty("FBToken")
    String FBToken;

    public EditAccountFBInput() {
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
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
