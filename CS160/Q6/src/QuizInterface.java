public interface QuizInterface {

    // Interface Methods
    
    // Reads file contents into an array of strings
    public void readFile(String filename);

    // Compute statistics for the array
    public void computeStatistics(String []strings);

    // Print statistics for the array
    public void printStatistics();
    
    // Writes the contents of the array to a file
    public void writeFile(String filename, String []strings);

    // Find the smallest value in array
    public double findSmallest(double []values);
}