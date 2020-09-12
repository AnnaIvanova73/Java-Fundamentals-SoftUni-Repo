package MoreExercise_2_RawData;

public class ModelCar {

    public Tires getTires (){
        return tires;
    }
    public void setTires(Tires tires){
        this.tires=tires;
    }

    public Cargo getCargo(){
        return cargo;
    }
    public void setCargo(Cargo cargo){
        this.cargo=cargo;
    }

    public String getCar (){
        return car;
    }
    public void setCar(String car){
        this.car=car;
    }

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public ModelCar(String car, Engine engine, Cargo cargo, Tires tires) {
        this.car = car;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    private String car;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

}
