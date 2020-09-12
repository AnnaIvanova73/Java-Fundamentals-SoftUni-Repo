package MoreExercise_2_RawData;

public class Cargo {

    public String getCargoType() {
        return cargoType;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public Cargo(String cargoType, int cargoWeight) {
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }

    private String cargoType;
    private int cargoWeight;
}
