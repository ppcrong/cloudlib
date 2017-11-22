package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Input JSON for AuthUserbyFB
 */

public class AuthUserFBInput {
    @JsonProperty("FBID")
    String FBID;
    @JsonProperty("FBName")
    String FBName;
    @JsonProperty("MacAddress")
    String MacAddress;
    @JsonProperty("IPAddress")
    String IPAddress;

    public AuthUserFBInput() {
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

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String macAddress) {
        MacAddress = macAddress;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }
}
