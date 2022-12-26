import java.util.ArrayList;
import java.util.HashSet;

class RobotGrid {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x; 
            this.y = y;
        }
    }

    public static ArrayList<Point> getPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> blocked = new HashSet<>();
        if (getPath(grid, grid.length - 1, grid[0].length - 1, path, blocked)) {
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path, HashSet<Point> blocked) {
        if (row < 0 || col < 0 || !grid[row][col]) return false;

        Point p = new Point(row, col);

        if (blocked.contains(p)) return false;

        boolean atOrigin = (row == 0) && (col == 0);

        if (atOrigin || getPath(grid, row, col - 1, path, blocked) || getPath(grid, row - 1, col, path, blocked)) {
            path.add(p);
            return true;
        }

        blocked.add(p);
        return false;
    }


    public static void main(String[] args) {
        boolean[][] grid = {
            {true, true, false, true},
            {true, true, true, false},
            {false, true, true, true},
            {false, true, false, true},
            {true, true, true, true}
        };
        ArrayList<Point> path = RobotGrid.getPath(grid);
        if (path == null) {
            System.out.println("No path found");
            return;
        }
        for (Point p : path) {
            // row, col
            System.out.println("Point: ( " + p.x + ", " + p.y + " )");
        }
    }
}