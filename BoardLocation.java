package MonopolyGame;

public abstract class BoardLocation {
	private static final int maxSpaces = 8;
	private int position;
	private Player owner;
	private boolean isAvailable;
	private Color color;
	
	public BoardLocation() {
		this(null, 0, true, Color.BLUE);
	}
	public BoardLocation(Player owner, int position, boolean isAvailable, Color color) {
		this.owner = owner;
		this.position = position;
		this.isAvailable = isAvailable;
		this.color = color;
	}
	
	public abstract String getName();
	
	public Player getOwner() {
		return this.owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return this.position + " " + this.owner;
	}
}
