package com.example.unitcon;

public class Conversion {
    static final int FEET = 1;
    static final int INCHES = 2;
    static final int POUNDS = 3;
    static final double METERS_PER_FEET = 0.3048;
    static final double CENTIMETERS_PER_INCH = 2.56;
    static final double GRAMS_PER_LB= 453.592;
    private int isA;
    public String inputLable;
    public String outputLable;
    public Double inputValue;
    public Double outputValue;
    public Conversion(){
        isA=FEET;
        inputLable="FEET";
        outputLable="METER";
        inputValue= 0.0;
        outputValue= 0.0;
    }

    public void switch_toFeetMeters(){
        isA = FEET;
        inputLable="FEET";
        outputLable="METERS";
        compute();
    }
    public void switch_toInchesCentimeters(){
        isA= INCHES;
        inputLable="INCHES";
        outputLable="CENTIMETERS";
        compute();
    }
    public void switch_toPoundsGrams(){
        isA=POUNDS;
        inputLable="POUNDS";
        outputLable ="GRAMS";
        compute();
    }
    public void compute(){
        switch (isA){
            case FEET:
                outputValue=inputValue*METERS_PER_FEET;
                break;
            case INCHES:
                outputValue=inputValue*CENTIMETERS_PER_INCH;
                break;
            case POUNDS:
                outputValue=inputValue*GRAMS_PER_LB;
                break;
        }
    }

}
