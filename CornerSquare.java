package MonopolyGame;

public class CornerSquare extends BoardLocation {
	private String name;

	public CornerSquare() {
		this(null, 0, "Start", Color.WHITE);
	}
	public CornerSquare(Player owner, int position, String name, Color color) {
		super(owner, position, true, color);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return super.toString() + " " + this.name;
	}
}
