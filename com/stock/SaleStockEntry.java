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
			System.out.println("5. Click to exit");
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
							arrList.add(new ProductEntry(productId,productname,quantity,price1));
						}
					}
					break;
				case 2:
					System.out.println("Total price of your products is/are: Rs."+totalPrice+" till now");
					
					break;
				case 3:
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("ID             Name             Quantity                    0Price");
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
				case 5: 
					System.exit(0);
					System.out.println("Thank you for the shopping!");
			}
		}while(option<6);
	}


	private static int search(int productId) {
		int flag=0;
		int id;
		for(int i=0;i<list.size();i++){
			if(list.indexOf(productId)!=-1){
				continue;
			}else{
				flag=1;
				id=productId;
				return id;
			}
		}
		return -1;
	}

}











