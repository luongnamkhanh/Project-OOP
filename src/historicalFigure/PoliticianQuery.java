package historicalFigure;

import java.util.ArrayList;

public class PoliticianQuery extends HistoricalFigureQuery{
	private String office = "dbp:office ?office";
	private String award = "dbp:awards ?awards";
	private String condition = "rdf:type yago:WikicatVietnamesePoliticians";
	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
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
			construct += this.getOffice()+ ";\n";
		if (userChoice.get(8).equals(true))
			construct += this.getAward()+ ";\n";
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
			optional += "optional{" + this.getSourceLink() + " " + this.getOffice() + "}" + ".\n";
		if (userChoice.get(8).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getAward() + "}" + ".\n";
		return optional;
	}
	
	public String constructQuery(ArrayList userChoice) {
		String prefix = "PREFIX dbo:  <http://dbpedia.org/ontology/>\r\n"
				+ "PREFIX dbp:  <http://dbpedia.org/property/>\r\n"
				+ "PREFIX dbr:  <http://dbpedia.org/resource/>\r\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
				+ "PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
				+ "PREFIX yago: <http://dbpedia.org/class/yago/>\r\n";
		
		String constructClause = this.constructClause(userChoice);
		String whereClause = this.whereClause(userChoice);
					
	return prefix + "\n" +constructClause + "\n" + whereClause;	
	}
}