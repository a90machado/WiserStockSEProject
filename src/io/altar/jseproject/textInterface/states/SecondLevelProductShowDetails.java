package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;

import io.altar.jseproject.services.ProductService;

public class SecondLevelProductShowDetails implements State {

	@Override
	public int execute() {
		
		if (!ProductService.isEmpty()) { showMenu(); }
		
		return 1;
	}

	private void showMenu() {
		ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ProductService.getAllProductsIDs());
		
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--             See details of a Product             --");
		
		Long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Select an ID to show: ", rangeIDsExist, true);
		
		if (id != -1) {
			System.out.println(ProductService.getProductById(id).toString());
			SCANNER_UTILS.checkInputToContinueFromScanner("Press Enter to Continue");
		}
	}
}
