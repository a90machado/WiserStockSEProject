package io.altar.jseproject.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductService {
	
	// Initializing;
	private static final ProductRepository PRODUCT_REPOSITORY = ProductRepository.getInstance();
	
	// Create a product
	public static void createProduct (int discount, int iva, double pvp){
		Product newProduct = new Product(discount, iva, pvp);
		PRODUCT_REPOSITORY.save(newProduct);
	}
	
	public static void createProduct (ArrayList<Long> shelfsIDs, int discount, int iva, double pvp){
		Product newProduct = new Product(shelfsIDs, discount, iva, pvp);
		PRODUCT_REPOSITORY.save(newProduct);
	}
	
	// Get size of Data
	public static int getSizeOfData(){
		return PRODUCT_REPOSITORY.lenghtData();				
	}
	
	// Get actual product ID
	public static long getActualID(){
		return PRODUCT_REPOSITORY.getActualID();
	}
		
	// Get next product ID
	public static long getNextID(){
		return PRODUCT_REPOSITORY.nextID();
	}
	
	// Get Product by ID
	public static Product getProductById (long id){
		Product searchProduct = PRODUCT_REPOSITORY.findByID(id);
		return searchProduct;
	}
	
	// Get All Products
	public static Collection<Product> getAllProducts(){
		return PRODUCT_REPOSITORY.getAll();
	}
	
	// Get All Product ID's
	public static Collection<Long> getAllProductsIDs(){
		return PRODUCT_REPOSITORY.getAllIDs();
	}
	
	// Update by ID
	public static void updateByID (Product editProduct,int discount,int iva,double pvp, ArrayList<Long> shelfsToSave) {
		
		editProduct.setListShelfs(shelfsToSave);
		
		if (discount != -1) {
			editProduct.setDiscountPrice(discount);
		}
		if (iva != -1) {
			editProduct.setIva(iva);
		}
		if (pvp != -1) {
			editProduct.setPvp(pvp);
		}
		
		PRODUCT_REPOSITORY.updateByID(editProduct);
	}
	
	// Remove Product
	public static void removeProduct (long idToRemove){
		PRODUCT_REPOSITORY.removeByID(idToRemove);
	}
	
	// Check Repository is Empty
	public static boolean isEmpty(){
		return PRODUCT_REPOSITORY.isEmpty();
	}
	
	public static void addShelf(long idProduct, long idShelf) {
		PRODUCT_REPOSITORY.findByID(idProduct).getListShelfs().add(idShelf);
	}

}
