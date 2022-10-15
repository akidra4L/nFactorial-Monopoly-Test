package MonopolyGame;

public abstract class BoardLocation {
	private static final int maxSpaces = 8;
	private int position;
	private boolean isAvailable;
	
	public BoardLocation() {
		this(0, true);
	}
	public BoardLocation(int position, boolean isAvailable) {
		this.position = position;
		this.isAvailable = isAvailable;
	}
	
	public abstract String getName();
	
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public String toString() {
		return this.position + " ";
	}
}
