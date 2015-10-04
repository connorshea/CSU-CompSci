// Description: Another Maze Program
// Author: Chris Wilcox
// Date:   10/3/2015
// Class:  CS160
// Email:  wilcox@cs.colostate.edu

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Maze {

	// Maze variables
	private char mazeData[][];
	private int mazeWidth;
	private int mazeHeight;
	private int finalRow, finalCol;
	private int currRow, currCol;
	private int prevRow = -1;
	private int prevCol = -1;

	// User interface
	private JFrame frame;
	private JPanel panel;
	private Image chihiro, haku, yubaba, success;
	private ArrayList<JButton> buttons;

	// Maze constructor
	public Maze(String fileName) {

		// Read maze
		readMaze(fileName);

		// Graphics setup
		setupGraphics();
	}

	// Get maze width
	public int getWidth() {
		return mazeWidth;
	}

	// Get maze height
	public int getHeight() {
		return mazeHeight;
	}

	// Get row
	public int getRow() {
		return currRow;
	}

	// Get column
	public int getColumn() {
		return currCol;
	}

	// Move right
	public void moveRight() {
		currCol++;
		redraw(true);
	}

	// Move left
	public void moveLeft() {
		currCol--;
		redraw(true);
	}

	// Move up
	public void moveUp() {
		currRow--;
		redraw(true);
	}

	// Move down
	public void moveDown() {
		currRow++;
		redraw(true);
	}

	public boolean isDone() {

		// Maze solved?
		if ((currRow == finalRow) && (currCol == finalCol))
			return true;
		else
			return false;
	}

	private void redraw(boolean print) {

		// Wait for awhile
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		if (currRow < 0 || currRow >= mazeHeight || currCol < 0 || currCol >= mazeWidth) {
			System.err.println("Chihiro went outside the maze!");
			System.exit(0);
		}
		if (mazeData[currRow][currCol] == 'Y') {
			System.err.println("Chihiro ran into the witch Yubaba!");
			System.exit(0);
		}
		if (print)
			System.err.println("Moved to row " + currRow + ", column " + currCol);

		// Compute index and remove icon
		int index = (prevRow * mazeWidth) + prevCol;
		if ((prevRow >= 0) && (prevCol >= 0)) {
			buttons.get(index).setIcon(null);
		}

		// Compute index and add icon
		index = (currRow * mazeWidth) + currCol;
		if ((currRow == finalRow) && (currCol == finalCol)) {
			buttons.get(index).setIcon(new ImageIcon(success));
			System.err.println("Chihiro found Haku, congratulations!");
		}
		else
			buttons.get(index).setIcon(new ImageIcon(chihiro));

		// Store previous location
		prevRow = currRow;
		prevCol = currCol;
	}

	// Set button
	private void setButton(JButton button, int row, int col) {

		if (mazeData[row][col] == 'C') {
			button.setIcon(new ImageIcon(chihiro));
			currRow = row;
			currCol = col;
		} else if (mazeData[row][col] == 'H') {
			button.setIcon(new ImageIcon(haku));
			finalRow = row;
			finalCol = col;
		} else if (mazeData[row][col] == 'Y') {
			button.setIcon(new ImageIcon(yubaba));
		}
	}

	// Read maze
	private void readMaze(String filename) {
		try {

			// Open file
			Scanner scan = new Scanner(new File(filename));

			// Read numbers
			mazeWidth = scan.nextInt();
			mazeHeight = scan.nextInt();

			// Allocate maze
			mazeData = new char[mazeHeight][mazeWidth];

			// Read maze
			for (int row = 0; row < mazeHeight; row++) {

				// Read line
				String line = scan.next();
				for (int col = 0; col < mazeWidth; col++) {
					mazeData[row][col] = line.charAt(col);
				}
			}

			// Close file
			scan.close();

		} catch (IOException e) {
			System.err.println("Cannot read maze: " + filename);
			System.exit(0);
		}
	}

	// Setup graphics
	private void setupGraphics() {

		// Create grid
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new GridLayout(mazeHeight, mazeWidth, 0, 0));
		frame.add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);

		// Look and feel
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Configure window
		frame.setSize(mazeWidth * 100, mazeHeight * 100);
		frame.setTitle("Maze");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);

		// Load and scale images
		ImageIcon icon0 = new ImageIcon("Chihiro.png");
		Image image0 = icon0.getImage();
		chihiro = image0.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

		ImageIcon icon1 = new ImageIcon("Haku.png");
		Image image1 = icon1.getImage();
		haku = image1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

		ImageIcon icon2 = new ImageIcon("Yubaba.png");
		Image image2 = icon2.getImage();
		yubaba = image2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

		ImageIcon icon3 = new ImageIcon("Success.png");
		Image image3 = icon3.getImage();
		success = image3.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

		// Build panel of buttons
		buttons = new ArrayList<JButton>();

		for (int row = 0; row < mazeHeight; row++) {
			for (int col = 0; col < mazeWidth; col++) {

				// Initialize and add button
				JButton button = new JButton();
				Border border = new LineBorder(Color.darkGray, 4);
				button.setOpaque(true);
				button.setBackground(Color.gray);
				button.setBorder(border);
				setButton(button, row, col);
				panel.add(button);
				buttons.add(button);
			}
		}

		// Show window
		redraw(false);
		frame.setVisible(true);
	}
}