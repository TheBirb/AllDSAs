package jan2021.mysurname;

import DSAdefault.graphs.StdOut;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MineMyPaintBFS {
	// TO DO: complete everything as needed. 
	/*
	 * An object MineMyPaint computes the regions in an image and retrieves the
	 * coordinates of the pixels that belong to each region. The image is given in
	 * the constructor
	 */
	private int[][] img;
	char[][] reg;
	char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private boolean[][] marked;
	private int nregions;

	public MineMyPaintBFS(int[][] img) {

		this.img = img;
		init();
	}
	public void init(){
		marked= new boolean[img.length][img.length];
		reg=new char[img.length][img.length];
		for(int i=0; i<img.length; i++){
			for(int j=0; j<img.length; j++){
				if(!marked[i][j]){
					bfs(i,j);
					nregions++;
				}
			}
		}
	}
	public void bfs(int row, int col){
		LinkedList<Coordinates> queue= new LinkedList<Coordinates>();
		queue.add(0,new Coordinates(row,col));
		int region=img[row][col];
		marked[row][col]=true;
		while(!queue.isEmpty()){
			Coordinates actualv=queue.removeLast();
			reg[actualv.row][actualv.col]=alph[nregions];
			//UPPER NEIGHBOUR
			if(actualv.row-1!=-1){
				int checkingRow=actualv.row-1;
				int checkingCol=actualv.col;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//LOWER NEIGHBOUR
			if(actualv.row+1!=img.length){
				int checkingRow=actualv.row+1;
				int checkingCol=actualv.col;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//RIGHT NEIGHBOUR
			if(actualv.col+1!=img.length){
				int checkingRow=actualv.row;
				int checkingCol=actualv.col+1;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//LEFT NEIGHBOUR
			if(actualv.col-1!=-1){
				int checkingRow=actualv.row;
				int checkingCol=actualv.col-1;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
		}
	}
	public int regions() {// returns the number of regions in img
		return nregions;
	}


	public char regionOf(int row, int column) {
		// Precondition: row and column are valid coordinates of a pixed in the image
		// this method returns the region that the pixel belongs to
		return reg[row][column];
	}

	/* This method returns the list of regions connected to the region 
	 * that the pixel is located */
	public List<Character> connectedRegionsTo(int row, int column) {
		marked= new boolean[img.length][img.length];
		List<Character> ree =bfsConnected(reg[row][column],row,column);
		return ree;
	}
	public List<Character> bfsConnected(char region, int row, int col){
		LinkedList<Character> list= new LinkedList<Character>();
		LinkedList<Coordinates> queue= new LinkedList<Coordinates>();
		queue.add(0,new Coordinates(row,col));
		marked[row][col]=true;
		while(!queue.isEmpty()){
			Coordinates actualv=queue.removeLast();
			//UPPER NEIGHBOUR
			if(actualv.row-1!=-1){
				int checkingRow=actualv.row-1;
				int checkingCol=actualv.col;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region!=reg[checkingRow][checkingCol]){
						if(!list.contains(reg[checkingRow][checkingCol])){
							list.add(0,reg[checkingRow][checkingCol]);
						}
					}else{
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//LOWER NEIGHBOUR
			if(actualv.row+1!=img.length){
				int checkingRow=actualv.row+1;
				int checkingCol=actualv.col;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region!=reg[checkingRow][checkingCol]){
						if(!list.contains(reg[checkingRow][checkingCol])){
							list.add(0,reg[checkingRow][checkingCol]);
						}
					}else{
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//RIGHT NEIGHBOUR
			if(actualv.col+1!=img.length){
				int checkingRow=actualv.row;
				int checkingCol=actualv.col+1;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region!=reg[checkingRow][checkingCol]){
						if(!list.contains(reg[checkingRow][checkingCol])){
							list.add(0,reg[checkingRow][checkingCol]);
						}
					}else{
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//LEFT NEIGHBOUR
			if(actualv.col-1!=-1){
				int checkingRow=actualv.row;
				int checkingCol=actualv.col-1;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region!=reg[checkingRow][checkingCol]){
						if(!list.contains(reg[checkingRow][checkingCol])){
							list.add(0,reg[checkingRow][checkingCol]);
						}
					}else{
						marked[checkingRow][checkingCol]=true;
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
		}
		return list;
	}

	public List<Coordinates> pixelsIn(char rgn) {
		// Precondition: rgn is the char representing one of the regions of the image
		// This method returns the list of pixels in a region
		int x=0;
		int y=0;
		List<Coordinates> allCoords = null;
		boolean found=false;
		for(int i=0; i<reg.length; i++){
			for(int j=0; i<reg.length; j++){
				if(reg[i][j]==rgn){
					x=i;
					y=j;
					found=true;
					break;
				}
			}
			if(found){
				break;
			}
		}
		if(!found){
			System.out.println("there is no such region");
		}else{
			marked= new boolean[img.length][img.length];
			allCoords = coordinatesInRegbybfs(x,y);
		}

		return allCoords;
	}
	public List<Coordinates> coordinatesInRegbybfs(int row, int col){
		LinkedList<Coordinates> result= new LinkedList<Coordinates>();
		LinkedList<Coordinates> queue= new LinkedList<Coordinates>();
		queue.add(0,new Coordinates(row,col));
		result.add(new Coordinates(row,col));
		int region=img[row][col];
		marked[row][col]=true;
		while(!queue.isEmpty()){
			Coordinates actualv=queue.removeLast();
			//UPPER NEIGHBOUR
			if(actualv.row-1!=-1){
				int checkingRow=actualv.row-1;
				int checkingCol=actualv.col;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						result.add(new Coordinates(checkingRow,checkingCol));
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//LOWER NEIGHBOUR
			if(actualv.row+1!=img.length){
				int checkingRow=actualv.row+1;
				int checkingCol=actualv.col;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						result.add(new Coordinates(checkingRow,checkingCol));
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//RIGHT NEIGHBOUR
			if(actualv.col+1!=img.length){
				int checkingRow=actualv.row;
				int checkingCol=actualv.col+1;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						result.add(new Coordinates(checkingRow,checkingCol));
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
			//LEFT NEIGHBOUR
			if(actualv.col-1!=-1){
				int checkingRow=actualv.row;
				int checkingCol=actualv.col-1;
				//check
				if(!marked[checkingRow][checkingCol]){
					if(region==img[checkingRow][checkingCol]){
						marked[checkingRow][checkingCol]=true;
						result.add(new Coordinates(checkingRow,checkingCol));
						queue.add(0,new Coordinates(checkingRow, checkingCol));
					}
				}
			}
		}
		return result;
	}
	public static class Coordinates {
		public Coordinates discoveredBy=null;
		public final int row;
		public final int col;
		public Coordinates(int row, int column) {
			this.row = row;
			this.col = column;
		}
		public String toString(){
			String res="("+row+","+col+")";
			return res;
		}
	}


	public static void main(String[] args) {

		int[][] image = {
				{1, 1, 1, 1, 3},
				{1, 2, 1, 3, 3},
				{1, 1, 1, 3, 3},
				{1, 2, 2, 3, 3},
				{3, 3, 3, 2, 2}};

		MineMyPaintBFS m= new MineMyPaintBFS(image);
		System.out.println(m.regions());
		System.out.println(m.regionOf(0,4));
		System.out.println(m.connectedRegionsTo(0,0));
		System.out.println(m.pixelsIn('a'));

	}

}
