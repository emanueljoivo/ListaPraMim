package view;

import view.Facade;
import view.System;

public class Main {

	public static void main(String[] args) {
		System app = new System();
		Facade facade = new Facade(app);
		facade.start();
	}
}
