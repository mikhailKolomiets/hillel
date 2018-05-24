package homework1;

/**
 * Created by Mikhail.K on 24.05.18.
 */
public class Main {
    public static void main(String[] args) {

        // create any objects of class Animal by different ways
        Animal animal = new Animal();
        Animal animalB = new Animal("Booka");
        Animal animalC = new Animal("Bobic", "dog");

        //set data from object animal
        animal.setName("April");
        animal.setType("cat");

        //animals calls about self
        animal.voice();
        animalC.voice();

        //Booka its undefindes type of animal
        animalB.voice();
    }
}
