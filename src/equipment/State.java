package equipment;

/**
 * Enumeration of state.
 * 
 * @author Falou SECK
 * 
 */
public enum State {

    FUNCTIONAL("Functional"), BROKEN("Broken");

    // Name.
    private String name;

    // Getters and setters.
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    /**
     * Default constructor.
     * 
     * @param name
     */
    State(String name) {

        this.setName(name);
    }

    @Override
    public String toString() {

        return this.getName();
    }
}
