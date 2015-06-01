package com.zubiri.CheckBoxExamen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckBoxExamen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxExamen frame = new CheckBoxExamen();
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
	public CheckBoxExamen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckbox = new JLabel("CheckBox");
		lblCheckbox.setBounds(181, 12, 70, 15);
		contentPane.add(lblCheckbox);
		
		JCheckBox chckbxPerro = new JCheckBox("perro");
		chckbxPerro.setBounds(48, 57, 129, 23);
		contentPane.add(chckbxPerro);
		
		JCheckBox chckbxGato = new JCheckBox("gato");
		chckbxGato.setBounds(48, 94, 129, 23);
		contentPane.add(chckbxGato);
		
		JCheckBox chckbxCaballo = new JCheckBox("caballo");
		chckbxCaballo.setBounds(48, 137, 129, 23);
		contentPane.add(chckbxCaballo);
		
		JCheckBox chckbxElefante = new JCheckBox("elefante");
		chckbxElefante.setBounds(48, 176, 129, 23);
		contentPane.add(chckbxElefante);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxPerro.isSelected()==true){
					System.out.println("has elegido al perro");
				}
				else if(chckbxGato.isSelected()==true){
					System.out.println("has elegido al gato");
				}
				else if(chckbxCaballo.isSelected()==true){
					System.out.println("has elegido al caballo");
				}
				else if(chckbxElefante.isSelected()==true){
					System.out.println("has elegido al elefante");
				}
			}
		});
		btnOk.setBounds(237, 76, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbxPerro.setSelected(false);
				chckbxGato.setSelected(false);
				chckbxCaballo.setSelected(false);
				chckbxElefante.setSelected(false);
				System.out.println("se ha borrado la seleccion");
				
			}
		});
		btnCancelar.setBounds(237, 136, 117, 25);
		contentPane.add(btnCancelar);
		
	}
}
