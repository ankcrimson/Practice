package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MatrixRotation {

  /**
   * find the number of rotations
   * @param m
   * @param n
   * @param r
   * @return
   */
  public static int findRotations(int m, int n, long r) {
    long rotation = 0;
    long tmpM = m;
    long tmpN = n;
    rotation = 2 * (tmpM - 1) + 2 * (tmpN - 1);
    // rotation = (int) r % rotation;
    return (int) rotation;
  }

  public static int increment(int len, int curr) {
    if (curr == len - 1)
      return 0;
    else
      return curr + 1;
  }

  public static void rotate(String[][] matrix, int i, long r) {
    // shift top row
    // top = i,i
    // bottom = rightbout,bottombound

    int rightBound = matrix[i].length - i - 1;
    int bottomBound = matrix.length - i - 1;
    // add it to 1D array
    ArrayList<String> al = new ArrayList<>();
    for (int j = i; j < rightBound; j++) {
      al.add(matrix[i][j]);
    }
    for (int j = i; j < bottomBound; j++) {
      al.add(matrix[j][rightBound]);
    }
    for (int j = rightBound; j > i; j--) {
      al.add(matrix[bottomBound][j]);
    }
    for (int j = bottomBound; j > i; j--) {
      al.add(matrix[j][i]);
    }

    int rotations = (int) (r % (long) al.size());


    for (int j = i; j < rightBound; j++) {
      matrix[i][j] = al.get(rotations);
      rotations = increment(al.size(), rotations);
    }
    for (int j = i; j < bottomBound; j++) {
      matrix[j][rightBound] = al.get(rotations);
      rotations = increment(al.size(), rotations);
    }
    for (int j = rightBound; j > i; j--) {
      matrix[bottomBound][j] = al.get(rotations);
      rotations = increment(al.size(), rotations);
    }
    for (int j = bottomBound; j > i; j--) {
      matrix[j][i] = al.get(rotations);
      rotations = increment(al.size(), rotations);
    }



  }

  public static void solve(int m, int n, long r, String[][] matrix) {
    for (int i = 0; i < Math.min(m, n) / 2; i++) {
      // int rotations = findRotations(m - i, n - i, r);
      rotate(matrix, i, r);
    }
    for (String[] arr : matrix) {
      for (String s : arr) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      String[] mnr = br.readLine().split(" ");
      int m = Integer.parseInt(mnr[0]);
      int n = Integer.parseInt(mnr[1]);
      long r = Long.parseLong(mnr[2]);
      String[][] matrix = new String[m][n];
      for (int i = 0; i < m; i++) {
        matrix[i] = br.readLine().split(" ");
      }
      solve(m, n, r, matrix);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }
}
