package objects;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Material {

    private String name, description;
    private int quality;
    protected int damage; 
    
    
    public Material(String name, String description) {

        this.name = name;
        this.description = description;
        this.setQuality(100);
        this.damage=2;
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

    /**
     * @return the quality
     */
    public int getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(int quality) {
        if (quality<=100)
            this.quality = quality;
    }
}