package homework2.part3;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class Car {

    private Engine engine;
    private String nameModel = "Lanos";
    private Colorifer colorifer;
    private int maxSpeed;
    private int fuel = 20;
    private int fuelCapacity = 40;
    private int mileage = 0;
    private int temperature = 20;
    private int speedNow = 0;

    /**
     * Create default car with default parameters
     */
    public Car() {
        engine = new Engine();
        colorifer = new Colorifer();
        maxSpeed = 150;
    }

    public Car(Engine engine, Colorifer colorifer, String nameModel, int fuelCapacity) {
        this.engine = engine;
        this.colorifer = colorifer;
        this.nameModel = nameModel;
        this.fuelCapacity = fuelCapacity;

        //pour fuel is always half of tank capacity
        fuel = fuelCapacity / 2;

        // maxSpeed always 1.5 of engine power
        maxSpeed = engine.getPower() * 3 / 2;

    }

    /**
     * out to console info about this car
     */
    public void infoCar() {
        System.out.println(nameModel + ": speed " + speedNow + " km/h, T " + temperature + "C, fuel " + fuel +
                " L\nengine " + onOfByCondition(engine.isActive()) + ", colorifer " + onOfByCondition(colorifer.isActive()) + " cold " +
                onOfByCondition(colorifer.isColdType()) + ", mileage: " + mileage);
    }

    /**
     * method by sample refactor code
     *
     * @param condition - some boolean condition
     * @return ternar: on if true, else off
     */
    public String onOfByCondition(boolean condition) {
        return condition ? "on" : "off";
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public Colorifer getColorifer() {
        return colorifer;
    }

    public void setColorifer(Colorifer colorifer) {
        this.colorifer = colorifer;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getSpeedNow() {
        return speedNow;
    }

    public void setSpeedNow(int speedNow) {
        this.speedNow = speedNow;
    }
}
