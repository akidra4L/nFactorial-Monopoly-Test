package MonopolyGame;

public class CornerSquare extends BoardLocation {
	private String name;

	public CornerSquare() {
		this(0, "Start");
	}
	public CornerSquare(int position, String name) {
		super(position, true);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return super.toString() + this.name;
	}
}
