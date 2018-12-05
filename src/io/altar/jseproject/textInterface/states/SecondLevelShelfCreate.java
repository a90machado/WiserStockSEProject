package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;
import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class SecondLevelShelfCreate implements State {

	int capacity;
	double price;
	Long productID;
	
	
	@Override
	public int execute() {
		
		showMenu();
		
		
		return 1;
	}

	
	private void showMenu() {
		System.out.println("----------------WISER STOCK: Shelfs Menu--------------");
		System.out.println("--                Create a new Shelf                --");
		
		capacity = SCANNER_UTILS.checkGetIntFromScanner("Input capacity: ");
		price = SCANNER_UTILS.checkGetDoubleFromScanner("Input rent price: ($)");
		
		if(!ProductService.isEmpty()) {
			String answer = SCANNER_UTILS.checkGetYesOrNoAnswer("Do you want to add this product to a Shelf? (Y/n)");
			if(answer.equals("Y")) {
				ArrayList<Long> rangeIDs = new ArrayList<Long>(ProductService.getAllProductsIDs());
				System.out.println(rangeIDs);
				productID = SCANNER_UTILS.checkGetLongFromScannerWithRange("Insert the ID of the Product to add: ", rangeIDs, false);
				
				ShelfService.createShelf(productID, capacity, price);
				ProductService.addShelf(productID, ShelfService.getActualID()-1);
				
			} else { ShelfService.createShelf(capacity, price); }
			 
		} else { ShelfService.createShelf(capacity, price); }
	}
}
