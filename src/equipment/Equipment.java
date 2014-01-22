package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Equipment {

    private String description, name;

    private int damage;

    private int quality;

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

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    public int getQuality() {

        return quality;
    }

    public void setQuality(int quality) {

        if (quality <= 100) {

            this.quality = quality;
        }
    }

    public Equipment(String name, String description) {

        this.setDescription(description);
        this.setName(name);
        this.setDamage(damage);
        this.setQuality(100);
    }

    @Override
    public boolean equals(Object obj) {

        return (((Equipment) obj).getName().equals(name));
    }
}