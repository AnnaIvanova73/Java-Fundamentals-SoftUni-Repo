package Objects;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = (weight != null) ? weight : "n/a";
        this.color = (color != null) ? color : "n/a";
    }

    @Override
    public String toString() {
        return model + ":" + System.lineSeparator() +
                engine + System.lineSeparator() +
                "Weight: " + weight + System.lineSeparator() +
                "Color: " + color;
    }
}
