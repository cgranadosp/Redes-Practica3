package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.Secuencia1;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GuiThreads extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiThreads frame = new GuiThreads();
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
	public GuiThreads() {
		setTitle("Practica 3   -   Programación Comcurrente");
		setResizable(false);
		setFont(new Font("URW Gothic L", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(550, 40, 205, 349);
		contentPane.add(scrollPane);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setLineWrap(true);
		scrollPane.setViewportView(textArea_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(300, 40, 205, 349);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBounds(50, 40, 205, 349);
		contentPane.add(scrollPane_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane_2.setViewportView(textArea);
		
		JLabel lblHilosecuencia = new JLabel("Hilo_Secuencia1");
		lblHilosecuencia.setBounds(50, 13, 205, 15);
		contentPane.add(lblHilosecuencia);
		
		JLabel lblHilosecuencia_1 = new JLabel("Hilo_Secuencia2");
		lblHilosecuencia_1.setBounds(300, 13, 205, 15);
		contentPane.add(lblHilosecuencia_1);
		
		JLabel lblHilointerrupciones = new JLabel("Hilo_Interrupciones");
		lblHilointerrupciones.setBounds(550, 13, 205, 15);
		contentPane.add(lblHilointerrupciones);
	}
}
