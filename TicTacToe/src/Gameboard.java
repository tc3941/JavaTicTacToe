public class Gameboard {
    private char[][] matrix;
    private int turn;
    private final char FREE_SPOT = '-';
    public final char X = 'X';
    public final char O = 'O';
    public final char NO_WINNER = 'N';
    public final char CAT_GAME = 'C';

    public Gameboard() {
        matrix = new char[3][3];
        turn = 0;
        fillMatrix();
    }

    private void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = FREE_SPOT;
            }
        }
    }

    public boolean attemptMove(int r, int c) {
        if (validMove(r, c) && turn < 9) {
            playMove(r, c);
            turn++;
            return true;
        } else
            return false;


    }

    //returns N if no one has won yet
    public char checkForWinner() {
        char winner = NO_WINNER;
        char checkChar = ' ';
//int j = 0;
        for (int j = 0; j < matrix.length; j++) {
            checkChar = ' ';
            for (int i = 0; i < matrix.length; i++) {//check first row
                if (winner == NO_WINNER) {
                    if (checkChar == ' ') {
                        if (matrix[i][j] == FREE_SPOT) {
                            break;
                        }
                        checkChar = matrix[i][j];//X
                    } else if (checkChar == matrix[i][j] && i != matrix.length - 1) {
                        continue;
                    } else if (checkChar != matrix[i][j])
                        break;
                    else {
                        winner = checkChar;
                    }
                }
            }

            checkChar = ' ';
            for (int i = 0; i < matrix[0].length; i++) {//check first row
                if (winner == NO_WINNER) {
                    if (checkChar == ' ') {
                        if (matrix[j][i] == FREE_SPOT) {
                            break;
                        }
                        checkChar = matrix[j][i];//X
                    } else if (checkChar == matrix[j][i] && i != matrix[j].length - 1) {
                        continue;
                    } else if (checkChar != matrix[j][i])
                        break;
                    else
                        winner = checkChar;

                }
            }
        }
        checkChar = ' ';
        for (int j = 0; j < matrix.length; j++) {
            if (winner == NO_WINNER) {
                if (checkChar == ' ') {
                    if (matrix[j][j] == FREE_SPOT) {
                        break;
                    }
                    checkChar = matrix[j][j];//X
                } else if (checkChar == matrix[j][j] && j != matrix.length - 1) {
                    continue;
                } else if (checkChar != matrix[j][j])
                    break;
                else {
                    winner = checkChar;
                }
            }
        }
        checkChar = ' ';
        for (int j = 0; j < matrix.length; j++) {
            if (winner == NO_WINNER) {
                if (checkChar == ' ') {
                    if (matrix[(matrix.length - 1) - j][j] == FREE_SPOT) {//0 [2][0]
                        break;
                    }
                    checkChar = matrix[(matrix.length - 1) - j][j];//X
                } else if (checkChar == matrix[(matrix.length - 1) - j][j] && j != matrix.length - 1) {
                    continue;
                } else if (checkChar != matrix[(matrix.length - 1) - j][j])
                    break;
                else {
                    winner = checkChar;
                }
            }
        }

        return turn == 9 && winner == NO_WINNER ? CAT_GAME : winner;

    }

//    public char checkCatGame() {
//        char chr = checkForWinner();
//        return turn == 9 && chr == N ? Cat : chr;
//    }

    private void playMove(int r, int c) {
        char xo = getXO();
        matrix[r][c] = xo;
    }

    private char getXO() {
        return turn % 2 == 0 ? X : O;
    }

    public void turnPrompt() {
        System.out.print("'" + getXO() + "' choose your location (row , column):");
    }

    private boolean validMove(int r, int c) {
        return matrix[r][c] == FREE_SPOT;
    }

    public void printBoard() {
        System.out.println("     0 1 2 " + "\n" +
                "  0  " + matrix[0][0] + "|" + matrix[1][0] + "|" + matrix[2][0] + "\n" +
                "    --+-+--" + "\n" +
                "  1  " + matrix[0][1] + "|" + matrix[1][1] + "|" + matrix[2][1] + "\n" +
                "    --+-+--" + "\n" +
                "  2  " + matrix[0][2] + "|" + matrix[1][2] + "|" + matrix[2][2] + "\n"
        );
    }

    @Override
    public String toString() {
        return "     0 1 2 " + "\n" +
                "  0  " + matrix[0][0] + "|" + matrix[1][0] + "|" + matrix[2][0] + "\n" +
                "    --+-+--" + "\n" +
                "  1  " + matrix[0][1] + "|" + matrix[1][1] + "|" + matrix[2][1] + "\n" +
                "    --+-+--" + "\n" +
                "  2  " + matrix[0][2] + "|" + matrix[1][2] + "|" + matrix[2][2] + "\n"
                ;
    }
}
