package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for EditUserSetting
 */

public class EditUserSettingInput {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("UserName")
    String UserName;
    @JsonProperty("UserGender")
    String UserGender;
    @JsonProperty("UserHeight")
    int UserHeight;
    @JsonProperty("UserWeight")
    int UserWeight;
    @JsonProperty("BirthdayYear")
    String BirthdayYear;
    @JsonProperty("BirthdayMonth")
    String BirthdayMonth;
    @JsonProperty("BirthdayDay")
    String BirthdayDay;
    @JsonProperty("PhoneNumber")
    String PhoneNumber;
    @JsonProperty("FB")
    String FB;
    @JsonProperty("Twitter")
    String Twitter;
    @JsonProperty("WeChat")
    String WeChat;
    @JsonProperty("Youtube")
    String Youtube;
    @JsonProperty("StrideLength")
    int StrideLength;
    @JsonProperty("StepGoal")
    int StepGoal;
    @JsonProperty("SleepBedHour")
    String SleepBedHour;
    @JsonProperty("SleepBedMinute")
    String SleepBedMinute;
    @JsonProperty("SleepWakeHour")
    String SleepWakeHour;
    @JsonProperty("SleepWakeMinute")
    String SleepWakeMinute;
    @JsonProperty("AccessToken")
    String AccessToken;

    public EditUserSettingInput() {
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserGender() {
        return UserGender;
    }

    public void setUserGender(String userGender) {
        UserGender = userGender;
    }

    public int getUserHeight() {
        return UserHeight;
    }

    public void setUserHeight(int userHeight) {
        UserHeight = userHeight;
    }

    public int getUserWeight() {
        return UserWeight;
    }

    public void setUserWeight(int userWeight) {
        UserWeight = userWeight;
    }

    public String getBirthdayYear() {
        return BirthdayYear;
    }

    public void setBirthdayYear(String birthdayYear) {
        BirthdayYear = birthdayYear;
    }

    public String getBirthdayMonth() {
        return BirthdayMonth;
    }

    public void setBirthdayMonth(String birthdayMonth) {
        BirthdayMonth = birthdayMonth;
    }

    public String getBirthdayDay() {
        return BirthdayDay;
    }

    public void setBirthdayDay(String birthdayDay) {
        BirthdayDay = birthdayDay;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getFB() {
        return FB;
    }

    public void setFB(String FB) {
        this.FB = FB;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getWeChat() {
        return WeChat;
    }

    public void setWeChat(String weChat) {
        WeChat = weChat;
    }

    public String getYoutube() {
        return Youtube;
    }

    public void setYoutube(String youtube) {
        Youtube = youtube;
    }

    public int getStrideLength() {
        return StrideLength;
    }

    public void setStrideLength(int strideLength) {
        StrideLength = strideLength;
    }

    public int getStepGoal() {
        return StepGoal;
    }

    public void setStepGoal(int stepGoal) {
        StepGoal = stepGoal;
    }

    public String getSleepBedHour() {
        return SleepBedHour;
    }

    public void setSleepBedHour(String sleepBedHour) {
        SleepBedHour = sleepBedHour;
    }

    public String getSleepBedMinute() {
        return SleepBedMinute;
    }

    public void setSleepBedMinute(String sleepBedMinute) {
        SleepBedMinute = sleepBedMinute;
    }

    public String getSleepWakeHour() {
        return SleepWakeHour;
    }

    public void setSleepWakeHour(String sleepWakeHour) {
        SleepWakeHour = sleepWakeHour;
    }

    public String getSleepWakeMinute() {
        return SleepWakeMinute;
    }

    public void setSleepWakeMinute(String sleepWakeMinute) {
        SleepWakeMinute = sleepWakeMinute;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
}
