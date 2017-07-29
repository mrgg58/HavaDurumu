package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import ModelView.Manage;
import Model.Weather;
import dataaccesslayer.Request;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField txtIn;
	private JLabel lblIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
	
		Manage manage = new Manage(new Request(new Weather()), new Weather());
		txtIn = new JTextField();
		txtIn.setBounds(49, 71, 118, 20);
		contentPane.add(txtIn);
		txtIn.setColumns(10);

		JButton btnSend = new JButton("Ok");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					manage.setLocation(txtIn.getText());
					if(txtIn.getText().isEmpty()) {
					
						return;
						
						
					}
					lblIn.setText(manage.modalAta().getDescription());

				} catch (JSONException | IOException e) {

					e.printStackTrace();
				}

			}

		});
		btnSend.setBounds(204, 70, 89, 23);
		contentPane.add(btnSend);

		lblIn = new JLabel("");
		lblIn.setBounds(176, 151, 148, 83);
		contentPane.add(lblIn);
	}
}
