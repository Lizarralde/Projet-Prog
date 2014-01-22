package equipment;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class MaterialQuantity {

    private int quantity;

    private Equipment material;

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public Equipment getMat() {

        return material;
    }

    public void setMat(Equipment material) {

        this.material = material;
    }

    public MaterialQuantity(Equipment material, int quantity) {

        this.setMat(material);
        this.setQuantity(quantity);
    }
}
