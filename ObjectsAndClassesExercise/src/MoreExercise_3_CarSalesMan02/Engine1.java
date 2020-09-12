package MoreExercise_3_CarSalesMan02;

public class Engine1 {


    public String getEfficiency() {
        return this.efficiency;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getPower() {
        return this.power;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public Engine1(String engineModel, String power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return "  " + this.engineModel + ":" + "\n"+String.format(
                "    Power: %s%n" +
                        "    Displacement: %s%n" +
                        "    Efficiency: %s%n", this.power, this.displacement, this.efficiency);
    }

    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

}
