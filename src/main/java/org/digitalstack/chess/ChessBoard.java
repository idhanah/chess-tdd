package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    private final java.util.Map<String, Pawn> positionMap = new java.util.HashMap<>();

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        String key = xCoordinate + "," + yCoordinate; // Create a unique key for the position
        if (!isLegalBoardPosition(xCoordinate, yCoordinate) || positionMap.containsKey(key)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        } else {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setChessBoard(this);
            positionMap.put(key, pawn);
    }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
         return java.util.stream.IntStream.range(0, BOARD_WIDTH).anyMatch(x -> x == xCoordinate) &&
                java.util.stream.IntStream.range(0, BOARD_HEIGHT).anyMatch(y -> y == yCoordinate);
    }
}