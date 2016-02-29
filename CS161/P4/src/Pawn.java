import java.util.ArrayList;

public class Pawn extends ChessPiece {
  public Pawn(ChessBoard board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    // If true use first value, else use second.
    String unicodeCharacter = (this.getColor() == ChessPiece.Color.WHITE) ? "\u2659" : "\u265F";
    return unicodeCharacter;
  }

  // A pawn in the initial position may move one or two squares vertically
  // forward to an empty square but cannot leap over any piece. Subsequently
  // it can move only one square vertically forward to an empty square. A pawn
  // may also capture (replace) an opponent's piece diagonally one square in
  // front of it. Pawns can never move backwards. These are the only moves; we
  // will not implement the En passant rule and will also not allow promotion
  // to another piece if the pawn reaches the end of the column.
  @Override
  public ArrayList<String> legalMoves() {
    ArrayList<String> legalMoves = new ArrayList<String>();
    

    return legalMoves;
  }
}
