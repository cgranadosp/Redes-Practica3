package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import files.CreadorLog;
import hilos.ManejoInterrupciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class GuiHilos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		
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
		scrollPane.setBounds(533, 40, 245, 349);
		contentPane.add(scrollPane);
		
		JTextArea txtrInterrupcin = new JTextArea();
		txtrInterrupcin.setText("Interrupci\u00F3n\r\n");
		txtrInterrupcin.setEditable(false);
		scrollPane.setViewportView(txtrInterrupcin);
		
		DefaultCaret caret = (DefaultCaret)txtrInterrupcin.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(283, 40, 222, 349);
		contentPane.add(scrollPane_1);
		
		JTextArea txtrSerieDeFibonacci = new JTextArea();
		txtrSerieDeFibonacci.setText("Serie de Fibonacci\r\n");
		txtrSerieDeFibonacci.setEditable(false);
		scrollPane_1.setViewportView(txtrSerieDeFibonacci);
		
		DefaultCaret caret2 = (DefaultCaret)txtrSerieDeFibonacci.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBounds(33, 40, 222, 349);
		contentPane.add(scrollPane_2);
		
		JTextArea txtrNmerosPrimos = new JTextArea();
		txtrNmerosPrimos.setText("N\u00FAmeros primos\r\n");
		txtrNmerosPrimos.setToolTipText("");
		txtrNmerosPrimos.setEditable(false);
		scrollPane_2.setViewportView(txtrNmerosPrimos);		
		
		DefaultCaret caret3 = (DefaultCaret)txtrNmerosPrimos.getCaret();
		caret3.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
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
				
				CreadorLog logger = new CreadorLog();
				logger.crearArchivoLog();
				ManejoInterrupciones manejoInterrupciones = new ManejoInterrupciones(txtrNmerosPrimos, txtrSerieDeFibonacci, txtrInterrupcin, logger);
				Thread hilo_interrupciones = new Thread(manejoInterrupciones);
				manejoInterrupciones.setHilo(hilo_interrupciones);
				hilo_interrupciones.start();
				btnComenzar.setEnabled(false);
			}
		});
		btnComenzar.setBounds(666, 400, 89, 23);
		contentPane.add(btnComenzar);
	}
}
