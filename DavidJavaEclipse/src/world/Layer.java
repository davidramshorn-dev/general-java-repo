package world;

import java.util.Random;

public class Layer {
	public Integer[][] pattern;
	World world;
	private int counter=0;
	private int numberTiles=2;
	
	public Layer(World world) {
		this.world=world;
		pattern=createTilePattern();
	}
	
	private Integer[][] createTilePattern() {
		Integer [][] pattern = new Integer[world.maxTilesHeight][world.maxTilesWidth];
		for (int row = 0; row < world.maxTilesHeight; row++) {
			for (int col = 0; col < world.maxTilesWidth; col++) {
				
				if (col==world.maxTilesWidth-1 && world.maxTilesWidth%2==0) {
					change();
				} //damit Schachbrettmuster entsteht
				
				pattern[row][col] = change();
				
				if (pattern[row][col]==0) {
					Random random=new Random();
					if (random.nextInt(5)==1) {
						pattern[row][col]=1;
					}
				}
				
			}
		}
		return pattern;
	}
	
	private int change() {
		counter++;
		if(counter>=numberTiles) {
			counter=0;
		}
		return counter;
	}
}
