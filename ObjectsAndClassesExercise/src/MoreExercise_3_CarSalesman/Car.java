package MoreExercise_3_CarSalesman;

public class Car {

    public String getCarModel() {
        return this.carModel;
    }


    public Engine getEngine() {
        return this.engine;
    }

    public String getCarWeight() {
        return this.carWeight;
    }

    public String getCarColour() {
        return this.carColour;
    }

    @Override
    public String toString() {
        Integer count = 0;
        String print = String.format("\n" +
                "%s\n" +
                "  Weight: %s\n" +
                "  Color: %s", this.engine, this.carWeight, this.carColour);

        count++;
        return print;
    }

    public Car(String carModel, Engine engine, String carWeight, String carColour) {
        this.carModel = carModel;
        this.engine = engine;
        this.carWeight = carWeight;
        this.carColour = carColour;
    }

    private String carModel;
    private Engine engine;
    private String carWeight;
    private String carColour;
}
