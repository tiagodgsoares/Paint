public class Game {

    private PainterController controller;
    private Grid grid;

    public void init() {
        controller = new PainterController();
        grid = new Grid();
        controller.setGrid(grid);
        grid.setPainterController(controller);
    }

}
