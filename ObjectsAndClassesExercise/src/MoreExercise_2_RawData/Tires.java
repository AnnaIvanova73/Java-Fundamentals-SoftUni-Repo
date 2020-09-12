package MoreExercise_2_RawData;

public class Tires {


    public double getTireOnePressure() {
        return tireOnePressure;
    }

    public double getTireTwoPressure() {
        return tireTwoPressure;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }

    public Tires(double tireOnePressure, int tireOneAge,
                 double tireTwoPressure, int tireTwoAge,
                 double tire3Pressure, int tire3Age,
                 double tire4Pressure, int tire4Age) {
        this.tireOnePressure = tireOnePressure;
        this.tireOneAge = tireOneAge;
        this.tireTwoPressure = tireTwoPressure;
        this.tireTwoAge = tireTwoAge;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    private double tireOnePressure;
    private int tireOneAge;
    private double tireTwoPressure;
    private int tireTwoAge;
    private double tire3Pressure;
    private int tire3Age;
    private double tire4Pressure;
    private int tire4Age;

}
