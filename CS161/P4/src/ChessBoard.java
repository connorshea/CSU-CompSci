/**
 * @author Connor Shea
 * @assignment P4
 * @class CS161
 * @date February 29, 2016
 * @url http://www.cs.colostate.edu/~cs161/spring16/more_assignments/P4/P4.html
 */

/**
 * 
 * DA RULES:
 * 
 * The king does not move at all. Nor can it castle. The queen and knight can't
 * move either.
 * 
 * A pawn in the initial position may move one or two squares vertically 
 * forward to an empty square but cannot leap over any piece. Subsequently it
 * can move only one square vertically forward to an empty square. A pawn may
 * also capture (replace) an opponent's piece diagonally one square in front of
 * it. Pawns can never move backwards. These are the only moves; we will not
 * implement the En passant rule and will also not allow promotion to another
 * piece if the pawn reaches the end of the column.
 *
 * A rook can move any number of squares horizontally or vertically, forward or
 * backward, as long as it does not have to leap over other pieces. At the end
 * of the move, it can occupy a previously empty square or capture (replace)
 * an opponent's piece but it cannot replace another piece of the same player.
 *
 * A bishop can move any number of squares diagonally in any direction as long
 * as it does not have to leap over other pieces. At the end of the move, it
 * can occupy a previously empty square or capture (replace) an opponent's
 * piece but it cannot replace another piece of the same player.
 *
 */

public class ChessBoard {
	private ChessPiece[][] board;
	
	public ChessBoard() {
		this.board = new ChessPiece[8][8];
	}

	// This method initializes the board to the standard chess opening state with
  // indexing as shown in the figure. This method should use the constructors
  // of the appropriate pieces, and call placePiece below to place the newly
  // constructed pieces in the right position.
	public void initialize() {
		
	}

  // This method returns the chess piece at a given position.
  public ChessPiece getPiece(String position) {
	  
  }

  // This method tries to place the given piece at a given position, and returns
  // true if successful, and false if there is already a piece of the same
  // player in the given position. If an opponent's piece exists, that piece is
  // captured. The position is represented as a two-character string (e.g. e8)
  // as described above. Assume that only legal strings will be used. The first
  // letter is in lowercase (a..h) and the second letter is a digit (1..8). If
  // successful, this method should call an appropriate method in the
  // ChessPiece class (i.e., setPosition) to set the piece's position.
  public boolean placePiece(ChessPiece piece, String position) {

  }

  // This method checks if moving the piece from the fromPosition to toPosition
  // is a legal move. Legality is defined based on the rules described above.
  // If the move is legal, it executes the move, changing the value of the
  // board as needed. The method returns true if the move was executed, and
  // false otherwise.
  public boolean move(String fromPosition, String toPosition) {

  }

  // You must include the following toString method to help debug your program.
  // We assume that ChessPiece has an appropriately implemented toString method,
  // whose implementation is described below.
  public String toString() {
    String chess = "";
    String upperLeft = "\u250C";
    String upperRight = "\u2510";
    String horizontalLine = "\u2500";
    String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
    String verticalLine = "\u2502";
    String upperT = "\u252C";
    String bottomLeft = "\u2514";
    String bottomRight = "\u2518";
    String bottomT = "\u2534";
    String plus = "\u253C";
    String leftT = "\u251C";
    String rightT = "\u2524";

    String topLine = upperLeft;
    
    for (int i = 0; i<7; i++) {
      topLine += horizontal3 + upperT;
    }
    
    topLine += horizontal3 + upperRight;

    String bottomLine = bottomLeft;
    
    for (int i = 0; i < 7; i++) {
      bottomLine += horizontal3 + bottomT;
    }

    bottomLine += horizontal3 + bottomRight;
    chess += topLine + "\n";

    for (int row = 7; row >= 0; row--) {
      String midLine = "";
      
      for (int col = 0; col < 8; col++) {
        if (board[row][col] == null) {
          midLine += verticalLine + " \u3000 ";
        } else {
          midLine += verticalLine + " " + board[row][col] + " ";
        }
      }

      midLine += verticalLine;
      String midLine2 = leftT;
      
      for (int i = 0; i < 7; i++) {
        midLine2 += horizontal3 + plus;
      }

      midLine2 += horizontal3 + rightT;
      chess += midLine + "\n";
      
      if (row >= 1) {
        chess += midLine2 + "\n";
      }
    }

    chess += bottomLine;
    return chess;
  }

  public static void main(String[] args) {
    ChessBoard board = new ChessBoard();
    board.initialize();
    System.out.println(board);
    board.move("c2", "c4");
  }
}
