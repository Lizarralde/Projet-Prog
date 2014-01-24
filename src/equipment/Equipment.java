package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Equipment {

    private String description, name;

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

    public Equipment(String name, String description) {

        this.setDescription(description);
        this.setName(name);
    }

    @Override
    public String toString() {

        return this.getName() + " " + this.getDescription();
    }
}