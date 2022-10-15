package MonopolyGame;

import java.util.*;

public class Player {
	private String name;
	private double money;
	private boolean bankrupt;
	private int position;
	private Vector <Integer> owned;
	
	public Player(String name, int position) {
		this.name = name;
		this.money = 2000000;
		this.bankrupt = false;
		this.position = position;
	}
	
	public void buyOrNot(String command, BoardLocation bl) {
		if(command.equals("buy")) {
			owned.add(bl.getPosition());
		}
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMoney() {
		return this.money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public boolean getBankrupt() {
		return this.bankrupt;
	}
	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}
	
	public int getPosition() {
		return this.position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String toString() {
		return this.name + " " + this.money + " " + this.bankrupt + " " + this.position;
	}
}
