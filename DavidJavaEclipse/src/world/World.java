package world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;

public class World {
	public int maxTilesWidth = 9;
	public int maxTilesHeight = 9;
	public ArrayList<Chunk> world=new ArrayList<>(); //view Koordinate, als Schlüsel zu den Mustern
	
	public int viewCol=0;
	public int viewRow=0;

	GamePanel panel;
	private BufferedImage grassBright, grassDark;

	public World(GamePanel panel) {
		this.panel = panel;
		
		maxTilesHeight = panel.maxScreenRow;
		maxTilesWidth = panel.maxScreenCol;
		
		if (maxTilesWidth%2==0) {
			maxTilesWidth++;
		} //damit Schachbrettmuster entsteht
		
		grassBright = loadImage("/grassLight.png");
		grassDark = loadImage("/grassDark.png");
	}

	private BufferedImage loadImage(String s) {
		try {
			return ImageIO.read(getClass().getResource(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void draw(Graphics2D g2) {
		Chunk chunk = new Chunk(viewCol, viewRow, this);
		
		if (!world.contains(chunk)) {
			world.add(chunk);
		}
		else {
			chunk=world.get(world.indexOf(chunk));
		}
		
		int[][] pattern = chunk.calculatePattern(); //selects the proper pattern
		for (int row = 0; row < maxTilesHeight; row++) {
			for (int col = 0; col < maxTilesWidth; col++) {
				if (pattern[row][col] == 0) {
					g2.drawImage(grassBright, col*panel.tileSize, row*panel.tileSize, panel.tileSize, panel.tileSize, null);
				} else {
					g2.drawImage(grassDark, col*panel.tileSize, row*panel.tileSize, panel.tileSize, panel.tileSize, null);
				}
			}
		}
	}

	public void update() {
		outsideView(panel.player);

	}

	private void outsideView(Player player) {
		if (player.x > panel.maxScreenCol*panel.tileSize) {
			player.x=-panel.tileSize;
			viewCol++;
			printViewPosition();
		}
		if (player.x < -panel.tileSize) {
			player.x=panel.maxScreenCol*panel.tileSize;
			viewCol--;
			printViewPosition();
		}
		if (player.y > panel.maxScreenRow*panel.tileSize) {
			player.y=-panel.tileSize;
			viewRow++;
			printViewPosition();
		}
		if (player.y < -panel.tileSize) {
			player.y=panel.maxScreenRow*panel.tileSize;
			viewRow--;
			printViewPosition();
		}
	}

	private void printViewPosition() {
		System.out.println("Current View: "+ viewCol+ " / "+ viewRow);
		
	}

}
