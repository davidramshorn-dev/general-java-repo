package world;

import java.util.Random;

public class Layer {
	public LayerType type;
	public Integer[][] pattern;
	World world;
	private int counter=0;
	private int numberTiles=2;
	
	public Layer(World world, LayerType type) {
		pattern = new Integer[world.maxTilesHeight][world.maxTilesWidth];
		this.world=world;
		this.type=type;
		switch(type) {
		case LayerType.LANDSCAPE: pattern=createLandscapePattern(); break;
		case LayerType.PLAYER: break;
		case LayerType.PLANTS: break;}
	}
	
	private Integer[][] createLandscapePattern() {
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
	
	public void edit(int number,int col, int row) {
		pattern[row][col]=number;
	}
	
	private int change() {
		counter++;
		if(counter>=numberTiles) {
			counter=0;
		}
		return counter;
	}
}
