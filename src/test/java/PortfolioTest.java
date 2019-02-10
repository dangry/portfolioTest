import models.Portfolio;
import models.Profit;
import models.Stock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PortfolioTest {

    Stock stockA;
    Stock stockB;
    Stock stockC;
    Stock stockD;

    @Before
    public void setStocks() throws Exception {

        String stockAName = "BTC";
        String stockBName = "ETH";
        String stockCName = "XRP";
        String stockDName = "STOCKD";

        this.stockA = new Stock(stockAName);
        this.stockB = new Stock(stockBName);
        this.stockC = new Stock(stockCName);
        this.stockD = new Stock(stockDName);

        stockA.addPrice(new Date(2000, 1, 1), 100);
        stockA.addPrice(new Date(2001, 1, 1), 200);

        stockB.addPrice(new Date(2000, 1, 1), 200);
        stockB.addPrice(new Date(2001, 1, 1), 300);

        stockC.addPrice(new Date(2000, 1, 1), 100);
        stockC.addPrice(new Date(2001, 1, 1), 200);

        // Example from: https://www.investopedia.com/terms/a/annual-return.asp
        stockD.addPrice(new Date(2000, 1, 1), 20);
        stockD.addPrice(new Date(2005, 1, 1), 37);
    }

    @Test
    public void addStockToPortfolio() {

        Portfolio portfolio = new Portfolio();

        portfolio.addStock(stockA);

        Assert.assertNotNull(portfolio.stockList);
        Assert.assertEquals(1, portfolio.stockList.size());

    }

    @Test
    public void getStockFromPortfolio() {
        Portfolio portfolio = new Portfolio();

        portfolio.addStock(stockA);

        Assert.assertEquals(100, portfolio.stockList.get("BTC")
                .price(new Date(2000, 1, 1)), 0);

    }

    @Test
    public void getPortfolioProfitAmount() {
        Portfolio portfolio = new Portfolio();

        portfolio.addStock(stockB);
        portfolio.addStock(stockC);

        Profit profit = portfolio.profit(new Date(2000, 1, 1), new Date(2001, 1, 1));

        Assert.assertEquals(200, profit.profitAmount, 0);

    }

    @Test
    public void getPortfolioAnnualizedReturn() {
        Portfolio portfolio = new Portfolio();

        portfolio.addStock(stockD);

        Profit profit = portfolio.profit(new Date(2000, 1, 1), new Date(2005, 1, 1));

        Assert.assertEquals(0.131, profit.annualizedReturn, 1);

    }

}
