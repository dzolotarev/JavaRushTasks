package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * @author Denis Zolotarev
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;
    int score = 0;
    int maxTile = 2;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                int currentValue = gameTiles[i][j].value;
                if (currentValue == gameTiles[i + 1][j].value || currentValue == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        return false;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int index = (int) (Math.random() * emptyTiles.size()) % emptyTiles.size();
            Tile tile = emptyTiles.get(index);
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        final List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if (tile.value == 0) {
                    emptyTiles.add(tile);
                }
            }
        }
        return emptyTiles;
    }

    // ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
    private boolean compressTiles(Tile[] tiles) {
        boolean isArrayModified = false;
        int j = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].value != 0) {
                if (tiles[i].value != tiles[j].value) {
                    tiles[i].value = tiles[i].value ^ tiles[j].value;
                    tiles[j].value = tiles[i].value ^ tiles[j].value;
                    tiles[i].value = tiles[i].value ^ tiles[j].value;
                    isArrayModified = true;
                }
                j++;
            }
        }
        return isArrayModified;
    }

//    private boolean compressTiles(Tile[] tiles) {
//        int insertPosition = 0;
//        boolean result = false;
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            if (!tiles[i].isEmpty()) {
//                if (i != insertPosition) {
//                    tiles[insertPosition] = tiles[i];
//                    tiles[i] = new Tile();
//                    result = true;
//                }
//                insertPosition++;
//            }
//        }
//        return result;
//    }

    //т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}
    //ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}
    private boolean mergeTiles(Tile[] tiles) {
        boolean isArrayModified = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            int value = tiles[i].value;
            if (value == tiles[i + 1].value && value > 0) {
                int newValue = value * 2;
                tiles[i].value = newValue;
                tiles[i + 1].value = 0;
                score += newValue;
                if (maxTile < newValue) {
                    maxTile = newValue;
                }
                isArrayModified = true;
            }
        }
        if (isArrayModified) {
            compressTiles(tiles);
        }
        return isArrayModified;
    }

//    private boolean mergeTiles(Tile[] tiles) {
//        boolean result = false;
//        LinkedList<Tile> tilesList = new LinkedList<>();
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            if (tiles[i].isEmpty()) {
//                continue;
//            }
//
//            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
//                int updatedValue = tiles[i].value * 2;
//                if (updatedValue > maxTile) {
//                    maxTile = updatedValue;
//                }
//                score += updatedValue;
//                tilesList.addLast(new Tile(updatedValue));
//                tiles[i + 1].value = 0;
//                result = true;
//            } else {
//                tilesList.addLast(new Tile(tiles[i].value));
//            }
//            tiles[i].value = 0;
//        }
//
//        for (int i = 0; i < tilesList.size(); i++) {
//            tiles[i] = tilesList.get(i);
//        }
//
//        return result;
//    }

    //A base move to left
    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isMoved = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            Tile[] tiles = gameTiles[i];
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                isMoved = true;
            }
        }
        if (isMoved) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        leftArrayRotate();
        leftArrayRotate();
        left();
        leftArrayRotate();
        leftArrayRotate();
    }

    public void down() {
        saveState(gameTiles);
        leftArrayRotate();
        leftArrayRotate();
        leftArrayRotate();
        left();
        leftArrayRotate();
    }

    public void up() {
        saveState(gameTiles);
        leftArrayRotate();
        left();
        leftArrayRotate();
        leftArrayRotate();
        leftArrayRotate();
    }

    //anti-clockwise rotation
    private void leftArrayRotate() {
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - i - 1; j++) {
                int tempValue = gameTiles[i][j].value; // Store current cell in temp variable
                gameTiles[i][j].value = gameTiles[j][FIELD_WIDTH - 1 - i].value; // Move values from right to top
                gameTiles[j][FIELD_WIDTH - 1 - i].value = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j].value;// Move values from bottom to right
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j].value = gameTiles[FIELD_WIDTH - 1 - j][i].value;// Move values from left to bottom
                gameTiles[FIELD_WIDTH - 1 - j][i].value = tempValue;// Assign temp to left
            }
        }
    }
    ////clockwise rotation
//    private void rightArrayRotate() {
//        Tile[][] rotatedTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                rotatedTiles[i][j] = new Tile(0);
//            }
//        }
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                rotatedTiles[i][j].value = gameTiles[FIELD_WIDTH - j - 1][i].value;
//            }
//        }
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                gameTiles[i][j].value = rotatedTiles[i][j].value;
//            }
//        }
//    }

//    //another clockwise rotation
//    private Tile[][] rotateClockwise(Tile[][] tiles) {
//        final int N = tiles.length;
//        Tile[][] result = new Tile[N][N];
//        for (int r = 0; r < N; r++) {
//            for (int c = 0; c < N; c++) {
//                result[c][N - 1 - r] = tiles[r][c];
//            }
//        }
//        return result;
//    }

    private void saveState(Tile[][] tiles) {
        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    //    private boolean hasBoardChanged() {
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                if (gameTiles[i][j].value != previousStates.peek()[i][j].value) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public boolean hasBoardChanged() {
        int gameTilesWeight = 0;
        int previousGameTilesWeight = 0;
        Tile[][] previousGameTiles = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTilesWeight += gameTiles[i][j].value;
                previousGameTilesWeight += previousGameTiles[i][j].value;
            }
        }
        return gameTilesWeight != previousGameTilesWeight;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(-1, 0, move);
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        MoveEfficiency moveEfficiency = priorityQueue.peek();
        if (moveEfficiency != null) {
            moveEfficiency.getMove().move();
        }
    }
}