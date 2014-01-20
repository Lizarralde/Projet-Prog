package management;

import java.util.ArrayList;
import java.util.List;

import material.MaterialQuantity;

/**
 * The class Stock contains the list of all the reservation and the initial
 * stock.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Stock {

    private List<Reservation> reservList;

    private List<MaterialQuantity> materialStock;

    public List<Reservation> getReservList() {

        return reservList;
    }

    public void setReservList(List<Reservation> reservList) {

        this.reservList = reservList;
    }

    public List<MaterialQuantity> getMaterialStock() {

        return materialStock;
    }

    public void setMaterialStock(List<MaterialQuantity> materialStock) {

        this.materialStock = materialStock;
    }

    public Stock(List<MaterialQuantity> materialStock) {

        this.reservList = new ArrayList<Reservation>();
        this.materialStock = materialStock;
    }

    @Override
    public String toString() {

        String stock = new String();

        for (int i = 0; i < this.materialStock.size(); i++) {
            stock += i + ". " + this.materialStock.get(i).getMat().getName()
                    + " ("
                    + this.materialStock.get(i).getMat().getDescription()
                    + ") - " + this.materialStock.get(i).getQuantity()
                    + System.getProperty("line.separator");
        }

        return stock;
    }
}
