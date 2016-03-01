import java.util.ArrayList;

public abstract class ChessPiece {
	public enum Color {
		WHITE,
		BLACK
	};
	
	protected ChessBoard board; // the board it belongs to, default null
	protected int row; // the index of the horizontal rows 0..7
	protected int column; // the index of the vertical column 0..7
	protected Color color; // the color of the piece
	
	public ChessPiece(ChessBoard board, Color color) {
		this.board = board;
		this.color = color;
	}
	
	// This method returns the row.
	public int getRow() {
		return row;
	}

	// This method returns the column.
	public int getColumn() {
		return column;
	}

	// This method sets the row.
	public void setRow(int i) {
		this.row = i;
	}

	// This method sets the column.
	public void setColumn(int i) {
		this.column = i;
	}

	// This method returns the color of the piece. There is no need for a
	// setColor method because a piece cannot change color.
	public Color getColor() {
		return color;
	}

	// This method returns the position of the piece in the format single letter
	// (a..h) followed by a single digit (1..8).
	public String getPosition() {
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
      default:
        break;
    }

    returnString += (row + 1);

		return returnString;
	}

	// This method sets the position of the piece to the appropriate row and
	// column based on the argument, which in the format single letter (a..h)
	// followed by a single digit (1..8).
	public void setPosition(String position) {
		int[] coords = board.parsePosition(position);

		setRow(coords[0]);
		setColumn(coords[1]);
	}


	abstract public String toString();
	abstract public ArrayList<String> legalMoves();
}
