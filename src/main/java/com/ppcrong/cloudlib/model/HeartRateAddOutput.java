package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Output JSON for HeartRateAdd
 */

public class HeartRateAddOutput extends JsonBaseObject {
    @JsonProperty("RecTime")
    long RecTime;
    @JsonProperty("ReturnCode")
    String ReturnCode;
    @JsonProperty("ReturnMessage")
    String ReturnMessage;

    public HeartRateAddOutput() {
    }

    public long getRecTime() {
        return RecTime;
    }

    public void setRecTime(long recTime) {
        RecTime = recTime;
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
