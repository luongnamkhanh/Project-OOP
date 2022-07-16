package importData;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

import java.io.FileOutputStream;


@SuppressWarnings("deprecation")
public class HelloRDFWorld {

	public void importData(String inputQuery, String filename) {
		Query query = QueryFactory.create(inputQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql",query);
		Model results = qexec.execConstruct();
		try {
			results.write(new FileOutputStream(filename), "TURTLE");
			System.out.println("success...");    
		}catch (Exception e) {System.out.println(e);} 
	}

}

