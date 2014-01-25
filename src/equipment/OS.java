package equipment;

/**
 * Enumeration of operating system.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public enum OS {

    IOS("iOS"), ANDROID("Android");

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
    OS(String name) {

        this.setName(name);
    }

    @Override
    public String toString() {

        return this.getName();
    }
}
