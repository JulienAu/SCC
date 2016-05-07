import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Tarjan {
	
	private List<Sommet> graph = new ArrayList<Sommet>();
	private int num = 1;
	private Stack<Sommet> P = new Stack<Sommet>();
	private Partition partition = new Partition();
	
	public Tarjan(){}
	
	public Tarjan(List<Sommet> graph){
		this.graph=graph;
	}


	
	public List<Sommet> getGraph() {
		return graph;
	}



	public void setGraph(List<Sommet> graph) {
		this.graph = graph;
	}


	public Partition getPartition() {
		return partition;
	}
	

	public void AlgoTarjan(){
		for(Sommet v : this.graph){
			if(v.getNum()  == 0){
				parcours(v);
			}
		}
		
	}
	
	public void parcours(Sommet v){
		v.setNum(this.num);
		v.setNumAccessible(this.num);
		this.num +=1;
		P.push(v);
		v.setDans_P(true);
		for(Sommet w : v.getVoisins()){
			if(w.getNum() == 0){
				parcours(w);
				v.setNumAccessible(Math.min(v.getNumAccessible(), w.getNumAccessible()));
			} else if (w.isDans_P()){
				v.setNumAccessible(Math.min(v.getNumAccessible(),w.getNum/*Accessible*/()));
			}
		}
		if(v.getNumAccessible() == v.getNum()){
			List<Sommet> CFC = new ArrayList<Sommet>();
			Sommet w = P.pop();
			w.setDans_P(false);
			CFC.add(w);
			while(!w.equals(v)){
				w = P.pop();
				w.setDans_P(false);
				CFC.add(w);
			}
			partition.getCFCs().add(CFC);
			}
	}
	
	
	
}
