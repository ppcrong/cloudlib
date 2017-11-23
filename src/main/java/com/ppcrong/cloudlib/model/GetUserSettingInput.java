package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for GetUserSetting
 */

public class GetUserSettingInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;

    public GetUserSettingInput() {
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
}
