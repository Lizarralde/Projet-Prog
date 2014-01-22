package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Equipment {

    private String name, description;

    private int quality;

    private int damage;

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

    public int getQuality() {

        return quality;
    }

    public void setQuality(int quality) {

        if (quality <= 100) {

            this.quality = quality;
        }
    }

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    public Equipment(String name, String description) {

        this.setName(name);
        this.setDescription(description);
        this.setQuality(100);
        this.setDamage(damage);
    }

    @Override
    public boolean equals(Object obj) {

        return (((Equipment) obj).getName().equals(name));
    }
}