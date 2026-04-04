class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";
        
        int n = encodedText.length();
        int cols = n / rows;
        
        char[][] matrix = new char[rows][cols];
        
        // Fill matrix row-wise
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedText.charAt(index++);
            }
        }
        
        // Read diagonally
        StringBuilder result = new StringBuilder();
        
        for (int startCol = 0; startCol < cols; startCol++) {
            int i = 0, j = startCol;
            
            while (i < rows && j < cols) {
                result.append(matrix[i][j]);
                i++;
                j++;
            }
        }
        
        // Remove trailing spaces
        return result.toString().replaceAll("\\s+$", "");
    }
}