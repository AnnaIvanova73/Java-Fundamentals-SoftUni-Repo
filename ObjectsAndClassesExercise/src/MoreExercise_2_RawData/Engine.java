package MoreExercise_2_RawData;

public class Engine {


    public int getEnginePower (){
        return enginePower;
    }
    public int getEngineSpeed() {
        return engineSpeed;
    }
    public Engine(int engineSpeed, int enginePower){
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
    private int engineSpeed;
    private int enginePower;
}
