package IHM;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import business.Block;
import business.Grille;
import config.Constente;
import engime.Agent;
import engime.Bac;
import engime.BacPapier;
import engime.BacVerre;
import engime.Mur;
import engime.Papier;
import engime.Plastic;
import engime.Verre;



public class PaintStrategy {
	
	public void paint(Grille map, Graphics graphics) {
		int blockSize = Constente.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(Color.LIGHT_GRAY);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}
			}
		}
	}
	public void paint(Agent agent, Graphics graphics) {
		Block position = agent.getPosition();
		int blockSize = Constente.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image img1 = Toolkit.getDefaultToolkit().getImage("agent.png");
		graphics.drawImage(img1, x*blockSize, y*blockSize,blockSize,blockSize, null);

	}
	public void paint(Papier paper, Graphics graphics) {
		Block position = paper.getPosition();
		int blockSize = Constente.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		Image img2 = Toolkit.getDefaultToolkit().getImage("plastique.png");
		graphics.drawImage(img2, x*blockSize, y*blockSize,blockSize,blockSize, null);
	}

	public void paint(Bac bac, Graphics graphics) {
		Block position = bac.getPosition();
		int blockSize = Constente.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image img4 = Toolkit.getDefaultToolkit().getImage("yellow-color.jpg");
		graphics.drawImage(img4, x*blockSize, y*blockSize,blockSize,blockSize, null);

	}
	public void paintV(BacVerre bacV, Graphics graphics) {
		Block position = bacV.getPosition();
		int blockSize = Constente.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image img4 = Toolkit.getDefaultToolkit().getImage("verre.png");
		graphics.drawImage(img4, x*blockSize, y*blockSize,blockSize,blockSize, null);

	}
	public void paintP(BacPapier bacP, Graphics graphics) {
		Block position = bacP.getPosition();
		int blockSize = Constente.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image img4 = Toolkit.getDefaultToolkit().getImage("papier.png");
		graphics.drawImage(img4, x*blockSize, y*blockSize,blockSize,blockSize, null);

	}
	void paint(ArrayList<Mur> murs , Graphics graphics) {
		for (Mur murr : murs) {
			Block position = murr.getPosition();
			int blockSize = Constente.BLOCK_SIZE;

			int y = position.getLine();
			int x = position.getColumn();

			//graphics.setColor(Color.black);
			//graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
			
			Image img3 = Toolkit.getDefaultToolkit().getImage("mur.jpg");
			graphics.drawImage(img3, x*blockSize, y*blockSize,blockSize,blockSize, null);
		}
	}
	
	void paintP(ArrayList<Plastic> plastics , Graphics graphics) {
		for (Plastic plastic : plastics) {
			Block position = plastic.getPosition();
			int blockSize = Constente.BLOCK_SIZE;

			int y = position.getLine();
			int x = position.getColumn();
			
			Image img2 = Toolkit.getDefaultToolkit().getImage("plastique.png");
			graphics.drawImage(img2, x*blockSize, y*blockSize,blockSize,blockSize, null);
		}
	}
	
	void paintV(ArrayList<Verre> verres , Graphics graphics) {
		for (Verre verre : verres) {
			Block position = verre.getPosition();
			int blockSize = Constente.BLOCK_SIZE;

			int y = position.getLine();
			int x = position.getColumn();
			
			Image img2 = Toolkit.getDefaultToolkit().getImage("verre.jpg");
			graphics.drawImage(img2, x*blockSize, y*blockSize,blockSize,blockSize, null);
		}
	}
	void paintPa(ArrayList<Papier> papiers , Graphics graphics) {
		for (Papier papier : papiers) {
			Block position = papier.getPosition();
			int blockSize = Constente.BLOCK_SIZE;

			int y = position.getLine();
			int x = position.getColumn();
			
			Image img2 = Toolkit.getDefaultToolkit().getImage("T.jpg");
			graphics.drawImage(img2, x*blockSize, y*blockSize,blockSize,blockSize, null);
		}
	}

	}
