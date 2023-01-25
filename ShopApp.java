import java.util.Scanner;

public class ShopApp{
    public static void main(String[] args){
        //create array of objects
        Product[] item = new Product[5];
        //list of objects
        item[0] = new Product("Iphone 13", 9, 769.29);
        item[1] = new Product("Pixel 6", 7, 441.12);
        item[2] = new Product("Galaxy A53", 5, 349.99);
        item[3] = new Product("Reno 8", 4, 689.33);
        item[4] = new Product("Nord N20", 5, 229.99);
        //create the scanner
        Scanner sc = new Scanner(System.in);
        int num;
        //main menu
        String mainMenu = ("\nPress a number:" 
            + "\n1.Display all products" 
            + "\n2.Buy stock"
            + "\n3.Sell stock"
            + "\n4.Re-price product"
            + "\n5.Display total value of the stock"
            + "\n6.Exit");
        //my student number    
        System.out.println("Student number: 2219441");    
        //let's start
        do{
            //choose operation
            System.out.println(mainMenu);
            num = sc.nextInt(); 
            //check number
            switch(num){
            //display all products    
            case 1: 
                for(Product items : item){
                    System.out.println("\nPhone: "+items.getName());
                    System.out.println("Price: "+items.getPrice());
                    System.out.println("Stock: "+items.getStockLevel());
                } 
            break;
            //buy stock    
            case 2: 
                //choose product
                System.out.println("\nChoose product:");
                for(int i=0;i<5;i++){
                    System.out.println((i+1)+"."+item[i].getName());
                }
                int prod = sc.nextInt();
                //update the stock level of a product
                do{
                    System.out.println("\nPhone: "+item[prod-1].getName());
                    System.out.println("Stock: "+item[prod-1].getStockLevel());
                    System.out.println("Number of items bought?");
                    int itemsBought = sc.nextInt();
                    System.out.println("\nStock level: "+item[prod-1].buyStock(itemsBought));
                    //choose product again or exit
                    System.out.println("\nChoose product:");
                    for(int i=0;i<5;i++){
                        System.out.println((i+1)+"."+item[i].getName());
                    }
                    System.out.println("6.Exit");
                    prod = sc.nextInt();
                }while(prod <= 5);
            break;
            //sell stock
            case 3:
                //choose product
                System.out.println("\nChoose product:");
                for(int i=0;i<5;i++){
                    System.out.println((i+1)+"."+item[i].getName());
                }
                int prodSold = sc.nextInt();
                //return true if the operation is successful
                do{
                    System.out.println("\nPhone: "+item[prodSold-1].getName());
                    System.out.println("Stock: "+item[prodSold-1].getStockLevel());
                    int stckLevel = item[prodSold-1].getStockLevel();
                    System.out.println("Number of items sold?");
                    int itemSold = sc.nextInt();
                    //if there is enough stock
                    if(itemSold <= stckLevel){
                        item[prodSold-1].sell(itemSold);
                        System.out.println("\nStock level: "+item[prodSold-1].getStockLevel());
                        System.out.println("Successful!");
                        //choose product again or exit
                        System.out.println("\nChoose product:");
                        for(int i=0;i<5;i++){
                            System.out.println((i+1)+"."+item[i].getName());
                        }
                        System.out.println("6.Exit");
                        prodSold = sc.nextInt();
                    }else{
                        //if there is not enough stock
                        System.out.println("Unsucessful!");
                        System.out.println("There is not enough stock.");
                        //check product again or exit
                        System.out.println("\nChoose product:");
                        for(int i=0;i<5;i++){
                            System.out.println((i+1)+"."+item[i].getName());
                        }
                        System.out.println("6.Exit");
                        prodSold = sc.nextInt();
                    }
                }while(prodSold <= 5);
            break;
            //re-price a product
            case 4:
                //choose product
                System.out.println("\nChoose product:");
                for(int i=0;i<5;i++){
                    System.out.println((i+1)+"."+item[i].getName());
                }
                int prodPrice = sc.nextInt();
                do{
                    System.out.println("\nPhone: "+item[prodPrice-1].getName());
                    System.out.println("Price: "+item[prodPrice-1].getPrice());
                    //set new price
                    System.out.println("Set new price:");
                    double prodNewPrice = sc.nextDouble();
                    item[prodPrice-1].setPrice(prodNewPrice);
                    //show new price
                    System.out.println("\nPhone: "+item[prodPrice-1].getName());
                    System.out.println("Price: "+item[prodPrice-1].getPrice());
                    //choose product again or exit
                    System.out.println("\nChoose product:");
                    for(int i=0;i<5;i++){
                        System.out.println((i+1)+"."+item[i].getName());
                    }
                    System.out.println("6.Exit");
                    prodPrice = sc.nextInt();
                }while(prodPrice <= 5);
            break;
            //display total value of the stock
            case 5:
                double totalValue = 0;
                System.out.println("\nTotal value of all stock:");
                for(int i=0;i<5;i++){
                    totalValue = totalValue + (item[i].getPrice() * item[i].getStockLevel());
                }
                System.out.println(totalValue);
            break;    
            }
        }while(num != 6);
        //exit the program
        System.exit(0);
    }
}
