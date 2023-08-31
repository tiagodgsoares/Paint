import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PainterController implements KeyboardHandler {

    private Painter painter;
    private Keyboard keyboard;
    private Grid grid;

    public PainterController() {
        keyboard = new Keyboard(this);
        buildKeyboard();
        painter = new Painter();
        painter.setColor(Color.BLUE);
        painter.fill();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getX(){
        return painter.getX();
    }

    public int getY() {
        return painter.getY();
    }

    public void buildKeyboard() {
        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent draw = new KeyboardEvent();
        draw.setKey(KeyboardEvent.KEY_D);
        draw.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(draw);

        KeyboardEvent erase = new KeyboardEvent();
        erase.setKey(KeyboardEvent.KEY_E);
        erase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(erase);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);
    }

    public void moveUp() {
        painter.translate(0, -Constants.CELL_SIZE);
    }
    public void moveDown() {
        painter.translate(0, Constants.CELL_SIZE);
    }
    public void moveRight() {
        painter.translate(Constants.CELL_SIZE, 0);
    }
    public void moveLeft() {
        painter.translate(-Constants.CELL_SIZE, 0);
    }
    public CellDraw draw() {
        CellDraw cellDraw = new CellDraw(painter.getX(), painter.getY());
        grid.saveCellDraw(cellDraw);
        return cellDraw;
    }
    public void erase() {
        if(grid.searchDraw() != null) {
            grid.searchDraw().delete();
        }
    }

    public void save() {
        grid.saveAllCells();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        if(keyPressed == KeyboardEvent.KEY_UP) {
            if(painter.getY() > Constants.PADDING) {
                moveUp();
            }
        }
        if(keyPressed == KeyboardEvent.KEY_DOWN) {
            if(painter.getY() < Constants.GRID_HEIGHT) {
                moveDown();
            }
        }
        if(keyPressed == KeyboardEvent.KEY_RIGHT) {
            if(painter.getX() < Constants.GRID_WIDTH) {
                moveRight();
            }
        }
        if(keyPressed == KeyboardEvent.KEY_LEFT) {
            if(painter.getX() > Constants.PADDING) {
                moveLeft();
            }
        }
        if(keyPressed == KeyboardEvent.KEY_D) {
            draw();
        }
        if(keyPressed == KeyboardEvent.KEY_E) {
            erase();
        }
        if(keyPressed == KeyboardEvent.KEY_S) {
            save();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
