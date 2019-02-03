package gui;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.run();
	}
	
	private void run() {
		MainFrame window = new MainFrame("Converter");
		window.setVisible(true);
	}

}
