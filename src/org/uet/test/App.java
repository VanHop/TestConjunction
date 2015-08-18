package org.uet.test;

import java.util.ArrayList;


public class App {

	private ArrayList<Action> actions;
	private String appname;
	
	public App(String appname){
		this.appname = appname;
		actions = new ArrayList<Action>();
	}
	
	public void addAction(Action action){
		actions.add(action);
	}
	
	public ArrayList<Action> getAction(){
		return actions;
	}
	
	public String getName(){
		return appname;
	}
	
}
