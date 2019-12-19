package br.edu.univas.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.univas.dao.LoginDAO;
import bre.edu.univas.vo.Login;

public class Tela1 extends JFrame {
	
	private JTextField usernameTextField = new JTextField();
	private JPasswordField passJPasswordField = new JPasswordField();

	public Tela1() {
		setSize(640,400);
		
		setTitle("Trabalho 2");
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		inicializa();
	}
	
	private void inicializa() {
		
		JLabel loginJLabel = new JLabel();
		loginJLabel.setText("*****************************************Longin************************************************************************");
		getContentPane().add(loginJLabel);
		
		JTextField loginTextField = new JTextField();
		loginTextField.setColumns(0);
		getContentPane().add(loginTextField);
				
		JLabel usernameJLabel = new JLabel();
		usernameJLabel.setText("Username: ");
		getContentPane().add(usernameJLabel);
		
		usernameTextField.setColumns(45);
		getContentPane().add(usernameTextField);
		
		JLabel passJLabel = new JLabel();
		passJLabel.setText("Password: ");
		getContentPane().add(passJLabel);
		
		passJPasswordField.setColumns(45);
		getContentPane().add(passJPasswordField);
		
		JButton logarJButton = new JButton();
		logarJButton.setText("Logar");
		logarJButton.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("validando usuário");
				try {
					LoginDAO dao = new LoginDAO();
					
					List<Login> lista = dao.listAll();
					
					for (Login login : lista) {
						
						if (usernameTextField.getText().equals(login.getUsername()) && 
								passJPasswordField.getText().equals(login.getPassword())){
							System.out.println("Usuário logado com sucesso");
							return;
						}else {
							System.out.println("Usuário/Senha inválidos");
							return;
						}
						
					}
					System.out.println("erro");
					
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		getContentPane().add(logarJButton);
		
	}
}
