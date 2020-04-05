package tictactoe;

import java.util.Scanner;

public class Main {

    static char turn = 'X';

    public static void printGameTable(char[][] table) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j % 3 == 0) {
                    System.out.print("| " + table[i][j]);
                } else if (j % 3 == 1) {
                    System.out.print(" " + table[i][j] + " ");
                } else {
                    System.out.println(table[i][j] + " |");
                }
            }
        }
        System.out.println("---------");
    }

    public static boolean checkCoords(int coordA, int coordB) {
        if (coordA > 3 || coordA < 1 || coordB > 3 || coordB < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

    public static boolean put(char[][] gameTable, int coordA, int coordB, char turn) {

        boolean result = true;

        if (coordA == 1 && coordB == 1 && gameTable[2][0] == ' ') {
            gameTable[2][0] = turn;
        } else if (coordA == 2 && coordB == 1 && gameTable[2][1] == ' ') {
            gameTable[2][1] = turn;
        } else if (coordA == 3 && coordB == 1 && gameTable[2][2] == ' ') {
            gameTable[2][2] = turn;
        } else if (coordA == 1 && coordB == 2 && gameTable[1][0] == ' ') {
            gameTable[1][0] = turn;
        } else if (coordA == 2 && coordB == 2 && gameTable[1][1] == ' ') {
            gameTable[1][1] = turn;
        } else if (coordA == 3 && coordB == 2 && gameTable[1][2] == ' ') {
            gameTable[1][2] = turn;
        } else if (coordA == 1 && coordB == 3 && gameTable[0][0] == ' ') {
            gameTable[0][0] = turn;
        } else if (coordA == 2 && coordB == 3 && gameTable[0][1] == ' ') {
            gameTable[0][1] = turn;
        } else if (coordA == 3 && coordB == 3 && gameTable[0][2] == ' ') {
            gameTable[0][2] = turn;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            Main.turn = turn == 'X' ? 'O' : 'X';
            result = false;
        }

        Main.turn = turn == 'X' ? 'O' : 'X';

        return result;
    }

    public static void initialFill(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameTable[i][j] = ' ';
            }
        }
    }

    public static boolean xWins(char[][] gameTable) {
        String xxx = "";
        if ((xxx + gameTable[0][0] + gameTable[0][1] + gameTable[0][2]).equals("XXX") ||
            (xxx + gameTable[1][0] + gameTable[1][1] + gameTable[1][2]).equals("XXX") ||
            (xxx + gameTable[2][0] + gameTable[2][1] + gameTable[2][2]).equals("XXX")) {
            return true;
        } else if (gameTable[0][0] == 'X' && gameTable[1][1] == 'X' && gameTable[1][2] == 'X') {
            return true;
        } else if (gameTable[0][2] == 'X' && gameTable[1][1] == 'X' && gameTable[2][0] == 'X') {
            return true;
        } else if (gameTable[0][0] == 'X' && gameTable[1][0] == 'X' && gameTable[2][0] == 'X') {
            return true;
        } else if (gameTable[0][1] == 'X' && gameTable[1][1] == 'X' && gameTable[2][1] == 'X') {
            return true;
        } else return gameTable[0][2] == 'X' && gameTable[1][2] == 'X' && gameTable[2][2] == 'X';
    }
    
    public static boolean oWins(char[][] gameTable) {
        String ooo = "";
        if ((ooo + gameTable[0][0] + gameTable[0][1] + gameTable[0][2]).equals("OOO") ||
            (ooo + gameTable[1][0] + gameTable[1][1] + gameTable[1][2]).equals("OOO") ||
            (ooo + gameTable[2][0] + gameTable[2][1] + gameTable[2][2]).equals("OOO")) {
            return true;
        } else if (gameTable[0][0] == 'O' && gameTable[1][1] == 'O' && gameTable[1][2] == 'O') {
            return true;
        } else if (gameTable[0][2] == 'O' && gameTable[1][1] == 'O' && gameTable[2][0] == 'O') {
            return true;
        } else if (gameTable[0][0] == 'O' && gameTable[1][0] == 'O' && gameTable[2][0] == 'O') {
            return true;
        } else if (gameTable[0][1] == 'O' && gameTable[1][1] == 'O' && gameTable[2][1] == 'O') {
            return true;
        } else return gameTable[0][2] == 'O' && gameTable[1][2] == 'O' && gameTable[2][2] == 'O';
    }

    public static boolean drawCheck(char[][] gameTable) {
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ' ') {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[][] gameTable = new char[3][3];

        initialFill(gameTable);
        printGameTable(gameTable);
//        scan.next();
        while (scan.hasNextInt()) {

            System.out.print("Enter the coordinates: ");

            int coordA = scan.nextInt();
            int coordB = scan.nextInt();

            if (!checkCoords(coordA, coordB)) {
                continue;
            }

            if (put(gameTable, coordA, coordB, turn)) {
                printGameTable(gameTable);
            } else {
                continue;
            }
            if (xWins(gameTable)) {
                System.out.println("X wins");
                break;
            } else if (oWins(gameTable)) {
                System.out.println("O wins");
                break;
            } else if (drawCheck(gameTable)) {
                System.out.println("Draw");
                break;
            }
        }
    }
}
