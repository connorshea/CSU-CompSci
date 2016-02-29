import java.util.ArrayList;

public class Rook extends ChessPiece {
  public Rook(ChessBoard board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    // If true use first value, else use second.
    String unicodeCharacter = (this.getColor() == ChessPiece.Color.WHITE) ? "\u2656" : "\u265C";
    return unicodeCharacter;
  }

  @Override
  public ArrayList<String> legalMoves() {
	  return null;
  }
}
