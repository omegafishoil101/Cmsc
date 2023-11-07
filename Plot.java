package property;

public class Plot extends Object {
	
	int x, y, depth, width;

	public Plot() {
		
	}

	public Plot(int x, int y, int depth, int width) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	public boolean overlaps(Plot plot) {
	int x2 = plot.getX();
	int y2 = plot.getY();
	int depth2 = plot.getDepth();
	int width2 = plot.getWidth();
	int posWidth2 = x2 + width2;
	int posWidth = x + width;
	int posLength2 = y2 + depth2;
	int posLength = y + depth;
	
	if ( (x > posWidth2 || posWidth < x2 )||( y > posLength2 || posLength < y2 )) {
		return false;
	} else {
		return true;
	}
	}
	
	public boolean encompasses(Plot plot) {
		int x2 = plot.getX();
		int y2 = plot.getY();
		int depth2 = plot.getDepth();
		int width2 = plot.getWidth();
		int posWidth2 = x2 + width2;
		int posWidth = x + width;
		int posLength2 = y2 + depth2;
		int posLength = y + depth;
		
		if((x <= x2 && posWidth >= posWidth2) && (y <= y2 && posLength >= posLength2)) {
			return true;
		} else {
			return false;
		}
		
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
@Override
	public String toString() {
		return x + "," + y + "," + depth + "," + width;
	}
}