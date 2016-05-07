import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class main {


	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		/**Ouverture des Printers**/
		PrintWriter printerGabow = new PrintWriter("outGabow.txt");
		PrintWriter printerKosaraju = new PrintWriter("outKosaraju.txt");
		PrintWriter printerTarjan = new PrintWriter("outTarjan.txt");

		ArrayList<String> args2 = readFile(args[0]);

		/** Creation du Graph , provenant du Generateur **/
		for (String s: args2) {
			int sizeGraph=0;
			for(int j = 0 ; j<1;j++){

				int arrete = 0;
				List<Sommet> graph = new ArrayList<Sommet>();
				String [] str = s.split("/");

				/** Creation des sommets du graph **/
				for(String sommet : str){
					graph.add(new Sommet(sommet.split("->")[0]));
				}

				/** Creation des arretes du graph **/
				for(String voisins : str){
					String [] str2 = voisins.split("->");
					if(str2.length > 1){
						String [] str3 = str2[1].split(",");
						for(int i=0 ; i < str3.length ; i++ ){
							arrete++;
							int NumSommet = Integer.parseInt(str2[0]);
							int NumVoisin = Integer.parseInt(str3[i]);
							graph.get(NumSommet-1).getVoisins().add(graph.get(NumVoisin-1));
						}
					}
				} 

				/** LANCE TARJAN **/
				
					Tarjan tarjan = new Tarjan(graph);
					long startTarjan = System.nanoTime();
					tarjan.AlgoTarjan();
					long endTarjan = System.nanoTime();
					j=0;
					long sommeTarjan = (endTarjan-startTarjan);
				 
				

				/** LANCE KOSARAJU **/
			
				Kosaraju kosaraju = new Kosaraju(graph);
				long startKosaraju = System.nanoTime();
				kosaraju.kosaraju();
				long endKosaraju = System.nanoTime();
				long sommeKosaraju = (endKosaraju-startKosaraju);
				 


				/** LANCE GABOW **/
				
				Gabow gabow = new Gabow(graph);
				long startGabow = System.nanoTime();
				gabow.gabow();
				long endGabow = System.nanoTime();
				long sommeGabow = (endGabow-startGabow);
				 

				sizeGraph=(graph.size()+arrete);
				
				/** Print Resultat Temps**/
				printerGabow.println(sommeGabow+" "+sizeGraph);
				printerTarjan.println(sommeTarjan+" "+sizeGraph);
				printerKosaraju.println(sommeKosaraju+" "+sizeGraph);
				
				/**Print Resultat Partition**/
				//printer.println(gabow.getPartition());
			}


			


		}
		/**Fermeture des Printer**/
		printerGabow.close();
		printerKosaraju.close();
		printerTarjan.close();
	}

	
	
	private static ArrayList<String> readFile(String pathname) {
		ArrayList<String> questions = new ArrayList<String>();
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(pathname));
			while((line = reader.readLine()) != null){
				questions.add(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

}
