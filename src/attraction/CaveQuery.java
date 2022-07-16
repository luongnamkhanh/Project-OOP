package attraction;

import java.util.ArrayList;

public class CaveQuery extends AttractionQuery {
	private String depth = "dbp:depth ?depth";
	private String length = "dbp:length ?length";
	private String discovery = "dbp:discovery ?discovery";
	private String condition = "dbo:wikiPageWikiLink dbc:Caves_of_Vietnam";
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getDiscovery() {
		return discovery;
	}
	public void setDiscovery(String discovery) {
		this.discovery = discovery;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@Override
	public String constructClause(ArrayList userChoice) {
		String construct = super.constructClause(userChoice);
		if (userChoice.get(3).equals(true))
			construct += this.getDepth()+ ";\n";
		if (userChoice.get(4).equals(true))
			construct += this.getLength()+ ";\n";
		if (userChoice.get(5).equals(true))
			construct += this.getDiscovery()+ ";\n";
		construct = "construct {\n"
				+ this.getSourceLink() + "\n"
				+ construct.substring(0, construct.length()-2) + ".\n"
				+ "}";
		return construct;
	}
	
	@Override
	public String whereClause(ArrayList userChoice) {
		String where = super.whereClause(userChoice);
		where = "where {\n"
				+this.getSourceLink() + "\n"
				+this.condition + ";\n"
				+where +".\n";
		where += this.optionalClause(userChoice) + "\n";
		where += "filter(" + this.getLabelFilter() + "&&" + this.getAbstractLabel() +")" +"\n";
		where += "}";
		return where;
	}
	
	@Override
	public String optionalClause(ArrayList userChoice) {
		String optional = super.optionalClause(userChoice);
		if (userChoice.get(3).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getDepth() + "}" + ".\n";
		if (userChoice.get(4).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getLength() + "}" + ".\n";
		if (userChoice.get(5).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getDiscovery() + "}" + ".\n";
		return optional;
	}
	
	public String constructQuery(ArrayList userChoice) {
		String prefix = "PREFIX dbo:  <http://dbpedia.org/ontology/>\r\n"
				+ "PREFIX dbp:  <http://dbpedia.org/property/>\r\n"
				+ "PREFIX dbr:  <http://dbpedia.org/resource/>\r\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
				+ "PREFIX dbc:  <http://dbpedia.org/resource/Category:>\r\n"
				+ "PREFIX geo:  <http://www.w3.org/2003/01/geo/wgs84_pos#>\r\n" ;
		
		
		String constructClause = this.constructClause(userChoice);
		String whereClause = this.whereClause(userChoice);
					
	return prefix + "\n" +constructClause + "\n" + whereClause;	
	}
	
}
