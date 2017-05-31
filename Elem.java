public class Elem {
	private int X;
	private int Y;
	private Elem prev;
	public Elem(int myX, int myY, Elem myPrev) {
		X = myX;
		Y = myY;
		prev = myPrev;
	}	
	public int getX(){
		return (X);
	}
	public int getY(){
		return (Y);
	}
	public void setPrev(Elem p) {
		prev = p;
	}
	public Elem getPrev() {
		return (prev);
	}
}
	
	