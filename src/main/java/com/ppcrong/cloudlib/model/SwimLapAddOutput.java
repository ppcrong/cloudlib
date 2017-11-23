package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Output JSON for SwimLapAdd
 */

public class SwimLapAddOutput extends JsonBaseObject {
    @JsonProperty("StartTime")
    long StartTime;
    @JsonProperty("ReturnCode")
    String ReturnCode;
    @JsonProperty("ReturnMessage")
    String ReturnMessage;

    public SwimLapAddOutput() {
    }

    public long getStartTime() {
        return StartTime;
    }

    public void setStartTime(long startTime) {
        StartTime = startTime;
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
