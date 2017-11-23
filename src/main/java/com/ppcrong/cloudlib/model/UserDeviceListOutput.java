package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Output JSON for UserDeviceList
 */

public class UserDeviceListOutput extends JsonBaseObject {
    @JsonProperty("DeviceID")
    int DeviceID;
    @JsonProperty("DPN")
    String DPN;
    @JsonProperty("DeviceMac")
    String DeviceMac;
    @JsonProperty("DeviceName")
    String DeviceName;
    @JsonProperty("UniqueID")
    String UniqueID;
    @JsonProperty("ReturnCode")
    String ReturnCode;
    @JsonProperty("ReturnMessage")
    String ReturnMessage;

    public UserDeviceListOutput() {
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(int deviceID) {
        DeviceID = deviceID;
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

    public String getReturnCode() {
        return ReturnCode;
    }

    public void setReturnCode(String returnCode) {
        ReturnCode = returnCode;
    }

    public String getReturnMessage() {
        return ReturnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        ReturnMessage = returnMessage;
    }
}
