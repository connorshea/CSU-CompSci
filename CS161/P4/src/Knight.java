import java.util.ArrayList;

public class Knight extends ChessPiece {
  public Knight(ChessBoard board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    // If true use first value, else use second.
    String unicodeCharacter = (this.getColor() == ChessPiece.Color.WHITE) ? "\u2658" : "\u265E";
    return unicodeCharacter;
  }

  @Override
  public ArrayList<String> legalMoves() {
    ArrayList<String> legalMoves = new ArrayList<String>();
    return legalMoves;
  }
}
