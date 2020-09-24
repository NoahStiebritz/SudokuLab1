package pkgGame;

import java.util.Arrays;

public class LatinSquare {
	
	private int[][] latinSquare;

	public LatinSquare() {
		super();
	}

	public LatinSquare(int[][] latinSquare) {
		super();
		this.latinSquare = latinSquare;
	}
	
	/*
	 * return LatinSquare instance attribute
	 * */
	public int[][] getLatinSquare() {
		return latinSquare;
	}
	
	/*
	 * set LatinSquare instance attribute
	 * */
	public void setLatinSquare(int[][] square) {
		this.latinSquare = square;
	}
	
	/*
	 * getColumn - return a one-dimension array from a given column in the LatinSquare 
		0 1 2 3 
		1 2 3 4 
		3 4 1 2 
		4 1 3 2 
		In this example, getColumn(1) would return [1],[2],[4],[1]
 
	 * */
	public int[] getColumn(int iCol) {
		int[] col = new int[latinSquare[iCol].length];
		for(int i = 0; i < latinSquare[iCol].length; i++) {
			col[i] = latinSquare[i][iCol];
		}
		return col;
	}
	
	/*
	 * getRow - return a one-dimension array from a given row in the LatinSquare
		0 1 2 3 
		1 2 3 4 
		3 4 1 2 
		4 1 3 2 
		In this example, getRow(1) would return [1],[2],[3],[4]

	 * */
	public int[] getRow(int iRow) {
		int[] row = new int[latinSquare.length];
		for(int i = 0; i < latinSquare.length; i++) {
			row[i] = latinSquare[iRow][i];
		}
		return row;
	}
	
	/*
	 * Pass in a one-dimension array, pass back true if there is a duplicate value
	 * */
	public boolean hasDuplicates(int[] arr) {
		int[] testArr = arr;
		Arrays.sort(testArr);
		for(int i = 0; i < testArr.length - 1; i++) {
			if(testArr[i] == testArr[i+1])
				return true;
		}
		return false;
	}
	/*
	 * return 'true' if any element in the LatinSquare is a zero
	 * */
	public boolean containsZero() {
		for(int[] row : latinSquare) {
			for(int num : row) {
				if(num == 0)
					return true;
			}
		}
		return false;
	}
	/*
	 * pass in one-dimension array and a value, if value exists in array
	 * */
	public boolean doesElementExist(int[] arr, int iValue) {
		boolean isTrue = false;
		for(int i = 0; i < arr.length; i++) {
			if (iValue == arr[i]) {
				isTrue = true;
			}
		}
		return isTrue;
	}
	
	/*
	 * return 'true' if every element from arr2 is in arr1
	 * */
	public boolean hasAllValues(int[] arr1, int[] arr2) {
		boolean allValues = false;
		int[] tempArr1 = arr1;
		int[] tempArr2 = arr2;
		Arrays.sort(tempArr1);
		Arrays.sort(tempArr2);
		for(int i = 0; i < tempArr1.length; i++) {
			if (tempArr1[i] == tempArr2[i]) {
				allValues = true;
			} else {
				allValues = false;
				break;
			}
		}
		return allValues;
	}
	
	
	/*
	 * return 'true' if: Each row and column doesn't contain 
	 * duplicates If each element in the first row is found in every
	 *  other row If each element in the first
	 *   column is found in every other column
	 * */
	public boolean isLatinSquare() {
		boolean completed = false;
		int row[];
		int col[];
		for (int i = 0; i < latinSquare.length - 1; i++) {
			if (hasAllValues(getRow(i), getRow(i + 1)) == false || hasAllValues(getColumn(i), getColumn(i + 1)) == false) {
				return completed;
			}
		}
		if (containsZero() == true) {
			completed = false;
		}
		
		else {
			for (int i = 0; i < latinSquare.length; i++ ) {
				row = getRow(i);
				col = getColumn(i);
				if (hasDuplicates(row) == true || hasDuplicates(col) == true) {
					completed = false;
					break;
				}
				else {
					completed = true;
					break;
				}
			}
		}
		return completed;
	}
}
