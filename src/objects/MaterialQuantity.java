package objects;

public class MaterialQuantity {

    private int quantity;

    private Material mat;

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public Material getMat() {

        return mat;
    }

    public void setMat(Material mat) {

        this.mat = mat;
    }

    public MaterialQuantity(Material mat, int quant) {

        this.setMat(mat);
        this.setQuantity(quant);
    }
}
