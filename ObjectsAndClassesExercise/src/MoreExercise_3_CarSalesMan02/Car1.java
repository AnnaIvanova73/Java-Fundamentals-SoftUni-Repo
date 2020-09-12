package MoreExercise_3_CarSalesMan02;

public class Car1 {


    public String getColor() {
        return this.color;
    }

    public String getWeight() {
        return this.weight;
    }

    public Engine1 getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }

    public Car1(String model, Engine1 engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    private String model;
    private Engine1 engine;
    private String weight;
    private String color;

    @Override
    public String toString() {
        return this.model + ":" +"\n"+ String.format("%s" +
                "  Weight: %s%n" +
                "  Color: %s",this.engine,this.weight,this.color);
    }
}
