// Interface.java - interface for charting assignment
// Author: Chris Wilcox
// Date:   4/6/2015
// Class:  CS160
// Email:  wilcox@cs.colostate.edu

// Java interface definition
public interface Interface {

    // Enumeration of chart types
    public enum eType {
        PIECHART, BARCHART, LINEGRAPH
    }

    // Method to read chart file
    public boolean readFile(String filename);
    
    // Method to get chart title
    public String getTitle (eType type);
    
    // Method to get chart labels
    public String[] getLabels(eType type);
    
    // Method to get chart data
    public double[] getData(eType type, int series);
}
