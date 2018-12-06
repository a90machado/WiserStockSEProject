package io.altar.jseproject.model;

//Imports:
import java.util.ArrayList;

//Class Model Product
public class Product extends Entity {

	// Fields:
	private ArrayList<Long> listShelfs;
	private int discountPrice;
	private int iva;
	private double pvp;

	// Constructor:
	public Product(int discountPrice, int iva, double pvp) {
		this.listShelfs = new ArrayList<Long>();
		this.discountPrice = discountPrice;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	public Product(ArrayList<Long> listShelfs, int discountPrice, int iva, double pvp) {
		this.listShelfs = listShelfs;
		this.discountPrice = discountPrice;
		this.iva = iva;
		this.pvp = pvp;
	}

	// Getters and Setters:
	public ArrayList<Long> getListShelfs() {
		return listShelfs;
	}

	public void setListShelfs(ArrayList<Long> listShelfs) {
		this.listShelfs = listShelfs;
	}
	//-------------------------------------------------------
	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	//-------------------------------------------------------
	public double getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}
	//-------------------------------------------------------
	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	//-------------------------------------------------------
	
	// Add new ID Shelf to ListShelfs:
	public void addToListShelfs(Long e){
		this.listShelfs.add(e);
	}
	
	public void removeFromListShelfs(long idShelf) {
		for (int i = 0; i < listShelfs.size(); i++) {
			if (listShelfs.equals(idShelf)) { this.listShelfs.remove(i); }
		}
		
	}
	
	// Override method toString:
	@Override
	public String toString() {
		if (this.getListShelfs()==null){
			return "Product " + this.getId() + " [discountPrice = " + discountPrice + "$, IVA=" + iva + "%, PVP=" + pvp +"$ " + "]";
		}else{
			return "Product " + this.getId() + " [discountPrice =" + discountPrice + "$, IVA =" + iva + "%, PVP =" + pvp +"$ "+ getListShelfs().toString() + "]";
		}
	}

}