package io.altar.jseproject.textInterface.states;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.lang.model.element.Element;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class SecondLevelProductCreate implements State {
	
	// Attributes:
	int discount, iva;
	double pvp;
	
	
	@Override
	public int execute() {
		// Show Menu:
		showMenu();
		
		return 1;
	}
	
	private void showMenu(){
		int [] rangeIvas = {6,12,23};
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--               Create a new Product               --");
		
		discount = SCANNER_UTILS.checkGetIntFromScannerWithMax("Input discount (%) : ", 100);
		iva = SCANNER_UTILS.checkGetIntFromScannerWithRange("Input IVA (6% , 12% and 23%) : ", rangeIvas);
		pvp = SCANNER_UTILS.checkGetDoubleFromScanner("Input price ($) : ");
		
		if (!ShelfService.getAllShelfsIDsWithoutProduct().isEmpty()){
			// ask if want to add product to a shelf
			String answer = SCANNER_UTILS.checkGetYesOrNoAnswer("Do you want to add this product to a Shelf? (Y/n)");
			if (answer.equals('Y')) {
				addToShelf();	
			} else { ProductService.createProduct(discount, iva, pvp); }
		} else { ProductService.createProduct(discount, iva, pvp); }
	}
	
	private void addToShelf(){
		ArrayList<Long> rangeShelfsIDs = ShelfService.getAllShelfsIDsWithoutProduct();
		ArrayList<Long> shelfsToProduct = new ArrayList<Long>();
		long id;
		do{
			id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Input Shelf ID (press Enter to exit): ", rangeShelfsIDs, true);
			ShelfService.addProductToShelf(ShelfService.getShelfById(id),);
			rangeShelfsIDs.remove(rangeShelfsIDs.indexOf(id));
			shelfsToProduct.add(id);
		}while (id != -1 && !rangeShelfsIDs.isEmpty());
		ProductService.createProduct(shelfsToProduct, discount, iva, pvp);
	}
	
}
