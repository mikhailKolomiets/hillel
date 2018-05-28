package homework2.part3;

/**
 * Created by Mihail Kolomiets on 28.05.18.
 */
public class Engine {

    private int amount = 1500;
    /**
     * get fuel by acceleration
     */
    private int fuelConsumption = 10;
    /**
     * Horses power no more of amount / 10
     */
    private int power = 100;
    private boolean isActive = false;

    public Engine() {
    }

    public Engine(int amount, int fuelConsumption, int power) {
        if (amount < 200)
            amount = 200;
        if (amount > 4000)
            amount = 4000;
        if (fuelConsumption < 5)
            fuelConsumption = 5;
        if (fuelConsumption > 30)
            fuelConsumption = 30;
        if (power < 20)
            power = 20;
        if (power > amount / 10)
            power = amount / 10;

        this.amount = amount;
        this.fuelConsumption = fuelConsumption;
        this.power = power;
    }

    public void engineInfo(String name) {
        System.out.println("Info about " + name + " engine:\n" + amount + " mm3, " + power + " horses power and "
                + fuelConsumption + " fuel by acceleration");
    }

    /**
     * start/stop engine
     */
    public void turnUpEngine() {
        setIsActive(!isActive);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
