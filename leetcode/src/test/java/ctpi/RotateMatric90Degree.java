package ctpi;

import org.junit.jupiter.api.Test;

public class RotateMatric90Degree {

    public char[][] rotate90DegreeInline(char[][] matrix) {

        for (int i = 0; i < matrix.length / 2; i++) { //len = 8 , i=0,1,2,3
            int end = matrix.length - 1 - i; //7,6,5,4
            for (int k = 0; k < end - i; k++) {
                char tmp = matrix[i][i + k]; // [1 2 3]
                matrix[i][i + k] = matrix[end - k][i]; // [1 2 3] <- [7 4 1]
                matrix[end - k][i] = matrix[end][end - k]; //[7 4 1] <- [9 8 7]
                matrix[end][end - k] = matrix[i + k][end]; //[9 8 7] <- [3 6 9]
                matrix[i + k][end] = tmp;// [3 6 9] <- [1 2 3]

            }
        }
        return matrix;
    }

    public String print(char[][] arr) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                data.append(arr[i][j] + " ");
            }
            data.append("\n");
        }
        return data.toString();
    }

    @Test
    public void test() {
        System.out.println(print(rotate90DegreeInline(new char[][]{{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p'}})));
        System.out.println(print(rotate90DegreeInline(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}})));
//        Assertions.assertEquals(print(new char[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}), print(rotate90DegreeInline(new char[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

}
