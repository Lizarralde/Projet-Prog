package management;

/**
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class StockController {

    // Stock.
    private Stock stock;

    // Getters and setters.
    public Stock getStock() {

        return stock;
    }

    public void setStock(Stock stock) {

        this.stock = stock;
    }

    /**
     * Default constructor.
     * 
     * @param stock
     */
    public StockController(Stock stock) {

        this.setStock(stock);
    }
}
