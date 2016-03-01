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

  // A bishop can move any number of squares diagonally in any direction as
  // long as it does not have to leap over other pieces. At the end of the
  // move, it can occupy a previously empty square or capture (replace) an
  // opponent's piece but it cannot replace another piece of the same player.
  @Override
  public ArrayList<String> legalMoves() {
    ArrayList<String> legalMoves = new ArrayList<String>();
    
    return legalMoves;
  }
}
