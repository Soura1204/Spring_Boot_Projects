import java.util.ArrayList;
import java.util.List;


interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}


class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private float price;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}


interface Observer {
    void update(String stockName, float price);
}


class MobileApp implements Observer {
    
    public void update(String stockName, float price) {
        System.out.println("MobileApp: The price of " + stockName + " has changed to $" + price);
    }
}

class WebApp implements Observer {
    
    public void update(String stockName, float price) {
        System.out.println("WebApp: The price of " + stockName + " has changed to $" + price);
    }
}


public class ObserverPatternExample {
    public static void main(String[] args) {
        
        StockMarket stockMarket = new StockMarket("AAPL");

        
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        
        System.out.println("Updating stock price...");
        stockMarket.setPrice(150.0f);

        
        System.out.println("Updating stock price...");
        stockMarket.setPrice(155.5f);

        
        stockMarket.deregisterObserver(webApp);

        
        System.out.println("Updating stock price...");
        stockMarket.setPrice(160.0f);
    }
}
