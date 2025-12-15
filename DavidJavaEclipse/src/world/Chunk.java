package world;

import java.util.ArrayList;

public class Chunk {
	public final int col, row;
	World world;
	public ArrayList<Layer> layers=new ArrayList<>();

	public Chunk(int col, int row, World world) {
		this.world=world;
		this.col = col;
		this.row = row;
		layers.add(new Layer(world, LayerType.LANDSCAPE));
		layers.add(new Layer(world, LayerType.PLAYER));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Chunk))
			return false;
		Chunk p = (Chunk) o;
		return col == p.col && row == p.row;
	}

	@Override
	public int hashCode() {
		return 31 * col + row;
	}

	public int[][] calculatePattern() {
		int[][] finalPattern=new int[world.maxTilesHeight][world.maxTilesWidth];
		for (int i=0; i<layers.size(); i++) {
			Integer[][] pattern= layers.get(i).pattern;
			for(int r=0; r<world.maxTilesHeight;r++) {
				for(int c=0; c<world.maxTilesWidth; c++){
					if (pattern[r][c]!=null) {
						finalPattern[r][c]=pattern[r][c];
					}
				}
			}
		}
		return finalPattern;
	}
}
