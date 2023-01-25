public class Product{
	//the attributes
	private String name;
	private int stockLevel;
	private double price;
	
	//the constructor
	public Product(String nameIn, int stockLevelIn, double priceIn){
		name = nameIn;
		stockLevel = stockLevelIn;
		price = priceIn;
	}
	//method that returns the stock bought 
	public double buyStock(int stockBoughtIn){
	    stockLevel += stockBoughtIn;
	    return stockLevel;
	}
	//method that receives the number of items sold
	public boolean sell(int itemSoldIn){
		if(itemSoldIn < stockLevel){
		    stockLevel -= itemSoldIn;
		    return true;
		} else {
		    return false;
		}
	}
	//method that sets the new price
	public double setPrice(double newPriceIn){
	    return price = newPriceIn;
	}
	//method that returns the name of the product
	public String getName(){
		return name;
	}
	//method that returns the price of the product
	public double getPrice(){
		return price;
	}
	//method that returns the stock level of the product
	public int getStockLevel(){
		return stockLevel;
	}
}
