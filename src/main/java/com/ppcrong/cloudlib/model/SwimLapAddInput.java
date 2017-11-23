package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for SwimLapAdd
 */

public class SwimLapAddInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;
    @JsonProperty("StartTime")
    long StartTime;
    @JsonProperty("Time")
    int Time;
    @JsonProperty("CumulativeTime")
    int CumulativeTime;
    @JsonProperty("LapNumber")
    int LapNumber;
    @JsonProperty("SwimStroke")
    int SwimStroke;
    @JsonProperty("Distance")
    int Distance;
    @JsonProperty("AvgPace")
    int AvgPace;
    @JsonProperty("BestPace")
    int BestPace;
    @JsonProperty("AvgSwolf")
    int AvgSwolf;
    @JsonProperty("AvgHR")
    int AvgHR;
    @JsonProperty("MaxHR")
    int MaxHR;
    @JsonProperty("TotalStroke")
    int TotalStroke;
    @JsonProperty("LatitudeArray")
    String LatitudeArray;
    @JsonProperty("LongtitudeArray")
    String LongtitudeArray;
    @JsonProperty("Calorie")
    int Calorie;
    @JsonProperty("UniqueID")
    String UniqueID;

    public SwimLapAddInput() {
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

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public int getCumulativeTime() {
        return CumulativeTime;
    }

    public void setCumulativeTime(int cumulativeTime) {
        CumulativeTime = cumulativeTime;
    }

    public int getLapNumber() {
        return LapNumber;
    }

    public void setLapNumber(int lapNumber) {
        LapNumber = lapNumber;
    }

    public int getSwimStroke() {
        return SwimStroke;
    }

    public void setSwimStroke(int swimStroke) {
        SwimStroke = swimStroke;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public int getAvgPace() {
        return AvgPace;
    }

    public void setAvgPace(int avgPace) {
        AvgPace = avgPace;
    }

    public int getBestPace() {
        return BestPace;
    }

    public void setBestPace(int bestPace) {
        BestPace = bestPace;
    }

    public int getAvgSwolf() {
        return AvgSwolf;
    }

    public void setAvgSwolf(int avgSwolf) {
        AvgSwolf = avgSwolf;
    }

    public int getAvgHR() {
        return AvgHR;
    }

    public void setAvgHR(int avgHR) {
        AvgHR = avgHR;
    }

    public int getMaxHR() {
        return MaxHR;
    }

    public void setMaxHR(int maxHR) {
        MaxHR = maxHR;
    }

    public int getTotalStroke() {
        return TotalStroke;
    }

    public void setTotalStroke(int totalStroke) {
        TotalStroke = totalStroke;
    }

    public String getLatitudeArray() {
        return LatitudeArray;
    }

    public void setLatitudeArray(String latitudeArray) {
        LatitudeArray = latitudeArray;
    }

    public String getLongtitudeArray() {
        return LongtitudeArray;
    }

    public void setLongtitudeArray(String longtitudeArray) {
        LongtitudeArray = longtitudeArray;
    }

    public int getCalorie() {
        return Calorie;
    }

    public void setCalorie(int calorie) {
        Calorie = calorie;
    }

    public String getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(String uniqueID) {
        UniqueID = uniqueID;
    }
}
