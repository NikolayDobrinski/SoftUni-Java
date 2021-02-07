package softuni.advanced.multidimensionalarrays.TheMatrix;

public interface Strategy {
    void solve(int row, int col,
               char colorToReplace, char fillColor, Matrix matrix);
}
