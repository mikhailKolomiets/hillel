package homework2.part2.AppleSeries;

import homework2.part2.OperationSystem;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class SuperIphone extends Apple {

    String color = "super";

    public SuperIphone() {
        setImei(upImei());
        setName("IPhone Super");
        setSize(8);
        setDisplay(7.9);
        setMemory(5000000);
        inslallOS(new OperationSystem(3.0));
    }

    public String getColor() {
        return color;
    }

    /**
     * This phone may change color by user
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

}
