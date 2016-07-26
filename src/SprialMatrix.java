import java.util.ArrayList;
import java.util.List;


public class SprialMatrix {
	
	public static final List<ArrayList<Integer>> spiralMatrix = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> result;
	
	public static void row(int row, int columnStart, int columnStop){
		
		if(columnStart<columnStop){
			
			//go forward
			for(int i=columnStart; i<=columnStop; i++){
				result.add(spiralMatrix.get(row).get(i));
			}
		}else if(columnStop<columnStart){
			
			//go backwards
			for(int i=columnStart; i>=columnStop; i--){
				result.add(spiralMatrix.get(row).get(i));
			}
		}
	}
	
	public static void column(int column, int rowStart, int rowStop){
		
		if(rowStart<rowStop){
			
			//go down
			for(int i=rowStart; i<=rowStop; i++){
				
				result.add(spiralMatrix.get(i).get(column));
			}
		}else if(rowStop<rowStart){
			
			//go up
			for(int i=rowStart; i<=rowStop; i--){
				
				result.add(spiralMatrix.get(i).get(column));
			}
		}
	}

	public static void main(String[] args) {
		
		result = new ArrayList<Integer>();
		/*
		 * Sample Matrix
		 * 
		 *  [1,2,3]
		 *  [4,5,6]
		 *  [7,8,9]
		 *  
		 *  Output should be 
		 *  
		 *  [1,2,3,6,9,8,7,4,5]
		 */
		
		//make the example matrix
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=1; i<4; i++){
			temp.add(i);
		}
		
		spiralMatrix.add(temp);
		
		temp = new ArrayList<Integer>();
		for(int i=4; i<7; i++){
			temp.add(i);
		}
		
		spiralMatrix.add(temp);
		
		temp = new ArrayList<Integer>();
		for(int i=7; i<10; i++){
			temp.add(i);
		}
		
		spiralMatrix.add(temp);
		
		//-----------------------------------------------------------------------//
		
	
		int rowStart = 0;
		int rowStop = spiralMatrix.size()-1;
		
		int columnStart = 0;
		int columnStop = spiralMatrix.get(0).size()-1;
		
		while((columnStart!=columnStop) || (rowStart!=rowStop)){
			
			//go left
			row(rowStart, columnStart, columnStop);
			rowStart ++;
			//go down
			column(columnStop, rowStart, rowStop);
			//rowStart ++;
			columnStop --;
			//go right
			row(rowStop, columnStop, columnStart);
			rowStop --;
			//go up
			column(columnStart, rowStop, rowStart);
 			columnStart ++;
		}
		
		//for square matricies
		if((columnStart==columnStop)){
			result.add(spiralMatrix.get(rowStart).get(rowStop));
		}
		
		
		for(Integer i : result){
			
			System.out.print(i + "");
		}
		
	}

}
