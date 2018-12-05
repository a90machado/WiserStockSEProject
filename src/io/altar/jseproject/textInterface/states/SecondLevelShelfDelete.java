package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;

import io.altar.jseproject.services.ShelfService;


public class SecondLevelShelfDelete implements State {

	@Override
	public int execute() {
		
		if (!ShelfService.isEmpty()) {
			showMenu();
		}
		
		return 1;
	}
	
	private void showMenu() {
		ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ShelfService.getAllShelfsIDs());
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--                 Delete a Product                 --\n");
		System.out.println(rangeIDsExist.toString());
		Long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Select an ID to delete: ", rangeIDsExist, true);
		
		if (id != -1) {
			System.out.println(ShelfService.getShelfById(id).toString());
			String confirmDelete = SCANNER_UTILS.checkGetYesOrNoAnswer("Are you sure that you want to delete this Product? (Y/n) :");
			
			if (confirmDelete.equals("Y")) {
				ShelfService.removeShelf(id);
			}
			
		}
		
	}

}
