package org.uet.test;


public class test {


	public static void main(String[] args) {
		String input = "đặt báo thức 8 giờ 30 phút";
		AppAction appAction = AppAction.newInstance();
		System.out.println(appAction.getAction("alarm", input));

	}

}
