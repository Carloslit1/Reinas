/**
 * Resuelve la determinaciíon para la reina en la fila que se le esta inidicando
 * @param row
 */
public class NQueens {
    static int N = 8;
    static int[] board = new int[8];
    static int tablero = 1;


    static void printBoard() {
        System.out.println("Tablero " + tablero);
        tablero++;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void solve(int row){

        if (row == N) {
            printBoard();
            return;
        }
        for (int col = 0; col < N; col++) {   
            if (isSafe(row, col)) {
                board[row] = col;
                solve(row + 1);
            } 
        }
    }

/**Verifica si no colisiona con otra reina
 * @param row fila
 * @param col columna
 * return true si es seguro, false si no lo es
 */
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == (row - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solve(0);
    }
}