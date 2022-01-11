//contains the methods to execute this program. In general, it has a method to print the current iteration, to find the number of neighbors of each cell, to make an iteration based on number of neighbors, and a clear screen and testing method.

public class Life 
{
	//creates a row and column size for the grid and two arrays, one integer, one boolean
	public final static int row = 26;
	public final static int col = 26;
	public static int[][] myNeighbors = new int[row][col];
	public static boolean[][] myGrid = new boolean[row][col]; 
	
	//methods to get the seed pattern. They access the Seed class and pass myGrid as an object parameter to be "seeded" 
	public static void seedGlider() 
	{ Seed.getGlider(myGrid); }
	public static void seedExploder() 
	{	Seed.getExploder(myGrid);	}
	public static void seedRow() 
	{	Seed.getRow(myGrid); }
	public static void seedRandom()
	{ Seed.getRandom (myGrid); }
	
	//method "gridPrint" that creates a grid by indexing through rows and columns and printing a box if true, and a space if false
	public static void gridPrint() 
	{
		for (int i = 0; i < row; i++) {
			//prints column numbers
			if (i < 10)
				System.out.print ("0" + i + " ");
			else
				System.out.print (i + " ");
			//choose whether to print white or empty box depending on t/f state of value
			for (int j = 0; j < col; j++) {
				if (myGrid[i][j])
					System.out.print('\u25A0' + " ");
				else 
					System.out.print ('\u25A1' + " ");
			}
			System.out.println ("");
		}
	}

	//method that determines the neighbors of each cell. Creates a new integer array to assign the number of neighbors to each cell
	public static void getNeighbors() 
	{
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				myNeighbors[i][j] = 0;
				//checks every neighboring sqaure around the value to see if true. If it is, then the neighbor value is incremented by 1
				if (myGrid[i-1][j-1]) 
					myNeighbors [i][j]++;
				if (myGrid[i-1][j]) 
					myNeighbors [i][j]++;
				if (myGrid[i-1][j+1]) 
					myNeighbors [i][j]++;
				if (myGrid[i][j-1]) 
					myNeighbors [i][j]++;
				if (myGrid[i][j+1]) 
					myNeighbors [i][j]++;
				if (myGrid[i+1][j-1]) 
					myNeighbors [i][j]++;
				if (myGrid[i+1][j]) 
					myNeighbors [i][j]++;
				if (myGrid[i+1][j+1]) 
					myNeighbors [i][j]++;
			}
		}
	}

	//method that determines if the the cell "lives" or "dies" for the iteration. If there are less than 2 or more than 3 neighbors, the cell dies. If a dead cell has exactly 3 neighbors, it lives. true = alive, false = dead
	public static void iterate() 
	{
		for (int i = 0; i < row-1; i++) {
			for (int j = 0; j < col-1; j++) {
				if (myNeighbors [i][j] < 2 || myNeighbors [i][j] > 3)
					myGrid[i][j] = false;
				if (myNeighbors[i][j] == 3)
					myGrid[i][j] = true;
			}
		}
	}

	//method for testing purposes to show how many measured neighbors for each cell. Simply prints another grid with ints representing how many neighbors it has
	public static void checkNeighbors() 
	{
		Life.getNeighbors();
		for (int i = 1; i < row-1; i++) {
				for (int j = 1; j < col-1; j++) {
					if ((j/25) == 1)
					System.out.println ("");
					else
					System.out.print (myNeighbors[i][j] + " ");
			}
		}
	}

	//method to clear and refresh screen
	public static void clearScreen() 
	{  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
	}  
}