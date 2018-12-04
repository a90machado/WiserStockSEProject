package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;

import io.altar.jseproject.services.ProductService;

public class SecondLevelProductDelete implements State {

	@Override
	public int execute() {
		
		if (!ProductService.isEmpty()) {
			showMenu();
		}
		
		return 1;
	}
	
	private void showMenu() {
		ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ProductService.getAllProductsIDs());
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--                 Delete a Product                 --\n");
		System.out.println(rangeIDsExist.toString());
		Long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Select an ID to delete: ", rangeIDsExist, true);
		
		if (id != -1) {
			System.out.println(ProductService.getProductById(id).toString());
			String confirmDelete = SCANNER_UTILS.checkGetYesOrNoAnswer("Are you sure that you want to delete this Product? (Y/n) :");
			
			if (confirmDelete.equals("Y")) {
				ProductService.removeProduct(id);
			}
			
		}
		
	}
}
