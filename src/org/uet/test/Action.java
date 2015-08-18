package org.uet.test;

import jmdn.method.conjunction.ConjunctionMatcher;

public class Action {

	private String action;
	private ConjunctionMatcher conjunctions;
	
	public Action(String action){
		conjunctions = new ConjunctionMatcher();
		this.action = action;
	}
	
	
	public void addConjunction(String conjunction){
		conjunctions.addConjunction(conjunction);
	}
	
	public String getAction(){
		return action;
	}
	
	public boolean mapConjunction(String sentence){
		return conjunctions.getMatchedConjunctionsWithOrder(sentence).size() > 0 ? true : false;
	}
	
	public String getName(){
		return action;
	}

}
