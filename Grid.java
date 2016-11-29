import java.util.Random;

/**
 * Models a minesweeper grid.
 *
 * @author Prathyusha
 */

public class Grid {
    private String[][] _grid;
    private int _length;
    private int _numMines;
    private String MINE = "*";
    private String SAFE = "0";

    public Grid(int length, int numMines) {
        _grid = new String[length][length];
        _length = length;
        _numMines = numMines;

        initializeboard();
        setMines();
    }

    public void initializeboard() {
        for (int r = 0; r < _length; r++) {
            for (int c = 0; c < _length; c++) {
                _grid[r][c] = SAFE;
            }
        }
    }

    private void setMines() {
        Random gen = new Random();
        for (int i = 0; i < _numMines; i++) {
            int length = gen.nextInt(_length);
            int width = gen.nextInt(_length);
            _grid[length][width] = MINE;
        }
    }

    public String[][] getGrid() {
        return _grid;
    }

    public String getSquare(int r, int c) {
        return _grid[r][c];
    }

    public boolean isMine(int r, int c) {
        return _grid.equals(MINE);
    }
}
