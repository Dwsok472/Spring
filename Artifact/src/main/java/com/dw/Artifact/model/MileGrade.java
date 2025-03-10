package com.dw.Artifact.model;

public class MileGrade {
    private String mileageLevel; // 마일리지 등급
    private int lowMileage; // 하한마일리지
    private int hightMileage; // 상한마일리지


    public MileGrade() {
    }

    public MileGrade(String mileageLevel, int lowMileage, int hightMileage) {
        this.mileageLevel = mileageLevel;
        this.lowMileage = lowMileage;
        this.hightMileage = hightMileage;
    }

    public String getMileageLevel() {
        return mileageLevel;
    }

    public void setMileageLevel(String mileageLevel) {
        this.mileageLevel = mileageLevel;
    }

    public int getLowMileage() {
        return lowMileage;
    }

    public void setLowMileage(int lowMileage) {
        this.lowMileage = lowMileage;
    }

    public int getHightMileage() {
        return hightMileage;
    }

    public void setHightMileage(int hightMileage) {
        this.hightMileage = hightMileage;
    }

    @Override
    public String toString() {
        return "MileGrade{" +
                "mileageLevel='" + mileageLevel + '\'' +
                ", lowMileage=" + lowMileage +
                ", hightMileage=" + hightMileage +
                '}';
    }
}

