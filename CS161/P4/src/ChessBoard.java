import java.util.Arrays;
import java.util.ArrayList;

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
    board = new ChessPiece[8][8];
  }

  // This method initializes the board to the standard chess opening state with
  // indexing as shown in the figure. This method should use the constructors
  // of the appropriate pieces, and call placePiece below to place the newly
  // constructed pieces in the right position.
  public void initialize() {
    /* First Row */
    // Black Rook
    placePiece(new Rook(this, ChessPiece.Color.BLACK), "a8");
    // Black Knight
    placePiece(new Knight(this, ChessPiece.Color.BLACK), "b8");
    // Black Bishop
    placePiece(new Bishop(this, ChessPiece.Color.BLACK), "c8");
    // Black Queen
    placePiece(new Queen(this, ChessPiece.Color.BLACK), "d8");
    // Black King
    placePiece(new King(this, ChessPiece.Color.BLACK), "e8");
    // Black Bishop
    placePiece(new Bishop(this, ChessPiece.Color.BLACK), "f8");
    // Black Knight
    placePiece(new Knight(this, ChessPiece.Color.BLACK), "g8");
    // Black Rook
    placePiece(new Rook(this, ChessPiece.Color.BLACK), "h8");

    /* Second Row */
    // Black Pawns
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "a7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "b7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "c7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "d7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "e7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "f7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "g7");
    placePiece(new Pawn(this, ChessPiece.Color.BLACK), "h7");

    /* Second-to-last Row */
    // White Pawns
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "a2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "b2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "c2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "d2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "e2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "f2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "g2");
    placePiece(new Pawn(this, ChessPiece.Color.WHITE), "h2");

    /* Last Row */
    // White Rook
    placePiece(new Rook(this, ChessPiece.Color.WHITE), "a1");
    // White Knight
    placePiece(new Knight(this, ChessPiece.Color.WHITE), "b1");
    // White Bishop
    placePiece(new Bishop(this, ChessPiece.Color.WHITE), "c1");
    // White Queen
    placePiece(new Queen(this, ChessPiece.Color.WHITE), "d1");
    // White King
    placePiece(new King(this, ChessPiece.Color.WHITE), "e1");
    // White Bishop
    placePiece(new Bishop(this, ChessPiece.Color.WHITE), "f1");
    // White Knight
    placePiece(new Knight(this, ChessPiece.Color.WHITE), "g1");
    // White Rook
    placePiece(new Rook(this, ChessPiece.Color.WHITE), "h1");
  }

  // This method returns the chess piece at a given position.
  public ChessPiece getPiece(String position) {
    int[] coords = parsePosition(position);

    if (board[coords[0]][coords[1]] == null) {
      return null;
    } else {
      return board[coords[0]][coords[1]];
    }
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
    int[] coords = parsePosition(position);
    
    if (board[coords[0]][coords[1]] == null) {
      board[coords[0]][coords[1]] = piece;
      piece.setPosition(position);
      return true;
    }

    return false;
  }

  // This method checks if moving the piece from the fromPosition to toPosition
  // is a legal move. Legality is defined based on the rules described above.
  // If the move is legal, it executes the move, changing the value of the
  // board as needed. The method returns true if the move was executed, and
  // false otherwise.
  public boolean move(String fromPosition, String toPosition) {
    ChessPiece piece = getPiece(fromPosition);
    ArrayList<String> legalMoves = piece.legalMoves();

    if (legalMoves.contains(toPosition)) {
      placePiece(piece, toPosition);
      int[] coords = parsePosition(fromPosition);
      
      // Nullify old position.
      board[coords[0]][coords[1]] = null;

      return true;
    }

    return false;
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
    
    for (int i = 0; i < 7; i++) {
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

  public String parseCoords(int row, int column) {
    String returnString = "";

    switch (column) {
      case 0: returnString += "a";
        break;
      case 1: returnString += "b";
        break;
      case 2: returnString += "c";
        break;
      case 3: returnString += "d";
        break;
      case 4: returnString += "e";
        break;
      case 5: returnString += "f";
        break;
      case 6: returnString += "g";
        break;
      case 7: returnString += "h";
        break;
    }

    switch (row) {
      case 0: returnString += "1";
        break;
      case 1: returnString += "2";
        break;
      case 2: returnString += "3";
        break;
      case 3: returnString += "4";
        break;
      case 4: returnString += "5";
        break;
      case 5: returnString += "6";
        break;
      case 6: returnString += "7";
        break;
      case 7: returnString += "8";
        break;
      default:
        break;
    }

    return returnString;
  }

  public int[] parsePosition(String position) {
    int[] coordinates = new int[2];

    switch (position.charAt(0)) {
      case 'a': coordinates[1] = 0;
        break;
      case 'b': coordinates[1] = 1;
        break;
      case 'c': coordinates[1] = 2;
        break;
      case 'd': coordinates[1] = 3;
        break;
      case 'e': coordinates[1] = 4;
        break;
      case 'f': coordinates[1] = 5;
        break;
      case 'g': coordinates[1] = 6;
        break;
      case 'h': coordinates[1] = 7;
        break;
      default:
        break;
    }

    switch (position.charAt(1)) {
      case '8': coordinates[0] = 7;
        break;
      case '7': coordinates[0] = 6;
        break;
      case '6': coordinates[0] = 5;
        break;
      case '5': coordinates[0] = 4;
        break;
      case '4': coordinates[0] = 3;
        break;
      case '3': coordinates[0] = 2;
        break;
      case '2': coordinates[0] = 1;
        break;
      case '1': coordinates[0] = 0;
        break;
      default:
        break;
    }

    return coordinates;
  }

  public static void main(String[] args) {
    ChessBoard board = new ChessBoard();
    board.initialize();

    System.out.println(Arrays.toString(board.parsePosition("c3")));
    System.out.println(board.parseCoords(2,2));
    System.out.println(board.getPiece("a1"));

    System.out.println(board);


    board.move("d2", "d4");
    System.out.println(board);
    board.move("c1", "f4");
    System.out.println(board);
    board.move("e7", "e5");
    System.out.println(board);
    board.move("e2", "e3");
    System.out.println(board);
    board.move("a2", "a4");
    System.out.println(board);
    board.move("a1", "a3");
    System.out.println(board);
    board.move("a3", "b3");
    
    System.out.println(board);
    board.move("a4", "a5");
    board.move("c2", "c4");
    System.out.println(board);
    board.move("f8", "g7");
    
    System.out.println(board);
    board.move("g2", "g4");
    board.move("f1", "h3");
    System.out.println(board);
  }
}
