package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for UserDeviceAdd
 */

public class UserDeviceAddInput {
    @JsonProperty("AccountID")
    int AccountID;
    @JsonProperty("AccessToken")
    String AccessToken;
    @JsonProperty("DPN")
    String DPN;
    @JsonProperty("DeviceMac")
    String DeviceMac;
    @JsonProperty("DeviceName")
    String DeviceName;
    @JsonProperty("UniqueID")
    String UniqueID;

    public UserDeviceAddInput() {
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

    public String getDPN() {
        return DPN;
    }

    public void setDPN(String DPN) {
        this.DPN = DPN;
    }

    public String getDeviceMac() {
        return DeviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        DeviceMac = deviceMac;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(String uniqueID) {
        UniqueID = uniqueID;
    }
}
