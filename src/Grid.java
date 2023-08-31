import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Grid {
    private PainterController painterController;
    public static ArrayList<CellDraw> cellDraws = new ArrayList<>();

    public void setPainterController(PainterController painterController) {
        this.painterController = painterController;
    }

    public Grid() {

        int x = Constants.PADDING;
        int y = Constants.PADDING - Constants.CELL_SIZE;

        while (y < Constants.GRID_HEIGHT) {
            y += Constants.CELL_SIZE;
            Rectangle rectangleH = new Rectangle(Constants.PADDING, y, Constants.GRID_WIDTH + Constants.CELL_SIZE,Constants.CELL_SIZE);
            rectangleH.setColor(Color.BLACK);
            rectangleH.draw();
        }

        while (x < Constants.GRID_WIDTH) {
            x += Constants.CELL_SIZE;
            Rectangle rectangleV = new Rectangle(x, Constants.PADDING,Constants.CELL_SIZE, Constants.GRID_HEIGHT + Constants.CELL_SIZE);
            rectangleV.setColor(Color.BLACK);
            rectangleV.draw();
        }
    }

    public void saveCellDraw(CellDraw cellDraw){
        cellDraws.add(cellDraw);
    }

    public CellDraw searchDraw() {
        for (CellDraw draw : cellDraws) {
            if (draw.getX() == painterController.getX() && draw.getY() == painterController.getY()) {
                return draw;
            }
        }
        return null;
    }

    public void saveAllCells() {
        try {
            FileWriter fileWriter = new FileWriter("src/cellsPainted.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (CellDraw cellDraw : cellDraws) {
                writer.write(String.valueOf(cellDraw));
            }

            writer.close();

        } catch (IOException ex) {
            System.out.println("Error saving cells: " + ex.getMessage());
        }
    }

}
