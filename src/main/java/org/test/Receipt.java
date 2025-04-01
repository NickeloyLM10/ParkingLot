package org.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Receipt {
    private Date startTime;
    private Date endTime;
    private String vehicleNum;
    private int bill;

    public Receipt(Date startTime, String vehicleNum) {
        this.startTime = startTime;
        this.vehicleNum = vehicleNum;
        this.bill = -1;
    }

    public void calculateBill(Date endTime){
        this.endTime = endTime;
        long time = endTime.getTime()-startTime.getTime();
        long cal = TimeUnit.MINUTES.toMinutes(time);
        bill = (int) (10*(cal));
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}
