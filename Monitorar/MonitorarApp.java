package MONITORAMENTO.Monitorar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


import MONITORAMENTO.DAO.UnidadeDAO;

import MONITORAMENTO.LOGICA.UnidadeLogica;
import MONITORAMENTO.UI.MonitoramentoUi;

public class MonitorarApp {

	private UnidadeDAO persistencia;
	private UnidadeLogica logica;
	private MonitoramentoUi ui;
	
	public void initialize(String file) throws Exception {
		startMethods(file);
		this.logica.setPersistencia(this.persistencia);
		this.ui.setLogica(this.logica);
		this.ui.run();
	}
	
	private void startMethods(String file) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(file));
		
		this.persistencia = (UnidadeDAO) Class.forName((String) prop.get("persistencia")).newInstance();
		this.logica = (UnidadeLogica) Class.forName((String) prop.get("logica")).newInstance();
		this.ui = (MonitoramentoUi) Class.forName((String) prop.get("ui")).newInstance();
	}
	
	public static void main(String[] args) throws Exception {
		(new MonitorarApp()).initialize("D:\\Java\\Monitoramento_POO\\src\\MONITORAMENTO\\config");
	}
	
}
