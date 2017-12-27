package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for StepAdd
 */

public class StepAddInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;
    @JsonProperty("StartTime")
    long StartTime;
    @JsonProperty("Duration")
    long Duration;
    @JsonProperty("StepCount")
    int StepCount;
    @JsonProperty("Distance")
    float Distance;
    @JsonProperty("StepState")
    int StepState;
    @JsonProperty("Calories")
    int Calories;
    @JsonProperty("UniqueID")
    String UniqueID;

    public StepAddInput() {
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

    public long getStartTime() {
        return StartTime;
    }

    public void setStartTime(long startTime) {
        StartTime = startTime;
    }

    public long getDuration() {
        return Duration;
    }

    public void setDuration(long duration) {
        Duration = duration;
    }

    public int getStepCount() {
        return StepCount;
    }

    public void setStepCount(int stepCount) {
        StepCount = stepCount;
    }

    public float getDistance() {
        return Distance;
    }

    public void setDistance(float distance) {
        Distance = distance;
    }

    public int getStepState() {
        return StepState;
    }

    public void setStepState(int stepState) {
        StepState = stepState;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int calories) {
        Calories = calories;
    }

    public String getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(String uniqueID) {
        UniqueID = uniqueID;
    }
}
