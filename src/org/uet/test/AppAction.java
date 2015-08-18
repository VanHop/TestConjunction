package org.uet.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AppAction {

	private HashMap<String,App> apps;
	private static AppAction appAction;
	
	private AppAction(){
		apps = new HashMap<String, App>();
		try {
			//load from file
			FileReader fos;
			fos = new FileReader(System.getProperty("user.dir") + "\\assests\\appaction.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fos);
			String s;
			
			// Đọc từng dòng văn bản!
			while ((s = br.readLine()) != null) {
				String [] tokens = s.split(":");
				App app = apps.get(tokens[0]);
				if(app == null)
					app = new App(tokens[0]);
				
				Action action = new Action(tokens[1]);
				String [] conjuntions = tokens[2].split(",");
				if(conjuntions == null){
					conjuntions = new String[]{tokens[2]};
				}
				for(String conjuntion : conjuntions)
					action.addConjunction(conjuntion);
				app.addAction(action);
				apps.put(app.getName(), app);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static AppAction newInstance(){
		if(appAction == null)
			appAction = new AppAction();
		return appAction;
	}
	
	public String getAction(String appname, String sentence){
		
		ArrayList<Action> actions = apps.get(appname).getAction();
		for(Action action : actions){
			if(action.mapConjunction(sentence))
				return action.getName();
		}
		
		return null;
	}

}
