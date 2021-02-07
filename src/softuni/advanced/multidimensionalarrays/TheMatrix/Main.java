package softuni.advanced.multidimensionalarrays.TheMatrix;

/**Description:
 * We are given a matrix (2D array) and we have to write a program, which, starting from
 * the symbol at startRow and startCol, changes to fillChar every symbol in the matrix which:
 * is equal to startChar AND can be reached from startChar by going up (row – 1), down (row + 1), left (col – 1)
 * and right (col + 1) and “stepping” ONLY on symbols equal startChar
 * So, we basically start from startRow and startCol and can move either by changing the row OR column
 * (not both at once, i.e. you can’t go diagonally) by 1, and can only go to positions which have the startChar written
 * on them. Once we find all those positions, we change them to fillChar. In other words, you need to implement something
 * like the Fill tool in MS Paint, but for a 2D char array instead of a bitmap.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        Matrix matrix = new Matrix(rows, cols);
        matrix.setMatrix(readMatrixInfo(scan, rows));

        char fillColor = scan.nextLine().charAt(0);
        int row = scan.nextInt();
        int col = scan.nextInt();

        Strategy strategy = new DFSSTack();

        Bucket bucket = new Bucket(row, col, matrix);
        bucket.paint(fillColor, strategy);
        System.out.println(matrix.toString());
    }

    public static List<String> readMatrixInfo(Scanner scanner, int linesCount) {
        List<String> lines = new ArrayList<>();
        while (linesCount-- > 0) {
            lines.add(scanner.nextLine()
                    .replaceAll("\\s+", ""));
        }

        return lines;

    }
}
