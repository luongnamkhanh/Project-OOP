package event;

import java.util.ArrayList;

public class BattleQuery extends EventQuery {
	private String date = "dbo:date ?date";
	private String place = "dbo:place ?place";
	private String combatant = "dbo:combatant ?combatant";
	private String result = "dbo:result ?result";
	private String condition = "dbo:wikiPageWikiLink dbc:Vietnamese_independence_movement";
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCombatant() {
		return combatant;
	}

	public void setCombatant(String combatant) {
		this.combatant = combatant;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
		if (userChoice.get(0).equals(true))
			construct += this.getDate()+ ";\n";
		if (userChoice.get(1).equals(true))
			construct += this.getPlace()+ ";\n";
		if (userChoice.get(2).equals(true))
			construct += this.getCombatant()+ ";\n";
		if (userChoice.get(3).equals(true))
			construct += this.getResult()+ ";\n";
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
		if (userChoice.get(0).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getDate() + "}" + ".\n";
		if (userChoice.get(1).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getPlace() + "}" + ".\n";
		if (userChoice.get(2).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getCombatant() + "}" + ".\n";
		if (userChoice.get(3).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getResult() + "}" + ".\n";
		return optional;
	}
	
	public String constructQuery(ArrayList userChoice) {
		String prefix = "PREFIX dbo:  <http://dbpedia.org/ontology/>\r\n"
				+ "PREFIX dbp:  <http://dbpedia.org/property/>\r\n"
				+ "PREFIX dbr:  <http://dbpedia.org/resource/>\r\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
				+ "PREFIX dbc:  <http://dbpedia.org/resource/Category:>\r\n";
		
		
		String constructClause = this.constructClause(userChoice);
		String whereClause = this.whereClause(userChoice);
					
	return prefix + "\n" +constructClause + "\n" + whereClause;	
	}
}
