package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import hilos.*;

public class GUI_Hilos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Hilos frame = new GUI_Hilos();
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
	public GUI_Hilos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 33, 176, 298);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(221, 33, 176, 298);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(416, 33, 176, 298);
		contentPane.add(scrollPane_2);
		
		JLabel lblHilo = new JLabel("Hilo_Secuencia1");
		lblHilo.setBounds(23, 11, 91, 14);
		contentPane.add(lblHilo);
		
		JLabel lblHilosecuencia = new JLabel("Hilo_Secuencia 2");
		lblHilosecuencia.setBounds(221, 11, 91, 14);
		contentPane.add(lblHilosecuencia);
		
		JLabel lblHilointerrupciones = new JLabel("Hilo_Interrupciones");
		lblHilointerrupciones.setBounds(416, 11, 102, 14);
		contentPane.add(lblHilointerrupciones);
	}
}
