package equipment;

/**
 * Model of an equipment.
 * 
 * @author Falou SECK
 * 
 */
public class Equipment {

    private State state;

    // Description and name.
    private String description, name;

    private int numberOfLoans, numberOfRepair;

    // Getters and setters.
    public State getState() {

        return state;
    }

    public void setState(State state) {

        this.state = state;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getNumberOfLoans() {

        return numberOfLoans;
    }

    public void setNumberOfLoans(int numberOfLoans) {

        this.numberOfLoans = numberOfLoans;
    }

    public int getNumberOfRepair() {

        return numberOfRepair;
    }

    public void setNumberOfRepair(int numberOfRepair) {

        this.numberOfRepair = numberOfRepair;
    }

    /**
     * Default constructor.
     * 
     * @param name
     * @param description
     */
    public Equipment(String name, String description) {

        this.setState(State.FUNCTIONAL);
        this.setDescription(description);
        this.setName(name);
        this.setNumberOfLoans(0);
        this.setNumberOfRepair(0);
    }

    @Override
    public String toString() {

        return this.getName() + " " + this.getDescription() + "\tState : "
                + this.getState();
    }
}