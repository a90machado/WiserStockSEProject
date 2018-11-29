package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;

import io.altar.jseproject.services.ShelfService;

public class SecondLevelProductCreate implements State {

	@Override
	public int execute() {
		// Show Menu:
		showMenu();
		
		return 0;
	}
	
	private void showMenu(){
		int discount, iva;
		int [] rangeIvas = {6,12,23};
		double pvp;
		ArrayList<Long> shelfsIDs;
		
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--               Create a new Product               --");
		SCANNER_UTILS.checkGetIntFromScanner("Input discount (%) : ");
		SCANNER_UTILS.checkGetIntFromScannerWithRange("Input IVA (6% , 12% and 23%) : ", rangeIvas);
		SCANNER_UTILS.checkGetDoubleFromScanner("Input price ($) : ");
		if (!ShelfService.isEmpty() && ShelfService.getAllShelfsIDsWithoutProduct().hasNext()){
			
			
			SCANNER_UTILS.checkGetIntFromScannerWithRange(message, rangeValidValues, true);
		}
	
		
	}

}
