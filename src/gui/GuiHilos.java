package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import hilos.ManejoInterrupciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiHilos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiHilos frame = new GuiHilos();
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
	public GuiHilos() {
		setTitle("Practica 3 - Programación Concurrente");
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
		
		JTextArea txtrInterrupcin = new JTextArea();
		txtrInterrupcin.setText("Interrupci\u00F3n\r\n");
		txtrInterrupcin.setEditable(false);
		txtrInterrupcin.setLineWrap(true);
		scrollPane.setViewportView(txtrInterrupcin);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(300, 40, 205, 349);
		contentPane.add(scrollPane_1);
		
		JTextArea txtrSerieDeFibonacci = new JTextArea();
		txtrSerieDeFibonacci.setText("Serie de Fibonacci\r\n");
		txtrSerieDeFibonacci.setEditable(false);
		txtrSerieDeFibonacci.setLineWrap(true);
		scrollPane_1.setViewportView(txtrSerieDeFibonacci);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBounds(50, 40, 205, 349);
		contentPane.add(scrollPane_2);
		
		JTextArea txtrNmerosPrimos = new JTextArea();
		txtrNmerosPrimos.setText("N\u00FAmeros primos\r\n");
		txtrNmerosPrimos.setToolTipText("");
		txtrNmerosPrimos.setEditable(false);
		txtrNmerosPrimos.setLineWrap(true);
		scrollPane_2.setViewportView(txtrNmerosPrimos);
		
		JLabel lblHilosecuencia = new JLabel("Hilo_Secuencia1");
		lblHilosecuencia.setBounds(50, 13, 205, 15);
		contentPane.add(lblHilosecuencia);
		
		JLabel lblHilosecuencia_1 = new JLabel("Hilo_Secuencia2");
		lblHilosecuencia_1.setBounds(300, 13, 205, 15);
		contentPane.add(lblHilosecuencia_1);
		
		JLabel lblHilointerrupciones = new JLabel("Hilo_Interrupciones");
		lblHilointerrupciones.setBounds(550, 13, 205, 15);
		contentPane.add(lblHilointerrupciones);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejoInterrupciones manejoInterrupciones = new ManejoInterrupciones(txtrNmerosPrimos, txtrSerieDeFibonacci, txtrInterrupcin);
				Thread hilo_interrupciones = new Thread(manejoInterrupciones);
				hilo_interrupciones.start();
			}
		});
		btnComenzar.setBounds(666, 400, 89, 23);
		contentPane.add(btnComenzar);
	}
}
