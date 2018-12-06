package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class SecondLevelShelfEdit implements State {
	private int capacity;
	private long idProduct;
	private double price;
	private Product product = null;

	@Override
	public int execute() {

		if (!ShelfService.isEmpty()) {

			showShelfsInDB();

			showMenu();
		}

		return 1;
	}

	private void showMenu() {
		ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ShelfService.getAllShelfsIDs());
		

		System.out.println("--------------WISER STOCK: Shelfs Menu--------------");
		System.out.println("--                  Edit a Shelf                  --");

		long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Input Shelf ID (press Enter to exit): ",
				rangeIDsExist, true);
		
		if (id!=-1) {
			
			Shelf editShelf = ShelfService.getShelfById(id);
			getInputs(editShelf);
			ShelfService.updateByID(editShelf, capacity, price, ProductService.getProductById(idProduct));
			
		}

	}
	
	
	private void getInputs(Shelf editShelf) {
				
		capacity = SCANNER_UTILS.checkGetIntFromScanner(
				"Input Capacity (" + editShelf.getCapacity() + ") " + " : ", true);

		price = SCANNER_UTILS.checkGetDoubleFromScanner(
				"Input Price for Rent (" + editShelf.getPrice() + ") " + " : ", true);
		
		if(!ProductService.isEmpty()) {
			
			ArrayList<Long> rangeIDsExistOnProducts = new ArrayList<Long>(ProductService.getAllProductsIDs());
			System.out.println(rangeIDsExistOnProducts);
			
			if (editShelf.getProduct()==null) {
				idProduct = SCANNER_UTILS.checkGetLongFromScanner(
						"Input Product ID (Without Product) " + " : ", true);
			} else {
				idProduct = SCANNER_UTILS.checkGetLongFromScanner(
						"Input Product ID (" + editShelf.getProduct().toString() + ") " + " : ", true);
			}
			
			if (idProduct==-1 && editShelf.getProduct()!=null) {
				editShelf.getProduct().removeFromListShelfs(editShelf.getId());
			} else {
				ProductService.getProductById(idProduct).addToListShelfs(editShelf.getId());
			}
		}
		ShelfService.updateByID(editShelf, capacity, price, product);

	}

	private void showShelfsInDB() {
		// Initializing:
		Iterator<Long> productIDsIterator = ShelfService.getAllShelfsIDs().iterator();
		// Show all Products:
		System.out.println("--------------See all Shelfs--------------");
		long id;
		while (productIDsIterator.hasNext()) {
			id = productIDsIterator.next();
			System.out.print(id + " ");
		}
		System.out.println("--------------------------------------------");
	}

}
