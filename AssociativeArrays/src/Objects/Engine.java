package Objects;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = (displacement != null) ? displacement : "n/a";
        this.efficiency = (efficiency != null) ? efficiency : "n/a";
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return model + ":" + System.lineSeparator() +
                "Power: " + power + System.lineSeparator() +
                "Displacement: " + displacement + System.lineSeparator() +
                "Efficiency: " + efficiency;
    }
}
