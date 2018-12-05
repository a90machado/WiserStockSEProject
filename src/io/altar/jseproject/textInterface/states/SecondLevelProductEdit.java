package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class SecondLevelProductEdit implements State {

	// Attributes:
	private int discount, iva;
	private double pvp;
	private ArrayList<Long> shelfIDs;

	@Override
	public int execute() {

		if (!ProductService.isEmpty()) {
			// Show all exist Products ID's
			showProductsInDB();

			// Show Menu
			showMenu();
		}

		return 1;
	}

	private void showMenu() {
		// TODO: Range - get ID's without product + ID of the product assigned
		ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ProductService.getAllProductsIDs());
		int[] rangeIvas = { 6, 12, 23 };

		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--                  Edit a Product                  --");

		long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Input Shelf ID (press Enter to exit): ",
				rangeIDsExist, true);
		if (id != -1) {
			Product editProduct = ProductService.getProductById(id);
			discount = SCANNER_UTILS.checkGetIntFromScannerWithMax(
					"Input discount (%) (" + editProduct.getDiscountPrice() + ") " + " : ", 100, true);
			iva = SCANNER_UTILS.checkGetIntFromScannerWithRange(
					"Input IVA (6% , 12% and 23%) (" + editProduct.getIva() + ") " + " : ", rangeIvas, true);
			pvp = SCANNER_UTILS.checkGetDoubleFromScanner("Input price ($) (" + editProduct.getPvp() + ") " + " : ",
					true);
			if (!ShelfService.getAllShelfsIDsWithoutProduct().isEmpty()) {
				ArrayList<Long> rangeIDsShelfsWithoutProduct = getRangeForShelfEdit(id);
				System.out.println(rangeIDsShelfsWithoutProduct);
				shelfIDs = SCANNER_UTILS.checkTest("Input all Shelfs ID's or press Enter to delete ("
						+ editProduct.getListShelfs().toString() + ") :", rangeIDsShelfsWithoutProduct, true);		
			}
			ProductService.updateByID(editProduct, discount, iva, pvp, shelfIDs);
		}
	}
	
	public ArrayList<Long> getRangeForShelfEdit(long id){
		ArrayList<Long> normalRange = new ArrayList<Long> (ShelfService.getAllShelfsIDsWithoutProduct());
		ArrayList<Long> productShelfs = new ArrayList<Long>(ProductService.getProductById(id).getListShelfs());
		
		if (productShelfs.isEmpty()) {
			return normalRange;
		}else {
			for (int i = 0; i < productShelfs.size(); i++) {
				normalRange.add(productShelfs.get(i));
			}
			return normalRange;
		}
	}

	private void showProductsInDB() {
		// Initializing:
		Iterator<Long> productIDsIterator = ProductService.getAllProductsIDs().iterator();
		// Show all Products:
		System.out.println("--------------See all Products--------------");
		long id;
		while (productIDsIterator.hasNext()) {
			id = productIDsIterator.next();
			System.out.print(id + " ");
		}
		System.out.println("--------------------------------------------");
	}

}
