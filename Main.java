import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[][] maze = new String[6][11];
        int row = 0;
        int col = 0;
        char key = ' ';
        int playerRow = 0;
        int playerCol = 10;
        int level = 1;

        for (row = 0; row < maze.length; row++) {
            for (col = 0; col < maze[row].length; col++) {
                maze[row][col] = ".";
            }
        }

        System.out.println("Please select a level: 1, 2");
        level = keyboard.nextInt();
        if (level == 1) {
            levelOne(maze, row, col);
        }
        if (level == 2) {
            levelTwo(maze, row, col);
        }
        place(maze, row, col);
        maze(maze, row, col);

        while (true) {
            int[] newPositions = move(maze, key, row, col, playerRow, playerCol);
            playerRow = newPositions[0];
            playerCol = newPositions[1];

            if (win(maze)) {
                System.out.println("You win!");
                System.exit(1);
            }
        }
    }

    public static void levelOne(String[][] maze, int row, int col) {
        for (row = 0; row < 5; row++) {
            maze[row][1] = "|";
        }
        for (row = 1; row < 6; row++) {
            maze[row][3] = "|";
        }
        for (row = 0; row < 5; row++) {
            maze[row][5] = "|";
        }
        for (row = 1; row < 6; row++) {
            maze[row][7] = "|";
        }
        for (row = 0; row < 5; row++) {
            maze[row][9] = "|";
        }
    }

    public static void levelTwo(String[][] maze, int row, int col) {
        for (row = 0; row < 4; row++) {
            maze[row][5] = "|";
        }
        for (row = 0; row < 3; row++) {
            maze[row][9] = "|";
        }
        for (row = 4; row < 6; row++) {
            maze[row][9] = "|";
        }
        maze[2][8] = "_";
        maze[1][7] = "|";
        maze[2][7] = "|";
        maze[4][7] = "|";
        maze[1][3] = "_";
        maze[3][3] = "_";
        maze[3][4] = "_";
        maze[4][3] = "|";
        maze[4][2] = "_";
        maze[4][1] = "_";
        maze[3][1] = "|";
        maze[2][1] = "|";
        maze[1][1] = "_";
        maze[1][2] = "_";
        maze[5][5] = "|";
    }

    public static void maze(String[][] maze, int row, int col) {
        System.out.println("\n-------------------------------------");
        for (row = 0; row < maze.length; row++) {
            switch (row) {
                case 0:
                    System.out.print("| ");
                    break;
                case 1:
                    System.out.print("\n| ");
                    break;
                case 2:
                    System.out.print("\n| ");
                    break;
                case 3:
                    System.out.print("\n| ");
                    break;
                case 4:
                    System.out.print("\n| ");
                    break;
                case 5:
                    System.out.print("\n| ");
                    break;
            }
            for (col = 0; col < maze[row].length; col++) {
                System.out.print(" " + maze[row][col] + " ");
            }
            System.out.print(" |");
        }
        System.out.println("\n-------------------------------------");
    }

    public static void place(String[][] maze, int row, int col) {
        maze[0][10] = "O";
    }

    public static int[] move(String[][] maze, char key, int row, int col, int playerRow, int playerCol) {
        Scanner keyboard = new Scanner(System.in);
        key = keyboard.next().charAt(0);

        if (key == 'w') {
            try {
                if (maze[(playerRow - 1)][playerCol] != "|" && maze[(playerRow - 1)][playerCol] != "_") {
                    maze[(playerRow - 1)][playerCol] = "O";
                    maze[playerRow][playerCol] = " ";
                    playerRow--;
                    key = ' ';
                    maze(maze, row, col);
                } else {
                    maze(maze, row, col);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                maze(maze, row, col);
            }
        } else if (key == 's') {
            try {
                if (maze[(playerRow + 1)][playerCol] != "|" && maze[(playerRow + 1)][playerCol] != "_") {
                    maze[(playerRow + 1)][playerCol] = "O";
                    maze[playerRow][playerCol] = " ";
                    playerRow++;
                    key = ' ';
                    maze(maze, row, col);
                } else {
                    maze(maze, row, col);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                maze(maze, row, col);
            }
        } else if (key == 'a') {
            try {
                if (maze[playerRow][(playerCol - 1)] != "|" && maze[playerRow][(playerCol - 1)] != "|") {
                    maze[playerRow][(playerCol - 1)] = "O";
                    maze[playerRow][playerCol] = " ";
                    playerCol--;
                    key = ' ';
                    maze(maze, row, col);
                } else {
                    maze(maze, row, col);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                maze(maze, row, col);
            }
        } else if (key == 'd') {
            try {
                if (maze[playerRow][(playerCol + 1)] != "|" && maze[playerRow][(playerCol + 1)] != "_") {
                    maze[playerRow][(playerCol + 1)] = "O";
                    maze[playerRow][playerCol] = " ";
                    playerCol++;
                    key = ' ';
                    maze(maze, row, col);
                } else {
                    maze(maze, row, col);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                maze(maze, row, col);
            }
        } else {
            maze(maze, row, col);
        }

        return new int[] { playerRow, playerCol };
    }

    public static boolean win(String[][] maze) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col].equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }
}
