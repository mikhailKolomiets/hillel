package homework1;

/**
 * May create any animal
 */
public class Animal {

    /**
     * name animal - general future
     */
    private String name;

    /**
     * type animal separate by functional future
     */
    private String type;

    /**
     * Empty constructor
     */
    public Animal(){}//todo qwestion thy its normal or more - its needs

    /**
     * @param name - set name of animal with constructor
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Set name & type from animal
     * View only homework1 package (protected)
     */
    protected Animal(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * animal spoke about himself
     */
    public void voice() {
        System.out.println("Hello I am " + type + " by name " + name);
    }
}
