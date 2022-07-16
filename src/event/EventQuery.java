package event;

import java.util.ArrayList;

import tourism.TourismQuery;

public class EventQuery extends TourismQuery{
	private String abstractInfo = "dbo:abstract ?abstract";
	private String abstractLabel = "lang(?abstract) = 'en'";
	
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

	@Override
	public String constructClause(ArrayList userChoice) {
		String construct = super.constructClause(userChoice);
		construct = construct + "\n"
				+ this.getName() + ";\n"
				+ this.getAbstractInfo() + ";\n";
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
	
}

