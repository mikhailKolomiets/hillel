package homework2.part3;

import java.util.Scanner;

/**
 * Created by Mihail Kolomiets on 28.05.18.
 * <p>
 * Play content sample play engine by console control
 */
public class Play {
    public static void start() {

        /**
         * main game car
         */
        Car car = null;

        //https://www.mkyong.com/java/how-to-read-input-from-console-java/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Input 1 to create new car, 2 by random, or 3 by default:");

        //---------------------------------- Create car --------------------------------------------------------------
        while (car == null) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                /**
                 * get data from new car
                 */
                System.out.println("Car name?");
                String name = scanner.nextLine();
                //todo Exception handler from all parse integer
                System.out.println("Fuel maximum capacity?");
                int fuelTank = Integer.valueOf(scanner.nextLine());
                System.out.println("Engine amount (mm3)? (200 - 4000)");
                int engineAmount = Integer.valueOf(scanner.nextLine());
                System.out.println("Engine fuel by acceleration?(5 - 30)");
                int fuelConsumption = Integer.valueOf(scanner.nextLine());
                System.out.println("Engine horses power?");
                int power = Integer.valueOf(scanner.nextLine());
                System.out.println("Colorifer power?(8 - 20)");
                int powerColorifer = Integer.valueOf(scanner.nextLine());
                /**
                 * Create car by collect data
                 */
                Engine engine = new Engine(engineAmount, fuelConsumption, power);
                Colorifer colorifer = new Colorifer(powerColorifer);
                car = new Car(engine, colorifer, name, fuelTank);
            }
            if (input.equals("2")) {
                /**
                 * Create random car
                 */
                int fuelTank = (int) (Math.random() * 70);
                fuelTank = fuelTank < 20 ? 20 : fuelTank; // tank minimum 20 l, but it is not interesting
                int engineAmount = (int) (Math.random() * 4000);
                int fuelConsumption = (int) (Math.random() * 30);
                int power = (int) (Math.random() * 400);
                int powerColorifer = (int) (Math.random() * 25);
                Engine engine = new Engine(engineAmount, fuelConsumption, power);
                Colorifer colorifer = new Colorifer(powerColorifer);
                car = new Car(engine, colorifer, "Randomic 2018", fuelTank);
            }
            if (input.equals("3")) {
                car = new Car();
            }

            //send info about the car in console
            if (car != null) {
                System.out.println("Created car:");
                car.infoCar();
            }
        }
        //------------------------------------- Play with car --------------------------------------------------------
        Engine engine = car.getEngine();
        Colorifer colorifer = car.getColorifer();


        System.out.println("\n-----------game control(h)--------------");
        viewOptions();

        /**
         * game engine
         *
         * 1 iteration it 15 game minute
         * avery 15 minute friction take 9 km/h from car speed
         */
        boolean exit = false;
        while (!exit) {

            int speed = car.getSpeedNow();
            if (speed > 0) {
                car.setMileage(car.getMileage() + speed / 4);

                //roll car
                speed = speed > 9 ? speed - 9 : 0;
                car.setSpeedNow(speed);
            }

            /**
             * Climate control
             */
            int temperature = car.getTemperature();
            if (colorifer.isActive()) {
                temperature += colorifer.isColdType() ? -colorifer.getPower() : colorifer.getPower();
            }
            car.setTemperature(temperature - speed / 10);
            if (temperature > 30)
                System.out.println("It so hot " + temperature + "C, turn cold by colorifer please (t)");
            if (temperature < 10)
                System.out.println("It so cold " + temperature + "C, turn hot type please (t)");


            /**
             * game control
             */
            String comand = scanner.nextLine();
            switch (comand) {
                case "q":
                    exit = true;
                    break;
                case "i":
                    car.infoCar();
                    break;
                case "p":
                    engine.engineInfo(car.getNameModel());
                    break;
                case "e":
                    //need 1 l of fuel from start all engine todo make with engine power
                    if (car.getFuel() < 1)
                        System.out.println("you haven't fuel from start engine");
                    else {
                        if (!engine.isActive())
                            car.setFuel(car.getFuel() - 1);
                        car.getEngine().turnUpEngine();
                        System.out.println("Engine is turn" + car.onOfByCondition(car.getEngine().isActive()));
                    }
                    break;
                case "c":
                    System.out.println("Colorifer is " + car.onOfByCondition(car.getColorifer().onOf()));
                    if (colorifer.isActive())
                        car.setFuel(car.getFuel() - 1);
                    break;
                case "t":
                    System.out.println("Colorifer now by " + (colorifer.changeType() ? "cold" : "hot"));
                    break;

                /**
                 * Acceleration
                 * need 2 l of fuel by next +30 km per hour
                 */
                case "w":
                    if (engine.isActive()) {
                        if (car.getFuel() > 2) {
                            car.setFuel(car.getFuel() - 2);
                            int nextSpeed = car.getSpeedNow() + 30;
                            if (nextSpeed > car.getMaxSpeed())
                                nextSpeed = car.getMaxSpeed();
                            car.setSpeedNow(nextSpeed);
                            System.out.println("Now you " + car.getNameModel() + " have " + nextSpeed + " km/h");
                        } else {
                            System.out.println("You tank is empty, car only roll...");
                        }
                    } else {
                        System.out.println(car.getNameModel() + "'s engine is turn off, 'e' button for turn on");
                    }
                    break;
                case "s":
                    int nextSpeed = car.getSpeedNow() - 30;
                    if (nextSpeed < 0)
                        nextSpeed = 0;
                    car.setSpeedNow(nextSpeed);
                    System.out.println("Now you " + car.getNameModel() + " have " + nextSpeed + " km/h");
                    break;
                case "x":
                    car.setSpeedNow(0);
                    System.out.println("Car extremal braking to 0 km/h");
                    break;
                default:
                    viewOptions();
            }
        }

        // free some memory
        scanner.close();
    }

    private static void viewOptions() {
        System.out.println("h - this menu, e - turn on/of engine, c - turn on/of colorifer,\n" +
                "t - colorifer type hot/cold, i - infocar, p - engine info, w - 30 km/h +, s - 30 km/h -, x - 0 km, q -exit");
    }
}
