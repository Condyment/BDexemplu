import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JPanel {

	private JButton Login;
	private JButton Create;
	private JButton Exit;
	private JTextField forName;
	private JTextField forPassword;
	private JLabel n;
	private JLabel p;
	private String url = "jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false";
	private String user = "root";
	private String pass = "qq20021995qq";
	private String somethingunknow = "com.mysql.jdbc.Driver";

	public GUI() {
		setLayout(null);
		Login = new JButton("Login");
		Create = new JButton("Creat");
		Exit = new JButton("Exit");
		forName = new JTextField();
		forPassword = new JTextField();
		n = new JLabel("Name");
		p = new JLabel("Password");

		Login.setBounds(100, 300, 100, 50);
		Create.setBounds(300, 300, 100, 50);
		Exit.setBounds(200, 400, 100, 50);
		forName.setBounds(150, 100, 200, 40);
		forPassword.setBounds(150, 200, 200, 40);
		n.setBounds(110, 60, 100, 100);
		p.setBounds(90, 170, 100, 100);
		add(Login);
		add(Create);
		add(Exit);
		add(forName);
		add(forPassword);
		add(n);
		add(p);

		Login.addActionListener(e -> {
			try {
				String nm = forName.getText();
				String ps = forPassword.getText();

				Connection con = DriverManager.getConnection(url, user, pass);

				PreparedStatement st = con.prepareStatement("select * from login");
				ResultSet r1 = st.executeQuery();
				int i = 0;
				int k = 0;
				while (r1.next()) {
					i++;

					if (nm.equals(r1.getString("Name"))) {
						if (ps.equals(r1.getString("Pass"))) {
							System.out.println("Congratulation");
							break;
						} else {
							k++;
						}

					} else {

						k++;
					}

				}

				if (k == i) {
					System.out.println("You made somewhere a mistake");

				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Create.addActionListener(e -> {
			try {
				String nm = forName.getText();
				String ps = forPassword.getText();

				Connection con = DriverManager.getConnection(url, user, pass);

				if ((nm.length() != 0) && (ps.length() != 0)) {
					PreparedStatement SS = con
							.prepareStatement("INSERT INTO login" + "(Name,Pass)VALUES('" + nm + "','" + ps + "')");

					SS.executeUpdate();
				} else {
					System.out.println("Textfield is empty please write something");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Exit.addActionListener(e -> {

			System.exit(0);
		});
	}

}
