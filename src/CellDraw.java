import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CellDraw extends Rectangle {
    public CellDraw(int x, int y) {
        super(x, y, Constants.CELL_SIZE, Constants.CELL_SIZE);
        this.setColor(Color.BLACK);
        this.fill();
    }

    @Override
    public String toString() {
        return "x: " + getX() +", y: " + getY() + "; \n";
    }
}