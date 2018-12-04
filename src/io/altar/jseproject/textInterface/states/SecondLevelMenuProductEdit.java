package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class SecondLevelMenuProductEdit implements State {

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
			ArrayList<Long> rangeIDsShelfsWithoutProduct = new ArrayList<Long>(
					ShelfService.getAllShelfsIDsWithoutProduct());

			discount = SCANNER_UTILS.checkGetIntFromScannerWithMax(
					"Input discount (%) (" + editProduct.getDiscountPrice() + ") " + " : ", 100, true);
			iva = SCANNER_UTILS.checkGetIntFromScannerWithRange(
					"Input IVA (6% , 12% and 23%) (" + editProduct.getIva() + ") " + " : ", rangeIvas, true);
			pvp = SCANNER_UTILS.checkGetDoubleFromScanner("Input price ($) (" + editProduct.getPvp() + ") " + " : ",
					true);

			if (!ShelfService.getAllShelfsIDsWithoutProduct().isEmpty()) {

				shelfIDs = SCANNER_UTILS.checkTest("Input all Shelfs ID's or press Enter to delete ("
						+ editProduct.getListShelfs().toString() + ") :", rangeIDsShelfsWithoutProduct, true);
				if(shelfIDs == null) {
					shelfIDs = new ArrayList<Long>();
					editProduct.setListShelfs(shelfIDs);
				}
			}

			if (discount != -1) {
				editProduct.setDiscountPrice(discount);
			}
			if (iva != -1) {
				editProduct.setIva(iva);
			}
			if (pvp != -1) {
				editProduct.setPvp(pvp);
			}
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
