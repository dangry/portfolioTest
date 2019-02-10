import models.Stock;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class StockTest {

    @Test
    public void addStockPrice() throws Exception {
        Stock stockA = new Stock("BTC");
        stockA.addPrice(new Date(2000, 1, 1), 100);

        Assert.assertNotNull(stockA.price(new Date(2000, 1, 1)));
        Assert.assertEquals("BTC", stockA.name);
        Assert.assertEquals(100, stockA.price(new Date(2000, 1, 1)), 0);
    }

}
