import java.util.ArrayList;

public class Queen extends ChessPiece {
  public Queen(ChessBoard board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    // If true use first value, else use second.
    String unicodeCharacter = (this.getColor() == ChessPiece.Color.WHITE) ? "\u2655" : "\u265B";
    return unicodeCharacter;
  }

  @Override
  public ArrayList<String> legalMoves() {
    ArrayList<String> legalMoves = new ArrayList<String>();
    return legalMoves;
  }
}
