package main;

import _view.Facade;
import _view.FacadeImpl;

public class Main {

	public static void main(String[] args) {
		System app = new System();
		Facade facade = new FacadeImpl(app);
		facade.start();
	}
}
