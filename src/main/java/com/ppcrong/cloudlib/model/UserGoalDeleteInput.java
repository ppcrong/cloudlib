package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for UserGoalDelete
 */

public class UserGoalDeleteInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;
    @JsonProperty("GoalID")
    int GoalID;

    public UserGoalDeleteInput() {
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

    public int getGoalID() {
        return GoalID;
    }

    public void setGoalID(int goalID) {
        GoalID = goalID;
    }
}
