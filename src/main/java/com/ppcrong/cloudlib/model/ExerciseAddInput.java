package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for ExerciseAdd
 */

public class ExerciseAddInput extends JsonBaseObject {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;
    @JsonProperty("StartTime")
    long StartTime;
    @JsonProperty("MovingTime")
    int MovingTime;
    @JsonProperty("ExecTime")
    int ExecTime;
    @JsonProperty("StepCount")
    int StepCount;
    @JsonProperty("Splits")
    int Splits;
    @JsonProperty("CumulativeTime")
    int CumulativeTime;
    @JsonProperty("Distance")
    float Distance;
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
    @JsonProperty("AvgHR")
    int AvgHR;
    @JsonProperty("MaxHR")
    int MaxHR;
    @JsonProperty("AvgRunCadence")
    int AvgRunCadence;
    @JsonProperty("MaxRunCadence")
    int MaxRunCadence;
    @JsonProperty("AvgStrideLength")
    int AvgStrideLength;
    @JsonProperty("AvgTemperature")
    int AvgTemperature;
    @JsonProperty("LatitudeArray")
    String LatitudeArray;
    @JsonProperty("LongtitudeArray")
    String LongtitudeArray;
    @JsonProperty("Type")
    int Type;
    @JsonProperty("Calories")
    int Calories;
    @JsonProperty("UniqueID")
    String UniqueID;

    public ExerciseAddInput() {
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

    public int getMovingTime() {
        return MovingTime;
    }

    public void setMovingTime(int movingTime) {
        MovingTime = movingTime;
    }

    public int getExecTime() {
        return ExecTime;
    }

    public void setExecTime(int execTime) {
        ExecTime = execTime;
    }

    public int getStepCount() {
        return StepCount;
    }

    public void setStepCount(int stepCount) {
        StepCount = stepCount;
    }

    public int getSplits() {
        return Splits;
    }

    public void setSplits(int splits) {
        Splits = splits;
    }

    public int getCumulativeTime() {
        return CumulativeTime;
    }

    public void setCumulativeTime(int cumulativeTime) {
        CumulativeTime = cumulativeTime;
    }

    public float getDistance() {
        return Distance;
    }

    public void setDistance(float distance) {
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

    public int getAvgRunCadence() {
        return AvgRunCadence;
    }

    public void setAvgRunCadence(int avgRunCadence) {
        AvgRunCadence = avgRunCadence;
    }

    public int getMaxRunCadence() {
        return MaxRunCadence;
    }

    public void setMaxRunCadence(int maxRunCadence) {
        MaxRunCadence = maxRunCadence;
    }

    public int getAvgStrideLength() {
        return AvgStrideLength;
    }

    public void setAvgStrideLength(int avgStrideLength) {
        AvgStrideLength = avgStrideLength;
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

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
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
