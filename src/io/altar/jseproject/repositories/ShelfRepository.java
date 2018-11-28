package io.altar.jseproject.repositories;

import java.util.Iterator;

//Import:
import io.altar.jseproject.model.Shelf;

//Class Shelf Repository that Extends to DataBase - Singleton
public class ShelfRepository extends EntityRepository<Shelf> {

	// Instance:
	private final static ShelfRepository INSTANCE = new ShelfRepository();
	
	// Constructor:
	private ShelfRepository(){	
	}
	
	// Get:
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}
	
	// Get ID's without Product
	public Iterator<Long> getIDsWithoutProduct(){
		Iterator <Shelf> allShelfs = INSTANCE.getAll();
		
		while(allShelfs.hasNext()){
			
		}
		return 
	}
}
