import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
	JFrame f=new JFrame("The Amazing Program");
	GUI panel=new GUI();
f.setVisible(true);
f.setSize(500,500);
f.add(panel);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
