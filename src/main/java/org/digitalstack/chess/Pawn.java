package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    private static final java.util.Map<PieceColor, Integer> MOVE_DIRECTION = java.util.Map.of(
        PieceColor.BLACK, -1,
        PieceColor.WHITE, 1
    );

    public void move(MovementType movementType, int newX, int newY) {
        int direction = MOVE_DIRECTION.get(pieceColor);
        if (movementType == MovementType.MOVE &&
            chessBoard.isLegalBoardPosition(newX, newY) &&
            newX == xCoordinate &&
            newY == yCoordinate + direction) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}