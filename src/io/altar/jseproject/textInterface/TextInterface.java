package io.altar.jseproject.textInterface;

import io.altar.jseproject.textInterface.states.*;


public class TextInterface {

	// Attributes:
	private State[] states = {new FirstLevelMenu(), 
							  new FirstLevelMenuProducts(),	 
							  new FirstLevelMenuShelfs(),
							  new SecondLevelProductCreate(),
							  new SecondLevelMenuProductEdit(),
							  new SecondLevelProductShowDetails(),
							  new SecondLevelProductDelete(),
							  new SecondLevelShelfCreate(),};
	
	private int transitionsStates [][] = {{1,2},      	// Main Menu  
										  {3,4,5,6,0},	// Product Menu
										  {7,8,9,10,0},	// Shelf Menu
										  {1},	// Product Create Menu
										  {1},	// Product Edit Menu
										  {1},	// Product Details Menu
										  {1},	// Product Delete Menu
										  {3}	// Shelf Create Menu
										 };
	private int currentState = 0;
	
	// Getters and Setters:
	public State[] getStates() {
		return states;
	}
	
	public int[][] getTransitionsStates() {
		return transitionsStates;
	}
	
	public int getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	
	
	
}
