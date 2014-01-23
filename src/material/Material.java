package material;
import gestion_stock.Etat;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Material {

    private String name, description;
    private int quality;// A value between 0 and 100 to define the quality of the device
    protected int damage;// This property defines how the quality of the device is reduced after each loan
    private Etat state; 
    private int nombreEmprunt;
    private int numberOfRepair;

    public Material(String name, String description) {

        this.name = name;
        this.description = description;
        this.setQuality(100);
        this.damage = 2;
        this.setState(Etat.Disponible);
        this.nombreEmprunt=0;
        this.numberOfRepair=0;
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

    /**
     * @return the nombreEmprunt
     */
    public int getNombreEmprunt() {
        return nombreEmprunt;
    }

    /**
     * @param nombreEmprunt the nombreEmprunt to set
     */
    public void setNombreEmprunt(int nombreEmprunt) {
        this.nombreEmprunt = nombreEmprunt;
    }

    /**
     * @return the numberOfRepair
     */
    public int getNumberOfRepair() {
        return numberOfRepair;
    }

    /**
     * @param numberOfRepair the numberOfRepair to set
     */
    public void setNumberOfRepair(int numberOfRepair) {
        this.numberOfRepair = numberOfRepair;
    }
}