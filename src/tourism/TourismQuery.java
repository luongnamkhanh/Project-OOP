package tourism;

import java.util.ArrayList;

public class TourismQuery {
	private String sourceLink = "?tourism";
	private String name = "rdfs:label ?label";
	private String labelFilter = "lang(?label) = 'en'";

	public String getSourceLink() {
		return sourceLink;
	}

	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabelFilter() {
		return labelFilter;
	}

	public void setLabelFilter(String labelFilter) {
		this.labelFilter = labelFilter;
	}

	public String constructClause(ArrayList userChoice) {
		String construct = "";
		return construct;
	}
	
	public String whereClause(ArrayList userChoice) {
		String where = "";
		return where;
	}
	
	public String optionalClause(ArrayList userChoice) {
		String optional = "";
		return optional;
	}
}