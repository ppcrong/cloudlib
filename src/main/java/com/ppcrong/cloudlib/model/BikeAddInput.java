package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for BikeAdd
 */

public class BikeAddInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;
    @JsonProperty("Splits")
    int Splits;
    @JsonProperty("StartTime")
    long StartTime;
    @JsonProperty("Time")
    int Time;
    @JsonProperty("CumulativeTime")
    int CumulativeTime;
    @JsonProperty("MovingTime")
    int MovingTime;
    @JsonProperty("Distance")
    int Distance;
    @JsonProperty("ElevGain")
    int ElevGain;
    @JsonProperty("ElevLoss")
    int ElevLoss;
    @JsonProperty("AvgPace")
    int AvgPace;
    @JsonProperty("AvgMovingPace")
    int AvgMovingPace;
    @JsonProperty("BestPace")
    int BestPace;
    @JsonProperty("AvgSpeed")
    int AvgSpeed;
    @JsonProperty("AvgMovingSpeed")
    int AvgMovingSpeed;
    @JsonProperty("BestSpeed")
    int BestSpeed;
    @JsonProperty("AvgHR")
    int AvgHR;
    @JsonProperty("MaxHR")
    int MaxHR;
    @JsonProperty("AvgCyclingCadence")
    int AvgCyclingCadence;
    @JsonProperty("MaxCyclingCadence")
    int MaxCyclingCadence;
    @JsonProperty("AvgTemperature")
    int AvgTemperature;
    @JsonProperty("LatitudeArray")
    String LatitudeArray;
    @JsonProperty("LongtitudeArray")
    String LongtitudeArray;
    @JsonProperty("Power")
    int Power;
    @JsonProperty("Calorie")
    int Calorie;
    @JsonProperty("UniqueID")
    String UniqueID;

    public BikeAddInput() {
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

    public int getSplits() {
        return Splits;
    }

    public void setSplits(int splits) {
        Splits = splits;
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

    public int getMovingTime() {
        return MovingTime;
    }

    public void setMovingTime(int movingTime) {
        MovingTime = movingTime;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public int getElevGain() {
        return ElevGain;
    }

    public void setElevGain(int elevGain) {
        ElevGain = elevGain;
    }

    public int getElevLoss() {
        return ElevLoss;
    }

    public void setElevLoss(int elevLoss) {
        ElevLoss = elevLoss;
    }

    public int getAvgPace() {
        return AvgPace;
    }

    public void setAvgPace(int avgPace) {
        AvgPace = avgPace;
    }

    public int getAvgMovingPace() {
        return AvgMovingPace;
    }

    public void setAvgMovingPace(int avgMovingPace) {
        AvgMovingPace = avgMovingPace;
    }

    public int getBestPace() {
        return BestPace;
    }

    public void setBestPace(int bestPace) {
        BestPace = bestPace;
    }

    public int getAvgSpeed() {
        return AvgSpeed;
    }

    public void setAvgSpeed(int avgSpeed) {
        AvgSpeed = avgSpeed;
    }

    public int getAvgMovingSpeed() {
        return AvgMovingSpeed;
    }

    public void setAvgMovingSpeed(int avgMovingSpeed) {
        AvgMovingSpeed = avgMovingSpeed;
    }

    public int getBestSpeed() {
        return BestSpeed;
    }

    public void setBestSpeed(int bestSpeed) {
        BestSpeed = bestSpeed;
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

    public int getAvgCyclingCadence() {
        return AvgCyclingCadence;
    }

    public void setAvgCyclingCadence(int avgCyclingCadence) {
        AvgCyclingCadence = avgCyclingCadence;
    }

    public int getMaxCyclingCadence() {
        return MaxCyclingCadence;
    }

    public void setMaxCyclingCadence(int maxCyclingCadence) {
        MaxCyclingCadence = maxCyclingCadence;
    }

    public int getAvgTemperature() {
        return AvgTemperature;
    }

    public void setAvgTemperature(int avgTemperature) {
        AvgTemperature = avgTemperature;
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

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
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
