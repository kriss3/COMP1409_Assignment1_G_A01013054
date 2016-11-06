
/**
 * Vehicle class for "Jalopies Are Us" company;
 * Assignment 1 from Gary Tong;
 * @author Krzysztof Szczurowski - A01013054 
 * @version 1.1
 * @date 11/05/2016
 * @since 11/05/2016
 * @see https://learn.bcit.ca/d2l/le/content/331960/viewContent/2110064/View
 */
public class Vehicle
{
    /** Min value of a year set to 1970 */
    public static final int MIN_CAR_YEAR = 1970;
    /** Max value of a year set to 2016 */
    public static final int MAX_CAR_YEAR = 2016;
    
    private String _stockCode;
    private String _make;
    private String _model;
    private int _year;
    private double _dealerCost;
    private double _sellingPrice;
    private double _profitMargin;
    
    /**
     * Parameterless/default constructor for Vehicle class <br>
     * Setting default valus for all instance variables. <br>
     * Year variable is calculated based on Selling Prince and Dealer Cost s
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
     * Custom constructor which take Stock Code, Make Model and Year; <br>
     * For Stock Code, Make and Model, it calls respected mutator method <br>
     * Year is checked agains MIN and MAX value; <br> 
     * If Year passed, falls outside of perimeter the default value is set to 1978
     * 
     * @param stockCode as String;
     * @param make as String;
     * @param model as String;
     * @param year as Integer;
     */
    public Vehicle(String stockCode, String make, String model, int year)
    {
       setStockCode(stockCode);
       setMake(make);
       setModel(model);
       this._year = (year <= MIN_CAR_YEAR || year >= MAX_CAR_YEAR) ? 1978 : year;
    }
    
    /**
     * Public getter method to fetch the value of StockCode; <br>
     * It does not take any parameters;
     * @return gets back StockCode as String;
     */
    public String getStockCode()
    {
        return this._stockCode;
    }
    
    /**
     * Public setter to set the value of Stock Code; <br>
     * It does not return any value; <br>
     * @param value of the StockCode as String;
     */
    public void setStockCode(String value)
    {
        this._stockCode = value;
    }
    
    /**
     * Public get method to fetch the value of Car's Make; <br>
     * It does not take any parameter; <br>
     * @return returns Make as String
     */
    public String getMake()
    {
        return this._make;
    }
    
    /**
     * Public setter/method that sets the value of car make; <br>
     * @param takes parameter value as String;
     */
    public void setMake(String value)
    {
        this._make = value;
    }
    
    /**
     * Public getter method to return Model name;
     * @return gets Model as String
     */
    public String getModel()
    {
        return this._model;
    }
    
    /**
     * Public setter mettor to set the valie of Car's Model
     * @param sets the value of a Molel as String;
     */
    public void setModel(String value)
    {
        this._model = value;
    }
    
    /**
     * Public getter method to return value of the Year set;
     * @return returns Year as Integer
     */
    public int getYear()
    {
        return this._year;
    }
    
    /**
     * Public setter method to set the valie of car's year; <br>
     * It does not return any value; <br>
     * It validate value passed in and when if falls bellow MIN and above MAX year, error message is displayed;
     * @param value of a year passed as Integer;
     */
    public void setYear(int value)
    {
        if(value <= MIN_CAR_YEAR || value >= MAX_CAR_YEAR)
        {
            printYearError(value);
        }
        else
        {
            this._year = value;
        }
    }
    
    /**
     * Public getter method taht returns a value of dealer cost; <br>
     * It does not take any parameter;
     * @return returns Dealer Cost value as Double
     */
    public double getDealerCost()
    {
        return this._dealerCost;
    }
    
    /**
     * Public method/setter that sets the value of dealer cost; <br>
     * It validates passed paramets and make sure it is not a negative number;
     * @return returns value of dealer cost as Double;
     */
    public void setDealerCost(double value)
    {
        if(value >=0)
        {
            this._dealerCost = value;
        }
    }
    
    /**
     * Public getter/method to return value of the Selling Price; <br>
     * It does not take a parameter; 
     * @return returns Selling Price as Double
     */
    public double getSellingPrice()
    {
        return this._sellingPrice;
    }
    
    /**
     * Public method to check new selling price; <br>
     * Price will be rejected if falls below 25% above dealer cost; <br>
     * It does not return any value;
     * @param newSellingPrice as double 
     */
    public void checkStandardSellingPrice(double newSellingPrice)
    {
        double minPrice = _dealerCost + ((_dealerCost * 25) /100);
        if(newSellingPrice <= minPrice)
        {
            displaySellingPriceError(_dealerCost, _sellingPrice, newSellingPrice);
        }
        else
        {
            this._sellingPrice = newSellingPrice;
        }
    }
    
    /**
     * Public method that calculates and sets profitMargin based on sellingPrice and dealerCost; <br>
     * It does not return any value and it does not take any parameter;
     */
    public void calculateProfitMargin()
    {
        this._profitMargin = (_sellingPrice - _dealerCost) / _sellingPrice;
    }
    
    /**
     * Public method that calculates Profit made in dolaras; <br>
     * Calculation is made based on sellingPrice and dealerCost
     * It does not take any parameter; <br>
     * @return returns calculated value of the profit in dollar amount
     */
    public double calculateProfit()
    {
        return _sellingPrice - _dealerCost;
    }
    
    /**
     * Method to display summary of Vehicle details <br>
     * It does not take any parametes <br>
     * It does not return any value; <br>
     * Prints details of the Vehicle class;
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
        "The value for year must be between 1970 and 2016.\n" + 
        "Please, provide correct year value !!!");
    } 
    
    /*
     * Helper method to display error message when selling price does not meet minimum,
     * Minimum set to 25% above dealier cost
     */
    private void displaySellingPriceError(double _dealerCost, double _sellingPrice, double newSellingPrice)
    {
        System.out.println("ERROR !!!!");
        System.out.printf("Dealer Cost: $%.2f \n", _dealerCost);
        System.out.printf("Current Selling Price: $%.2f \n", _sellingPrice);
        System.out.printf("Proposed Selling Price: $%.2f \n", newSellingPrice);
        System.out.println("Proposed Selling Price needs to be at lest 25% higher than Dealer Cost !");
    }
}
