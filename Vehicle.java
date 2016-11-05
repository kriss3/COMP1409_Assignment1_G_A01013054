
/**
 * Write a description of class Vehicle here.
 * 
 * @author Krzysztof Szczurowski 
 * @version 1.1
 * @date 11/05/2016
 * @since 11/05/2016
 * @see https://learn.bcit.ca/d2l/le/content/331960/viewContent/2110064/View
 */
public class Vehicle
{
    public static final int MIN_CAR_YEAR = 1970;
    public static final int MAX_CAR_YEAR = 2016;
    
    private String _stockCode;
    private String _make;
    private String _model;
    private int _year;
    private double _dealerCost;
    private double _sellingPrice;
    private double _profitMargin;
    
    /**
     * 
     */
    public Vehicle()
    {
        _stockCode = "Fiat_10000";
        _make = "Fiat";
        _model = "126p";
        _year = 1976;
        _dealerCost = 200;
        _sellingPrice = 1000;
        _profitMargin = (_sellingPrice - _dealerCost) / _sellingPrice;
    }
    
    /**
     * 
     */
    public Vehicle(String stockCode, String make, String model, int year)
    {
       setStockCode(stockCode);
       setMake(make);
       setModel(model);
       this._year = (year <= MIN_CAR_YEAR || year >= MAX_CAR_YEAR) ? 1978 : year;
    }
    
    /**
     * @return gets back StockCode as String;
     */
    public String getStockCode()
    {
        return this._stockCode;
    }
    
    public void setStockCode(String value)
    {
        this._stockCode = value;
    }
    
    /**
     * @return returns Make as String
     */
    public String getMake()
    {
        return this._make;
    }
    
    public void setMake(String value)
    {
        this._make = value;
    }
    
    /**
     * @return gets Model as String
     */
    public String getModel()
    {
        return this._model;
    }
    
    public void setModel(String value)
    {
        this._model = value;
    }
    
    /**
     * @return returns Year as Integer
     */
    public int getYear()
    {
        return this._year;
    }
    
    public void setYear(int _value)
    {
        if(_value <= MIN_CAR_YEAR || _value >= MAX_CAR_YEAR)
        {
            printYearError(_value);
        }
        else
        {
            this._year = _value;
        }
    }
    
    /**
     * @return returns Dealer Cost value as Double
     */
    public double getDealerCost()
    {
        return this._dealerCost;
    }
    
    public void setDealerCost(double value)
    {
        if(value >=0)
        {
            this._dealerCost = value;
        }
    }
    
    /**
     * @return returns Selling Price as Double
     */
    public double getSellingPrice()
    {
        return this._sellingPrice;
    }
    
    /**
     * @param takes parameter value as Double
     */
    public void setSellingPrice(double value)
    {
        if(value >= 0)
        {
            this._sellingPrice = value;
        }
    }
    
    
    public void checkStandardSellingPrice(double newSellingPrice)
    {
        double minPrice = _dealerCost + (25/100);
        if(newSellingPrice <= minPrice)
        {
            displaySellingPriceError(_dealerCost, _sellingPrice);
        }
        else
        {
            this._sellingPrice = newSellingPrice;
        }
    }
    
    public void calculateProfitMargin()
    {
        this._profitMargin = (_sellingPrice - _dealerCost) / _sellingPrice;
    }
    
    /**
     * @return returns calculated value of the profit in dollar amount
     */
    public double calculateProfit()
    {
        return _sellingPrice - _dealerCost;
    }
    
    /**
     * Method to display summary of Vehicle details <br>
     * It does not take any parametes <br>
     * It does not return any value;
     */
    public void printDetails()
    {
       System.out.println("Jalopies Are Us Vehicle Summary:");
       System.out.println("Vehicle: " + _year + " " + _make + " " + _model);
       System.out.println("Stock Code: " + _stockCode);
       System.out.printf("Dealer Cost: $%.2f \n", _dealerCost);
       System.out.printf("Selling Price: $%.2f \n", _sellingPrice);
       System.out.println("Profit Margin: " + String.format("%.0f%%",_profitMargin * 100));
       System.out.printf("Dollar Profit: $%.2f \n",calculateProfit()); 
    }
    
    /*
     * Helper method to display error message when value of car's year falls out of designated range
     */
    private void printYearError(int year)
    {
        System.out.println("ERROR !!!! \n Year Entered: " + _year + 
        "\nThe value for year must be between 1970 and 2016.\n" + 
        "Please, provide correct value for value of a year !!!");
    } 
    
    /*
     * Helper method to display error message when selling price does not meet minimum,
     * Minimum set to 25% above dealier cost
     */
    private void displaySellingPriceError(double _dealerCost, double _sellingPrice)
    {
        System.out.println("ERROR !!!!");
        System.out.println("Dealer Cost: " + _dealerCost);
        System.out.println("Selling Price: " + _sellingPrice);
        
    }
}
