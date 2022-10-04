package Qlearning;


import business.Grille;
import gameBuilder.Manager;
import gameBuilder.Map;

public class GenererTableau{
	private static Grille grille;
	private static Manager manager;

	
	
	public static char[][] map() {
		
		
		grille = Map.buildMap();
		manager = Map.buildInitMobile(grille);
		char map [][] = new char [manager.getGrille().getLineCount()][manager.getGrille().getColumnCount()];
		
		for (int lineIndex = 0; lineIndex < manager.getGrille().getLineCount() ; lineIndex++) {
			for (int columnIndex1 = 0; columnIndex1 < manager.getGrille().getColumnCount(); columnIndex1++) {
				map[lineIndex][columnIndex1] = '.';
			}
				map[manager.getAgent().getPosition().getLine()][manager.getAgent().getPosition().getColumn()] = 'A';
				map[manager.getBac().getPosition().getLine()][manager.getBac().getPosition().getColumn()] = 'F';
				map[manager.getBacV().getPosition().getLine()][manager.getBacV().getPosition().getColumn()] = 'D';
				map[manager.getBacP().getPosition().getLine()][manager.getBacP().getPosition().getColumn()] = 'T';

				for (int i = 0; i< manager.getPlastic().size(); i++) {
					map[manager.getPlastic().get(i).getPosition().getLine()][manager.getPlastic().get(i).getPosition().getColumn()] = 'P';
				}
				for (int i = 0; i< manager.getMur().size(); i++) {
					map[manager.getMur().get(i).getPosition().getLine()][manager.getMur().get(i).getPosition().getColumn()] = 'M';
				}
				for (int i = 0; i< manager.getPapiers().size(); i++) {
					map[manager.getPapiers().get(i).getPosition().getLine()][manager.getPapiers().get(i).getPosition().getColumn()] = 'S';
				}
				for (int i = 0; i< manager.getVerre().size(); i++) {
					map[manager.getVerre().get(i).getPosition().getLine()][manager.getVerre().get(i).getPosition().getColumn()] = 'V';
				}
				
			}
		for (int lineIndex1 = 0; lineIndex1 < grille.getLineCount() ; lineIndex1++) {
			for (int columnIndex1 = 0; columnIndex1 < grille.getColumnCount(); columnIndex1++) {
				System.out.print(" " + map[lineIndex1] [columnIndex1]);
			}
			System.out.println("  ");
		}
		return map;
		
	}
	public static char[][] map2() {
		
		
		//grille = Map.buildMap();
	char map2 [][] = new char [manager.getGrille().getLineCount()][manager.getGrille().getColumnCount()];
	
	for (int lineIndex = 0; lineIndex < manager.getGrille().getLineCount() ; lineIndex++) {
		for (int columnIndex1 = 0; columnIndex1 < manager.getGrille().getColumnCount(); columnIndex1++) {
			map2[lineIndex][columnIndex1] = '.';
		}
			map2[manager.getAgent().getPosition().getLine()][manager.getAgent().getPosition().getColumn()] = 'A';
			map2[manager.getBac().getPosition().getLine()][manager.getBac().getPosition().getColumn()] = 'F';
			map2[manager.getBacV().getPosition().getLine()][manager.getBacV().getPosition().getColumn()] = 'D';
			map2[manager.getBacP().getPosition().getLine()][manager.getBacP().getPosition().getColumn()] = 'T';

			for (int i = 0; i< manager.getPlastic().size(); i++) {
				map2[manager.getPlastic().get(i).getPosition().getLine()][manager.getPlastic().get(i).getPosition().getColumn()] = 'P';
			}
			for (int i = 0; i< manager.getMur().size(); i++) {
				map2[manager.getMur().get(i).getPosition().getLine()][manager.getMur().get(i).getPosition().getColumn()] = 'M';
			}
			for (int i = 0; i< manager.getVerre().size(); i++) {
				map2[manager.getVerre().get(i).getPosition().getLine()][manager.getVerre().get(i).getPosition().getColumn()] = 'V';
			}
			for (int i = 0; i< manager.getPapiers().size(); i++) {
				map2[manager.getPapiers().get(i).getPosition().getLine()][manager.getPapiers().get(i).getPosition().getColumn()] = 'S';
			}
		}
	
	
	return map2;
	}
	
	
}
