package attraction;

import java.util.ArrayList;

import tourism.TourismQuery;

public class AttractionQuery extends TourismQuery {
	private String abstractInfo = "dbo:abstract ?abstract";
	private String abstractLabel = "lang(?abstract) = 'en'";
	private String lat = "geo:lat ?lat";
	private String longt = "geo:long ?long";
	private String location = "dbp:location ?location";
	
	public String getAbstractInfo() {
		return abstractInfo;
	}
	public void setAbstractInfo(String abstractInfo) {
		this.abstractInfo = abstractInfo;
	}
	public String getAbstractLabel() {
		return abstractLabel;
	}
	public void setAbstractLabel(String abstractLabel) {
		this.abstractLabel = abstractLabel;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongt() {
		return longt;
	}
	public void setLongt(String longt) {
		this.longt = longt;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String constructClause(ArrayList userChoice) {
		String construct = super.constructClause(userChoice);
		construct = construct + "\n"
				+ this.getName() + ";\n"
				+ this.getAbstractInfo() + ";\n";
		if (userChoice.get(0).equals(true))
			construct += this.getLat() + ";\n";
		if (userChoice.get(1).equals(true))
			construct += this.getLongt() + ";\n";
		if (userChoice.get(2).equals(true))
			construct += this.getLocation() + ";\n";
		return construct;
	}
	
	@Override
	public String whereClause(ArrayList userChoice) {
		String where = super.whereClause(userChoice);
		where = where + "\n"
				+ this.getName() + ";\n"
				+ this.getAbstractInfo();
		return where;
	}
	
	@Override
	public String optionalClause(ArrayList userChoice) {
		String optional = super.optionalClause(userChoice);
		optional = optional + "\n";
		if (userChoice.get(0).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getLat() + "}" + ".\n";
		if (userChoice.get(1).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getLongt() + "}" + ".\n";
		if (userChoice.get(2).equals(true))
			optional += "optional{" + this.getSourceLink() + " " + this.getLocation() + "}" + ".\n";
		return optional;
	}
	
}
