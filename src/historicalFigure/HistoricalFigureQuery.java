package historicalFigure;


import java.util.ArrayList;

import tourism.TourismQuery;

public class HistoricalFigureQuery extends TourismQuery{
	private String birthName = "dbp:fullName ?fullName";
	private String birthDate = "dbp:birthDate ?birthDate";
	private String deathDate = "dbp:deathDate ?deathDate";
	private String birthPlace = "dbp:birthPlace ?birthPlace";
	private String parents = "dbp:father ?father;\r\n" + "dbp:mother ?mother";
	private String spouses = "dbp:spouse ?spouse";
	private String children = "dbo:child ?child";

	public String getBirthName() {
		return birthName;
	}
	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}
	public String getParents() {
		return parents;
	}
	public void setParents(String parents) {
		this.parents = parents;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getSpouses() {
		return spouses;
	}
	public void setSpouses(String spouses) {
		this.spouses = spouses;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	@Override
	public String constructClause(ArrayList userChoice) {
		String construct = super.constructClause(userChoice);
		construct = construct + "\n"
				+ this.getName() + ";\n";
		if (userChoice.get(0).equals(true))
			construct += this.getBirthName() + ";\n";
		if (userChoice.get(1).equals(true))
			construct += this.getBirthDate() + ";\n";
		if (userChoice.get(2).equals(true))
			construct += this.getDeathDate() + ";\n";
		if (userChoice.get(3).equals(true))		
			construct += this.getBirthPlace() + ";\n";
		if (userChoice.get(4).equals(true))			
			construct += this.getParents() + ";\n";
		if (userChoice.get(5).equals(true))
			construct += this.getSpouses() + ";\n";
		if (userChoice.get(6).equals(true))
			construct += this.getChildren()+ ";\n";
		return construct;
	}
	
	@Override
	public String whereClause(ArrayList userChoice) {
		String where = super.whereClause(userChoice);
		where = where + "\n"
				+ this.getName();
		return where;
	}
	
	@Override
	public String optionalClause(ArrayList userChoice) {
		String optional = super.optionalClause(userChoice);
		optional = optional + "\n";
		if (userChoice.get(0).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getBirthName() + "}" + ".\n";
		if (userChoice.get(1).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getBirthDate() + "}" + ".\n";
		if (userChoice.get(2).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getDeathDate() + "}" + ".\n";
		if (userChoice.get(3).equals(true))		
			optional += "optional{" + this.getSourceLink() + " " + this.getBirthPlace() + "}" + ".\n";
		if (userChoice.get(4).equals(true))			
			optional += "optional{" + this.getSourceLink() + " " + this.getParents() + "}" + ".\n";
		if (userChoice.get(5).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getSpouses() + "}" + ".\n";
		if (userChoice.get(6).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getChildren()+ "}" + ".\n";
		return optional;
	}
	
}
