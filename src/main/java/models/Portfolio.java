package models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static util.DataUtil.getDiffYears;


public class Portfolio {

    public HashMap<String, Stock> stockList;

    public Portfolio() {
        this.stockList = new HashMap<>();
    }

    public void addStock(Stock stock) {
        stockList.put(stock.name, stock);
    }

    public Profit profit(Date startDate, Date endDate) {

        Profit profit = new Profit();
        int diff = getDiffYears(startDate, endDate);

        double startPortfolioValue = 0;
        double endPortfolioValue = 0;

        for(Map.Entry<String, Stock> stockEntry : stockList.entrySet()) {
            startPortfolioValue += stockEntry.getValue().price(startDate);
            endPortfolioValue += stockEntry.getValue().price(endDate);
        }

        profit.profitAmount = endPortfolioValue - startPortfolioValue;

        profit.annualizedReturn =  Math.pow(endPortfolioValue / startPortfolioValue, 1F / diff) - 1;

        return profit;
    }
}
