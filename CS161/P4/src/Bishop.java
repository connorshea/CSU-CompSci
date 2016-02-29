import java.util.ArrayList;

public class Bishop extends ChessPiece {
  public Bishop(ChessBoard board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    // If true use first value, else use second.
    String unicodeCharacter = (this.getColor() == ChessPiece.Color.WHITE) ? "\u2657" : "\u265D";
    return unicodeCharacter;
  }

  @Override
  public ArrayList<String> legalMoves() {
    
  }
}
