package objects;

/**
 * 
 * @author Fabien PINEL
 * 
 */
public class Material {

    private String name, description;

    private int empruntTimeMax, empruntTime;

    public Material(String name, String description) {

        this.name = name;
        this.description = description;
        this.empruntTime = 7;
        this.empruntTimeMax = 200;
    }

    public Material(String name, String description, int dureeUsuelle) {

        this.name = name;
        this.description = description;
        this.empruntTime = dureeUsuelle;
        this.empruntTimeMax = 200;
    }

    public Material(String name, String description, int dureeUsuelle,
            int dureeMax) {

        this.name = name;
        this.description = description;
        this.empruntTime = dureeUsuelle;
        this.empruntTimeMax = dureeMax;
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

    public int getDureeEmpruntMax() {

        return empruntTimeMax;
    }

    public void setDureeEmpruntMax(int dureeEmpruntMax) {

        this.empruntTimeMax = dureeEmpruntMax;
    }

    public int getDureeEmpruntUsuelle() {

        return empruntTime;
    }

    public void setDureeEmpruntUsuelle(int dureeEmpruntUsuelle) {

        this.empruntTime = dureeEmpruntUsuelle;
    }

    public boolean equals(Material mat) {

        return (mat.getName().equals(this.getName()));
    }
}
