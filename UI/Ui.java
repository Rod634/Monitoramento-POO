package MONITORAMENTO.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import MONITORAMENTO.LOGICA.Monitoramento;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Ui implements ActionListener {

	private JFrame frame;
	private JTextField idTextField;
	private JTextField abcisssaTextField;
	private JTextField ordenadaTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTextField abcissaAreaTxt;
	private JTextField ordenadaAreaTxt;
	private JCheckBox videoCheck = new JCheckBox("Video");
	private JButton btnCriarUn = new JButton("Criar Unidade");
	private	JCheckBox termometroCheck = new JCheckBox("Termometro");
	private JCheckBox co2Check = new JCheckBox("Co2");
	private JCheckBox chCheck = new JCheckBox("Ch4");
	private JRadioButton euclidianaRadio = new JRadioButton("Euclidiana");
	private JRadioButton manhattanRadio = new JRadioButton("Manhattan");
	private JLabel ordenadaLbl_1 = new JLabel("Ordenada");
	private JCheckBox videoAreaCheck = new JCheckBox("Video");
	private JCheckBox termometroAreaCheck = new JCheckBox("Termometro");
	private JCheckBox co2AreaCheck = new JCheckBox("Co2");
	private JCheckBox chAreaCheck = new JCheckBox("Ch4");
	private JButton btnMonitorar = new JButton("Monitorar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Ui window = new Ui();
		window.frame.setVisible(true);
	}
	

	/**
	 * Create the application.
	 */
	public Ui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 456, 208);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserir Unidade");
		lblNewLabel.setBounds(167, 10, 109, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setBounds(32, 56, 45, 13);
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(idLbl);
		
		JLabel abcissaLbl = new JLabel("Abcissa");
		abcissaLbl.setBounds(87, 57, 45, 13);
		abcissaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(abcissaLbl);
		
		JLabel ordenadaLbl = new JLabel("Ordenada");
		ordenadaLbl.setBounds(167, 56, 75, 13);
		ordenadaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(ordenadaLbl);
		
		this.idTextField = new JTextField();
		this.idTextField.setBounds(32, 79, 33, 19);
		panel.add(this.idTextField);
		this.idTextField.setColumns(10);
		
		this.abcisssaTextField = new JTextField();
		this.abcisssaTextField.setBounds(86, 79, 51, 19);
		panel.add(this.abcisssaTextField);
		this.abcisssaTextField.setColumns(10);
		
		this.ordenadaTextField = new JTextField();
		this.ordenadaTextField.setBounds(167, 79, 62, 19);
		panel.add(ordenadaTextField);
		this.ordenadaTextField.setColumns(10);
		
		
		this.videoCheck.setBackground(SystemColor.inactiveCaption);
		this.videoCheck.setBounds(268, 79, 62, 21);
		this.videoCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(this.videoCheck);
		
		this.termometroCheck.setBackground(SystemColor.inactiveCaption);
		this.termometroCheck.setBounds(268, 101, 109, 21);
		this.termometroCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(this.termometroCheck);
		
		this.co2Check.setBackground(SystemColor.inactiveCaption);
		this.co2Check.setBounds(373, 79, 93, 21);
		this.co2Check.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(this.co2Check);
		
		this.chCheck.setBackground(SystemColor.inactiveCaption);
		this.chCheck.setBounds(373, 100, 93, 21);
		this.chCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(this.chCheck);
		
		this.euclidianaRadio.setBackground(SystemColor.inactiveCaption);
		this.euclidianaRadio.setBounds(29, 117, 103, 21);
		this.buttonGroup.add(this.euclidianaRadio);
		this.euclidianaRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(this.euclidianaRadio);
		
		this.manhattanRadio.setBackground(SystemColor.inactiveCaption);
		this.manhattanRadio.setBounds(146, 117, 96, 21);
		this.buttonGroup.add(this.manhattanRadio);
		this.manhattanRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(this.manhattanRadio);
		
		this.btnCriarUn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnCriarUn.addActionListener(this);
		this.btnCriarUn.setBackground(Color.WHITE);
		this.btnCriarUn.setBounds(167, 165, 120, 33);
		panel.add(btnCriarUn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 207, 456, 180);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 384, 456, 148);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel abcissaLbl_1 = new JLabel("Abcissa");
		abcissaLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abcissaLbl_1.setBounds(58, 24, 45, 13);
		panel_1.add(abcissaLbl_1);
		
		this.abcissaAreaTxt = new JTextField();
		this.abcissaAreaTxt.setColumns(10);
		this.abcissaAreaTxt.setBounds(57, 46, 51, 19);
		panel_1.add(this.abcissaAreaTxt);
		
		this.ordenadaAreaTxt = new JTextField();
		this.ordenadaAreaTxt.setColumns(10);
		this.ordenadaAreaTxt.setBounds(138, 46, 62, 19);
		panel_1.add(this.ordenadaAreaTxt);
		
		this.ordenadaLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.ordenadaLbl_1.setBounds(138, 23, 75, 13);
		panel_1.add(this.ordenadaLbl_1);
		
		this.videoAreaCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.videoAreaCheck.setBackground(SystemColor.inactiveCaption);
		this.videoAreaCheck.setBounds(238, 24, 62, 21);
		panel_1.add(this.videoAreaCheck);
		
		this.termometroAreaCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.termometroAreaCheck.setBackground(SystemColor.inactiveCaption);
		this.termometroAreaCheck.setBounds(238, 46, 109, 21);
		panel_1.add(this.termometroAreaCheck);
		
		this.co2AreaCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.co2AreaCheck.setBackground(SystemColor.inactiveCaption);
		this.co2AreaCheck.setBounds(343, 24, 56, 21);
		panel_1.add(this.co2AreaCheck);
		
		this.chAreaCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.chAreaCheck.setBackground(SystemColor.inactiveCaption);
		this.chAreaCheck.setBounds(343, 45, 51, 21);
		panel_1.add(this.chAreaCheck);
		
		this.btnMonitorar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btnMonitorar.addActionListener(this);
		this.btnMonitorar.setBackground(Color.WHITE);
		this.btnMonitorar.setBounds(176, 96, 83, 25);
		panel_1.add(btnMonitorar);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		try {
		
			Monitoramento mn = new Monitoramento(true);
			
			if(event.getSource().equals(this.btnCriarUn)) {
				int id = Integer.valueOf(this.idTextField.getText());
				double abcissa = Double.valueOf(this.abcisssaTextField.getText());
				double ordenada = Double.valueOf(this.ordenadaTextField.getText());
				boolean video = this.videoCheck.isSelected();
				boolean termometro = this.termometroCheck.isSelected();
				boolean co2 = this.co2Check.isSelected();
				boolean ch4 = this.chCheck.isSelected();
				boolean euclidiana = this.euclidianaRadio.isSelected();
				boolean manhattan = this.manhattanRadio.isSelected();
				
				if(euclidiana) {
					mn.addUnidadeEuclidiana(id, abcissa, ordenada, video, termometro, co2, ch4);
					JOptionPane.showMessageDialog(null, "Unidade Euclidiana Criada");
				}else if(manhattan) {
					mn.addUnidadeManhattan(id, abcissa, ordenada, video, termometro, co2, ch4);
					JOptionPane.showMessageDialog(null, "Unidade Manhattan Criada");
				}
			}else if(event.getSource().equals(this.btnMonitorar)) {
				double abcissa = Double.valueOf(this.abcissaAreaTxt.getText());
				double ordenada = Double.valueOf(this.ordenadaAreaTxt.getText());
				boolean video = this.videoAreaCheck.isSelected();
				boolean termometro = this.termometroAreaCheck.isSelected();
				boolean co2 = this.co2AreaCheck.isSelected();
				boolean ch4 = this.chAreaCheck.isSelected();
				
				String message = mn.monitorar(abcissa, ordenada, video, termometro, co2, ch4);
				JOptionPane.showMessageDialog(null, message);
			
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
