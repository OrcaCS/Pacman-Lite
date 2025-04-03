import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[][] maze = new String[6][11];
        int row = 0;
        int col = 0;
        char key = ' ';

        for (row = 0; row < maze.length; row++) {
            for (col = 0; col < maze[row].length; col++) {
                maze[row][col] = ".";
            }
        }

        changeMaze(maze, row, col);
        place(maze, row, col);
        maze(maze, row, col);

        int playerRow = 0;
        int playerCol = 10;

        while (true) {
            move(maze, key, row, col, playerRow, playerCol);
        }
    }

    public static void changeMaze(String[][] maze, int row, int col) {
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

    public static void maze(String[][] maze, int row, int col) {
        System.out.println("-------------------------------------");
        for (row = 0; row < maze.length; row++) {
            switch (row) {
                case 0:
                    System.out.print("  ");
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

    public static void move(String[][] maze, char key, int row, int col, int playerRow, int playerCol) {
        Scanner keyboard = new Scanner(System.in);
        key = keyboard.next().charAt(0);

        if (key == 's') {
            maze[(playerRow + 1)][playerCol] = "O";
            maze[playerRow][playerCol] = " ";
            key = ' ';
            maze(maze, row, col);
        }
    }
}
