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

  // A rook can move any number of squares horizontally or vertically, forward
  // or backward, as long as it does not have to leap over other pieces. At
  // the end of the move, it can occupy a previously empty square or capture
  // (replace) an opponent's piece but it cannot replace another piece of the
  // same player.
  @Override
  public ArrayList<String> legalMoves() {
	  ArrayList<String> setOfLegalMoves = new ArrayList<String>();

    int currentRow = getRow();
    int currentColumn = getColumn();

    for (int i = currentRow + 1; i < 8; i++) {
      if (board.getPiece(board.parseCoords(i, currentColumn)) == null || board.getPiece(board.parseCoords(i, currentColumn)).getColor() != this.getColor() ) {
        setOfLegalMoves.add(board.parseCoords(i, currentColumn));
      } else {
        break;
      }
    }

    for (int i = currentRow - 1; i >= 0; i--) {
      if (board.getPiece(board.parseCoords(i, currentColumn)) == null || board.getPiece(board.parseCoords(i, currentColumn)).getColor() != this.getColor() ) {
        setOfLegalMoves.add(board.parseCoords(i, currentColumn));
      } else {
        break;
      }
    }

    for (int i = currentColumn + 1; i < 8; i++) {
      if (board.getPiece(board.parseCoords(currentRow, i)) == null || board.getPiece(board.parseCoords(currentRow, i)).getColor() != this.getColor() ) {
        setOfLegalMoves.add(board.parseCoords(currentRow, i));
      } else {
        break;
      }
    }

    for (int i = currentColumn - 1; i >= 0; i--) {
      if (board.getPiece(board.parseCoords(currentRow, i)) == null || board.getPiece(board.parseCoords(currentRow, i)).getColor() != this.getColor() ) {
        setOfLegalMoves.add(board.parseCoords(currentRow, i));
      } else {
        break;
      }
    }
    
    return setOfLegalMoves;
  }
}
