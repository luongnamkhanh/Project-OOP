package historicalFigure;

import java.util.ArrayList;

public class KingQuery extends HistoricalFigureQuery{
	private String eraDate = "dbp:eraDates ?eraDate";
	private String eraName = "dbp:eraName ?eraName";
	private String condition = "dbo:wikiPageWikiLink dbr:List_of_monarchs_of_Vietnam";
	
	
	public String getEraDate() {
		return eraDate;
	}
	public void setEraDate(String eraDate) {
		this.eraDate = eraDate;
	}
	public String getEraName() {
		return eraName;
	}
	public void setEraName(String eraName) {
		this.eraName = eraName;
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
		if (userChoice.get(7).equals(true))
			construct += this.getEraDate()+ ";\n";
		if (userChoice.get(8).equals(true))
			construct += this.getEraName()+ ";\n";
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
		where += "filter(" + this.getLabelFilter() + ")" +"\n";
		where += "}";
		return where;
	}
	
	@Override
	public String optionalClause(ArrayList userChoice) {
		String optional = super.optionalClause(userChoice);
		if (userChoice.get(7).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getEraDate() + "}" + ".\n";
		if (userChoice.get(8).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getEraName() + "}" + ".\n";
		return optional;
	}
	
	public String constructQuery(ArrayList userChoice) {
		String prefix = "PREFIX dbo:  <http://dbpedia.org/ontology/>\r\n"
				+ "PREFIX dbp:  <http://dbpedia.org/property/>\r\n"
				+ "PREFIX dbr:  <http://dbpedia.org/resource/>\r\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n";
		
		
		String constructClause = this.constructClause(userChoice);
		String whereClause = this.whereClause(userChoice);
					
	return prefix + "\n" +constructClause + "\n" + whereClause;	
	}
}
