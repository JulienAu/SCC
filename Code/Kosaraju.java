import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Kosaraju {

	private Deque<Sommet> P = new LinkedList<Sommet>();
	private List<Sommet> graph = new ArrayList<Sommet>();
	private int num = 1;
	private Partition partition = new Partition();


	public Kosaraju(List<Sommet> graph){
		this.graph=graph;
	}

	public Partition getPartition() {
		return partition;
	}


	public void kosaraju(){
		for(Sommet v : graph){
			if(v.getNum() == 0){
				DFS(v);
			}
		}
		Transpose(graph);
		while (!P.isEmpty()){
			List<Sommet> CFC = new ArrayList<Sommet>();
			Sommet v = P.pop();
			if (!v.isDans_CFC()){
				DFS2(v , CFC);
				partition.getCFCs().add(CFC);
			}
		}
	}



	private void Transpose(List<Sommet> graph2) {
		for(Sommet v : graph2){
			for(Sommet voisin : v.getVoisins()){
				voisin.getVoisinsTranspose().add(v);
			}
		}
		for (Sommet v : graph2){
			v.setVoisins(v.getVoisinsTranspose());
		}
	}


	private void DFS(Sommet v) {
		v.setNum(this.num);
		this.num +=1;
		for(Sommet w : v.getVoisins()){
			if(w.getNum() == 0){
				DFS(w);
			} 
		}
		P.push(v);
		v.setDans_P(true);
	}


	private void DFS2(Sommet v, List<Sommet> CFC) {
		CFC.add(v);
		v.setDans_CFC(true);
		for(Sommet w : v.getVoisins()){
			if(!w.isDans_CFC()){
					DFS2(w , CFC);
				} 
			}
	}

	@SuppressWarnings("unused")
	private void removeGraph(List<Sommet> CFC){
		for(Sommet v : graph){
			for(Sommet voisin : CFC){
				if(v.getVoisins().contains(voisin)){
					v.getVoisins().remove(voisin);
				}
			}
		}
		graph.removeAll(CFC);
	}


}
