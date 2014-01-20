package objects;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Material {

    private String name, description;

    public Material(String name, String description) {

        this.name = name;
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public boolean equals(Material mat) {

        return (mat.getName().equals(this.getName()));
    }
}