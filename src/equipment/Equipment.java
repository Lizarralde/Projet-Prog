package equipment;

/**
 * Model of an equipment.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Equipment {

    // Description and name.
    private String description, name;

    // Getters and setters.
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

    /**
     * Default constructor.
     * 
     * @param name
     * @param description
     */
    public Equipment(String name, String description) {

        this.setDescription(description);
        this.setName(name);
    }

    @Override
    public String toString() {

        return this.getName() + " " + this.getDescription();
    }
}