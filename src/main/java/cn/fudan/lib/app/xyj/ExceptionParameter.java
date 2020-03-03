package cn.fudan.lib.app.xyj;

import java.util.Date;

public class ExceptionParameter {

    private Long id;
    private String deviceCode;
    private String tableName;
    private String  deviceId;
    private Date exceptionDateTime;
    private String exceptionData;
    private String alarmLevel;
    private String exceptionInfo;
    private int dataStatus;
    private String exceptionHandler;
    private Date handlingTime;
    private String handlingRemark;
    private String appCode;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getTableName() {return tableName;}

    public void setTableName(String tableName) {this.tableName = tableName;}


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getExceptionDateTime() {
        return exceptionDateTime;
    }

    public void setExceptionDateTime(Date exceptionDateTime) {
        this.exceptionDateTime = exceptionDateTime;
    }

    public String getExceptionData() {
        return exceptionData;
    }

    public void setExceptionData(String exceptionData) {
        this.exceptionData = exceptionData;
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public int getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(int dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getExceptionHandler() {
        return exceptionHandler;
    }

    public void setExceptionHandler(String exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public Date getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(Date handlingTime) {
        this.handlingTime = handlingTime;
    }

    public String getHandlingRemark() {
        return handlingRemark;
    }

    public void setHandlingRemark(String handlingRemark) {
        this.handlingRemark = handlingRemark;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
}
