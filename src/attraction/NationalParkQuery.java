package attraction;

import java.util.ArrayList;

public class NationalParkQuery extends AttractionQuery{
	private String nearestCity = "dbo:nearestCity ?nearestCity";
	private String area = "dbo:areaTotal ?areaTotal";
	private String established = "dbp:established ?established";
	private String condition = "dbo:wikiPageWikiLink dbc:National_parks_of_Vietnam";
	public String getNearestCity() {
		return nearestCity;
	}
	public void setNearestCity(String nearestCity) {
		this.nearestCity = nearestCity;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEstablished() {
		return established;
	}
	public void setEstablished(String established) {
		this.established = established;
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
			construct += this.getNearestCity()+ ";\n";
		if (userChoice.get(4).equals(true))
			construct += this.getArea()+ ";\n";
		if (userChoice.get(5).equals(true))
			construct += this.getEstablished()+ ";\n";
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
			optional += "optional{" + this.getSourceLink() + " " + this.getNearestCity() + "}" + ".\n";
		if (userChoice.get(4).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getArea() + "}" + ".\n";
		if (userChoice.get(5).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getEstablished() + "}" + ".\n";
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
