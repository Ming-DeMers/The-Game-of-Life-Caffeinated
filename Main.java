/*The Game of Life invented by John Conway is a simple and elementary way to possibly model population growth. In actuality, it prints pretty patterns. The rules are simple. Every cell is either "alive" or "dead" and has 8 neighbors, the cells directly touching it. On each iteration, a cell may "die" if are too little or too many neightbors, and a cell may be "born" if there are just the right amount of neighbors. 

This is the runner class that reaches into the other classes. It contains the user interactions and handling of the outputs. The effect of iterations is limited by the refresh posibilities of the IDE. The pattern is limited if the pattern goes outside of the 25x25 grid.

Ming DeMers 10/12/2020 */

import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) {
		//intiates a class and variable for use
		Scanner input = new Scanner(System.in);
		int x = 0;

		//prints title
		System.out.println("______________________\nThe Game of Life \nver 0.4.5 beta\nMing DeMers | 01/10/20 \n______________________\n");

		//asks and accepts a certain seed. invokes the corresponding method in Life and Seed class. If seed is not recognized, program terminates
		System.out.println("What Seed? (glider, exploder, row, or random)");
		String mySeed = input.nextLine();
		if (mySeed.equals ("glider"))
			Life.seedGlider();
			else if (mySeed.equals ("exploder"))
				Life.seedExploder();
				else if (mySeed.equals ("row"))
					Life.seedRow();
					else if (mySeed.equals ("random"))
						Life.seedRandom();
						else 
						{	Life.clearScreen(); 
							System.out.println ("ERROR 569-E: NO SEED FOUND");
							System.out.println ("Program Terminated.");
							System.exit(0);	}
						
		//prints a title and calls the method from the life class to print the seed
		System.out.println ("\nThe \"" + mySeed + "\" seed:");
		Life.gridPrint();
	
		//asks for user to input desired iterations
		System.out.println ("\nHow many iterations?");
		int iteration = input.nextInt();
			//envokes methods from Life class to create the next iterations. reapeats x times
		while (x <= iteration) {
			Life.clearScreen();
			Life.getNeighbors();
			Life.iterate ();
			Life.gridPrint();
			System.out.println ("\nIterations:" + x);			
			try {Thread.sleep(300);}
			catch(InterruptedException e){System.out.println("paused");}
			x++;
		}
		//program termination message
		System.out.println ("Program Terminated.");			
	}
}