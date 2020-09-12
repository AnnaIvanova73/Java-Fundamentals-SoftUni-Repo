package MoreExercise_3_CarSalesman;

public class Engine {
    public String getEngineModel() {
        return this.engineModel;
    }

    public String getEngPower() {
        return this.engPower;
    }

    public String getEngDisplacement() {
        return this.engDisplacement;
    }

    public String getEngEfficiency() {
        return this.engEfficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:\n    Power: %s\n" +
                "    Displacement: %s\n" +
                "    Efficiency: %s", this.engineModel, this.engPower, this.engDisplacement, this.engEfficiency);

    }


    public Engine(String engineModel, String engPower, String engDisplacement, String engEfficiency) {
        this.engineModel = engineModel;
        this.engPower = engPower;
        this.engDisplacement = engDisplacement;
        this.engEfficiency = engEfficiency;
    }

    private String engineModel;
    private String engPower;
    private String engDisplacement;
    private String engEfficiency;
}
