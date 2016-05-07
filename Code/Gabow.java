import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Gabow {

	private List<Sommet> graph = new ArrayList<Sommet>();
	private int num = 1;
	private Stack<Sommet> P = new Stack<Sommet>();
	private Stack<Sommet> S = new Stack<Sommet>();
	private Partition partition = new Partition();

	public Gabow(){}

	public Gabow(List<Sommet> graph){
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


	public void gabow(){
		for(Sommet v : this.graph){
			if(v.getNum()  == 0){
				parcours(v);
			}
		}

	}

	public void parcours(Sommet v){
		v.setNum(this.num);
		this.num +=1;
		P.push(v);
		S.push(v);
		v.setDans_P(true);
		for(Sommet w : v.getVoisins()){
			if (w.getNum() == 0){
				parcours(w);
			} else if(!w.isDans_CFC()){
				while(S.peek().getNum() > w.getNum()){
					S.pop();				
				}
			} 
		}
		if(v.equals(S.peek())){
			List<Sommet> CFC = new ArrayList<Sommet>();
			Sommet w = P.pop();
			while(!v.equals(w)){
				CFC.add(w);
				w.setDans_CFC(true);
				w = P.pop();
				w.setDans_P(false);
			}
			CFC.add(v);
			v.setDans_CFC(true);
			v.setDans_P(false);
			partition.getCFCs().add(CFC);
			S.pop();
		}

	}



}
