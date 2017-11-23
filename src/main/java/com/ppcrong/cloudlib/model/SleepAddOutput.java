package com.ppcrong.cloudlib.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Output JSON for StepAdd
 */

public class SleepAddOutput extends JsonBaseObject {
    @JsonProperty("StartTime")
    long StartTime;
    @JsonProperty("ReturnCode")
    String ReturnCode;
    @JsonProperty("ReturnMessage")
    String ReturnMessage;

    public SleepAddOutput() {
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
