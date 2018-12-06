package io.altar.jseproject.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfService {

	// Initializing;
	private static final ShelfRepository SHELF_REPOSITORY = ShelfRepository.getInstance();

	// Create Shelf
	public static void createShelf(int capacity, double price) {
		Shelf newShelf = new Shelf(capacity, price);
		SHELF_REPOSITORY.save(newShelf);
	}

	public static void createShelf(Long productIDs, int capacity, double price) {
		Shelf newShelf = new Shelf(productIDs, capacity, price);
		SHELF_REPOSITORY.save(newShelf);
	}

	// Get size of Data
	public static int getSizeOfData() {
		return SHELF_REPOSITORY.lenghtData();
	}

	// Get Shelf by ID
	public static Shelf getShelfById(Long id) {
		Shelf searchShelf = SHELF_REPOSITORY.findByID(id);
		return searchShelf;
	}

	// Get actual shelf ID
	public static long getActualID() {
		return SHELF_REPOSITORY.getActualID();
	}

	// Edit Shelf
	public static void editShelf(Shelf editShelf) {
		SHELF_REPOSITORY.save(editShelf);
	}

	// Check if Shelf Repository is empty
	public static boolean isEmpty() {
		return SHELF_REPOSITORY.isEmpty();
	}

	// Get all Shelfs
	public static Collection<Shelf> getAllShelfs() {
		return SHELF_REPOSITORY.getAll();
	}

	// Get all Shelfs ID's
	public static Collection<Long> getAllShelfsIDs() {
		return SHELF_REPOSITORY.getAllIDs();
	}

	// Get all Shelfs ID's without products
	public static Collection<Long> getAllShelfsIDsWithoutProduct() {
		return SHELF_REPOSITORY.getIDsWithoutProduct();
	}

	// Remove Shelf
	public static void removeShelf(long id) {
		SHELF_REPOSITORY.removeByID(id);
	}

	//
	public static void addShelf(ArrayList<Long> shelfsIDs, Product productToInsert) {
		Iterator<Long> insertProductOnShelfs = shelfsIDs.iterator();
		while (insertProductOnShelfs.hasNext()) {
			long id = insertProductOnShelfs.next();
			SHELF_REPOSITORY.findByID(id).setProduct(productToInsert);
		}
	}

	//
	public static void addProductToShelf(long shelfID, long productID) {
		Product productToAdd = ProductService.getProductById(productID);
		SHELF_REPOSITORY.findByID(shelfID).setProduct(productToAdd);
		;

	}

	// Update by ID
	public static void updateByID(Shelf editShelf, int capacity, double price, Product product) {
		
		if (capacity!=-1) {
			editShelf.setCapacity(capacity);
		}
		if (price!=-1) {
			editShelf.setPrice(price);
		}
		if (product!=null) {
			editShelf.setProduct(product);
		}
		SHELF_REPOSITORY.updateByID(editShelf);
	}

}
