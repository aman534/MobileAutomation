package com.enums;

public enum BandWidth {

    WIFI(100), TWOG(30), THREEG(50), FOURG(75) ;
    public int speed;

    private BandWidth(int speed){
        this.speed=speed;
    }
public int getBandWidth(){
  return speed;
}

}
