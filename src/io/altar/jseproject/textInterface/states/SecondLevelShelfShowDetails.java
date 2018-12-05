package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;
import io.altar.jseproject.services.ShelfService;

public class SecondLevelShelfShowDetails implements State {
	
	@Override
	public int execute() {
		
		if (!ShelfService.isEmpty()) { showMenu(); }
		
		return 2;
	}

	private void showMenu() {
		ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ShelfService.getAllShelfsIDs());
		
		System.out.println("---------------WISER STOCK: Shelfs Menu---------------");
		System.out.println("--              See details of a Shelf              --");
		
		Long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Select an ID to show: ", rangeIDsExist, true);
		
		if (id != -1) {
			System.out.println(ShelfService.getShelfById(id).toString());
			SCANNER_UTILS.checkInputToContinueFromScanner("Press Enter to Continue");
		}
	}

}
