//class that contain the hard-coded seeds. These seeds are called by the Life class which is in turn called by the runner in the Main class. The myGrid object is passed as a parameter and modified so some cells may be "alive" for the first iteration. A random seed is also available, each cell will be randomly choosen to be alive or dead as the seed.

import java.util.Random;
public class Seed
{
	public final static int row = 26;
	public final static int col = 26;
	public static boolean[][] myArray = new boolean[row][col]; 
	public static Random random = new Random();

	public static void getGlider(boolean[][] myArray)
	{	myArray[8][16] = true;
		myArray[9][17] = true;
		myArray[10][15] = true;
		myArray[10][16] = true;
		myArray[10][17] = true;	}

	public static void getExploder(boolean[][] myArray)
	{	myArray[11][11] = true;
		myArray[12][11] = true;
		myArray[13][11] = true;
		myArray[14][11] = true;
		myArray[15][11] = true;
		myArray[11][13] = true;
		myArray[15][13] = true; 
		myArray[11][15] = true;
		myArray[12][15] = true;
		myArray[13][15] = true;
		myArray[14][15] = true;
		myArray[15][15] = true; }

	public static void getRow(boolean[][] myArray)
	{	myArray[13][8] = true;
		myArray[13][9] = true;
		myArray[13][10] = true;
		myArray[13][11] = true;
		myArray[13][12] = true;
		myArray[13][13] = true;
		myArray[13][14] = true;
		myArray[13][15] = true;
		myArray[13][16] = true;
		myArray[13][17] = true; }

	public static void getRandom(boolean[][] myArray) {
		for (int i = 0; i < row-1; i++) {
			for (int j = 0; j < col-1; j++) {
   			myArray[i][j] = random.nextBoolean();
			}
		}
	}
}