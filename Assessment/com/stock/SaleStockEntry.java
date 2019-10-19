package com.stock;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleStockEntry {
	static Product p = null;
	
	static ArrayList<Product> list= new ArrayList<>();
	
	static ArrayList<ProductEntry> arrList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int productId;
		String productName;
		int quantity;
		int option;
		float totalPrice= 0;
		
		
		Scanner scanner= new Scanner(System.in);
		do{
			System.out.println("0. Click for entering the stock details");
			System.out.println("1. Click for entering the product");
			System.out.println("2. Click for total price");
			System.out.println("3. Click for print invoice");
			System.out.println("4. Click to view Stock");
			System.out.println("5. Click to update detail");
			System.out.println("6. Click to delete product");
			System.out.println("7. Click to exit");
			option= scanner.nextInt();
			
			switch(option){
			case 0:
				System.out.println("Enter ID");
				int id= scanner.nextInt();
				System.out.println("Enter Name of Product");
				String name= scanner.next();
				System.out.println("Enter price of product");
				float price= scanner.nextFloat();
				Product p= new Product(id, name, price);
				list.add(p);
				break;
				case 1: 
					System.out.println("Enter the product code");
					productId=scanner.nextInt();
					System.out.println("Enter the product quantity");
					quantity= scanner.nextInt();
					for(Product p3: list){
						if(p3.getProductId()==productId){
							String productname=p3.getProductName();
							float price1=p3.getPrice();
							totalPrice+=quantity*p3.getPrice();
							arrList.add(new ProductEntry(productId,productname,quantity,price1*quantity));
						}
					}
					break;
				case 2:
					System.out.println("Total price of your products is/are: Rs."+totalPrice+" till now");
					
					break;
				case 3:
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("ID             Name             Quantity                    Price");
					for(ProductEntry pEntry: arrList){
						System.out.println(pEntry.getProductId()+"            "+pEntry.getProductName()+"         "+pEntry.getQuantity()+"                  "+pEntry.getTotalPrice()+"");
					}
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("\nTotal payable amount: "+totalPrice);
					System.out.println("---------------------------------------------------------------------------");
					break;
				case 4:
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("ID----Name----Price");
					for(Product p1: list){
						System.out.println(p1.getProductId()+"----"+p1.getProductName()+"----"+p1.getPrice());
					}
					System.out.println("---------------------------------------------------------------------------");
					break;
				case 5:
					System.out.println("Enter the product Id");
					int idUpdated= scanner.nextInt();
					for(ProductEntry p5: arrList){
						if(p5.getProductId()==idUpdated){
							totalPrice=totalPrice-p5.getTotalPrice();
							arrList.remove(p5);
						}
					System.out.println("Enter the quantity");
					quantity= scanner.nextInt();
					for(Product p4: list){
						if(p4.getProductId()==idUpdated){
							String productname=p4.getProductName();
							float price1=p4.getPrice();
							totalPrice+=quantity*p4.getPrice();
							arrList.add(new ProductEntry(idUpdated,productname,quantity,quantity*price1));
						}
					}
					}
					break;
				case 6:
					System.out.println("Enter the product ID you want to delete");
					int deletedId=scanner.nextInt();
					for(ProductEntry p6: arrList){
						if(p6.getProductId()==deletedId){
							totalPrice-=p6.getTotalPrice();
							arrList.remove(p6);
							break;
						}
					}
					break;
				case 7: 
					
					System.out.println("Thank you for the shopping!");	
					System.exit(0);
			}
		}while(option!=-1);
	}
}











