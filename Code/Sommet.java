import java.util.ArrayList;

public class Sommet {
	
	private String name;
	private int num;
	private int numAccessible;
	private ArrayList<Sommet> voisins = new ArrayList<Sommet>();
	private ArrayList<Sommet> voisinsTranspose = new ArrayList<Sommet>();
	private boolean dans_P;
	private boolean dans_CFC = false;
	
	public Sommet(String name){
		this.name=name;
		this.num=0;
		this.dans_P = false;
	}
	
	public Sommet( String name, Sommet... voisins)
	{
		this.name=name;
		  for(int i=0;i<voisins.length;++i)
		  {
		     this.voisins.add(voisins[i]);
		  }
			this.num=0;
			this.dans_P = false;
		}
	
	public Sommet(ArrayList<Sommet> voisins , String name){
		this.name=name;
		this.num=0;
		this.voisins=voisins;
		this.dans_P = false;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList<Sommet> getVoisinsTranspose() {
		return voisinsTranspose;
	}

	public void setVoisinsTransposé(ArrayList<Sommet> voisinsTransposé) {
		this.voisinsTranspose = voisinsTransposé;
	}

	public int getNumAccessible() {
		return numAccessible;
	}

	public void setNumAccessible(int numAccessible) {
		this.numAccessible = numAccessible;
	}

	public ArrayList<Sommet> getVoisins() {
		return voisins;
	}

	public void setVoisins(ArrayList<Sommet> voisins) {
		this.voisins = voisins;
	}

	public boolean isDans_P() {
		return dans_P;
	}

	public void setDans_P(boolean dans_P) {
		this.dans_P = dans_P;
	}
	

	public boolean isDans_CFC() {
		return dans_CFC;
	}

	public void setDans_CFC(boolean dans_CFC) {
		this.dans_CFC = dans_CFC;
	}

	@Override
	public String toString(){
		String res = "( Sommet "+this.name+")";
		return res;
	}
	

}
