package _view;

public class Main {

	public static void main(String[] args) {
		System app = new System();
		Facade facade = new Facade(app);
		facade.start();
	}
}
