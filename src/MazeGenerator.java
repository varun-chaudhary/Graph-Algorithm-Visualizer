public class MazeGenerator {

    private static final boolean HORIZONTAL = false, VERTICAL = true;

    public static void recursiveDivision(Node[][] grid, int startX, int startY, int endX, int endY) {
        int width = endX - startX;
        int height = endY - startY;

        if (width < 2 || height < 2) {
            return;
        }

        boolean orientation;
        if (width < height) {
            orientation = HORIZONTAL;
        } else if (width > height) {
            orientation = VERTICAL;
        } else {
            orientation = (int) (Math.random() * 2) == 0 ? HORIZONTAL : VERTICAL;
        }

        int wallX = 0, wallY = 0, holeX = 0, holeY = 0;
        boolean loopBack = true;
        if (orientation == HORIZONTAL) {
            int possibleRows = 0;
            for (int row = 1; row < height; row += 2) {
                possibleRows++;
            }

            while (loopBack == true) {
                wallX = startX;
                wallY = (startY + 1) + (2 * (int) (Math.random() * possibleRows));

                boolean leftHole = false, rightHole = false;
                if (wallX > 0 && grid[wallY][wallX - 1].isEmpty()) {
                    leftHole = true;
                }
                if (endX < grid[0].length - 1 && grid[wallY][endX + 1].isEmpty()) {
                    rightHole = true;
                }

                if (leftHole && rightHole) {

                    if (possibleRows > 1) {
                        loopBack = true;
                        System.out.println("[H] Looping back");
                    } else {
                        loopBack = false;
                        System.out.println("[H] Couldn't loop back; not enough possible rows");
                    }

                } else if (leftHole && !rightHole) {
                    holeX = wallX;
                    loopBack = false;
                    System.out.println("[H] Left hole");
                } else if (!leftHole && rightHole) {
                    holeX = endX;
                    loopBack = false;
                    System.out.println("[H] Right hole");
                } else {

                    holeX = wallX + (int) (Math.random() * width);
                    loopBack = false;
                }
            }
            holeY = wallY;
        } else {
            int possibleCols = 0;
            for (int col = 1; col < width; col += 2) {
                possibleCols++;
            }

            while (loopBack == true) {
                wallX = (startX + 1) + (2 * (int) (Math.random() * possibleCols));
                wallY = startY;

                boolean topHole = false, bottomHole = false;
                if (wallY > 0 && grid[wallY - 1][wallX].isEmpty()) {
                    topHole = true;
                }
                if (endY < grid.length - 1 && grid[endY + 1][wallX].isEmpty()) {
                    bottomHole = true;
                }

                if (topHole && bottomHole) {

                    if (possibleCols > 1) {
                        loopBack = true;
                        System.out.println("[V] Looping back");
                    } else {
                        loopBack = false;
                        System.out.println("[V] Couldn't loop back; not enough possible columns");
                    }
                } else if (topHole && !bottomHole) {
                    holeY = wallY;
                    loopBack = false;
                    System.out.println("[V] Top hole");
                } else if (!topHole && bottomHole) {
                    holeY = endY;
                    loopBack = false;
                    System.out.println("[V] Bottom hole");
                } else {

                    holeY = wallY + (int) (Math.random() * height);
                    loopBack = false;
                }
            }
            holeX = wallX;
        }

        int length = orientation == HORIZONTAL ? width : height;

        for (int i = 0; i <= length; i++) {
            if (!(wallX == holeX && wallY == holeY)) {
                grid[wallY][wallX].setBarrier();
            }

            if (i != length) {
                if (orientation == HORIZONTAL) {
                    wallX++;
                } else {
                    wallY++;
                }
            }
        }

        if (orientation == HORIZONTAL) {
            recursiveDivision(grid, startX, startY, endX, wallY - 1);
            recursiveDivision(grid, startX, wallY + 1, endX, endY);
        } else {
            recursiveDivision(grid, startX, startY, wallX - 1, endY);
            recursiveDivision(grid, wallX + 1, startY, endX, endY);
        }
    }
}
