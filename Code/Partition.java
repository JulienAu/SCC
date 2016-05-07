import java.util.ArrayList;
import java.util.List;


public class Partition {
	
	private List<List<Sommet>> CFCs = new ArrayList<List<Sommet>>();

	
	
	public List<List<Sommet>> getCFCs() {
		return CFCs;
	}



	@Override
	public String toString(){
		String res ="";
		int x = 1;
		for(List<Sommet> cfc : CFCs){
			res = res + " [ CFC "+x+ " : ";
			for(Sommet sommet : cfc){
				res = res + " ; " + sommet.toString();
			}
			res = res + " ] \n";
			x++;
		}
		return res;
	}
}
