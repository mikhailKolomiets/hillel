package homework2.part3;

/**
 * Created by Mihail Kolomiets on 28.05.18.
 */
public class Colorifer {
    /**
     * Change themperature per 15 minute
     * amount from 8 to 20
     */
    private int power = 10;
    /**
     * Eaten fuel when start but not in change type mode
     */
    private int fuelNeeds = 1;
    /**
     * Make cold or hot
     */
    private boolean isColdType = true;
    private boolean isActive = false;

    public Colorifer() {
    }

    /**
     * Construct colorifer by his power
     */
    public Colorifer(int power) {
        //sample validation
        if (power < 8)
            power = 8;
        if (power > 20)
            power = 20;

        this.power = power;
        //get 2 l fuel if power above of 15
        this.fuelNeeds = power > 15 ? 1 : 2;

    }

    public boolean onOf() {
        setIsActive(!isActive());
        return isActive();
    }

    public boolean changeType() {
        //on colorifer if is d,t work
        if (!isActive())
            onOf();

        setIsColdType(!isColdType());
        return isColdType;
    }

    public boolean isColdType() {
        return isColdType;
    }

    public void setIsColdType(boolean isColdType) {
        this.isColdType = isColdType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getFuelNeeds() {
        return fuelNeeds;
    }

    public void setFuelNeeds(int fuelNeeds) {
        this.fuelNeeds = fuelNeeds;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
