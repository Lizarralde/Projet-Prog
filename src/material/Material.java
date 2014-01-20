<<<<<<< HEAD:src/objects/Material.java
package objects;
import gestion_stock.Etat;
=======
package material;

>>>>>>> c5fef310894ad4ddbfd678208f3ebe5d5702ec68:src/material/Material.java
/**
 * 
 * @author Dorian LIZARRALDE - Falou SECK
 * 
 */
public class Material {

    private String name, description;
    private int quality;
<<<<<<< HEAD:src/objects/Material.java
    private Etat state;
    protected int damage; 
    
    
    
=======
    protected int damage;

>>>>>>> c5fef310894ad4ddbfd678208f3ebe5d5702ec68:src/material/Material.java
    public Material(String name, String description) {

        this.name = name;
        this.description = description;
        this.setQuality(100);
<<<<<<< HEAD:src/objects/Material.java
        this.damage=2;
        this.setState(Etat.Disponible);
=======
        this.damage = 2;
>>>>>>> c5fef310894ad4ddbfd678208f3ebe5d5702ec68:src/material/Material.java
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
     * @param quality
     *            the quality to set
     */
    public void setQuality(int quality) {
        if (quality <= 100)
            this.quality = quality;
    }

    /**
     * @return the state
     */
    public Etat getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Etat state) {
        this.state = state;
    }
    
    public void qualityCommit(){
        this.quality-=this.damage;
    }
}