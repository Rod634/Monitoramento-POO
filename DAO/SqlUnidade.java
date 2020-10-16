package MONITORAMENTO.DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MONITORAMENTO.LOGICA.Unidade;
import MONITORAMENTO.LOGICA.UnidadeEuclidiana;
import MONITORAMENTO.LOGICA.UnidadeManhattan;

public class SqlUnidade implements UnidadeDAO{

	private static final String URI = "jdbc:h2:~/test";
	
	private static final String Euclidiana = "Euclidiana";
	private static final String Manhattan = "Manhattan";
	private static final String DRIVE = "org.h2.Driver";
	
	private static String INSERT_SQL = "INSERT INTO UNIDADES(ID, NAME, abcissa, ordenada, video, termometro, co2, ch4, status) values\r\n" + 
									   "(?, ?, ?, ?, ?, ?, ?, ?, ?)\r\n" + 
									   "";
	
	private static String UPDATE_SQL = "UPDATE UNIDADES SET ABCISSA = ?, ORDENADA = ? WHERE ID = ?";
	
	private static String GetAll = "select * from UNIDADES";
	
	public SqlUnidade() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager.registerDriver((Driver) Class.forName(SqlUnidade.DRIVE).newInstance());
	}
	
	public Connection getConnection() throws SQLException {
		Connection conect = DriverManager.getConnection(URI, "sa","");
		return conect;
	}
	
	@Override
	public void salvar(Unidade ue) throws Exception {
		if(ue instanceof UnidadeEuclidiana) {
			this.salvarUn(ue, Euclidiana);
		}else if (ue instanceof UnidadeManhattan){
			this.salvarUn(ue, Manhattan);
		}
	}

	private void salvarUn(Unidade ue, String name) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(INSERT_SQL);
		stmt.setInt(1, ue.getId());
		stmt.setString(2, name);
		stmt.setDouble(3, ue.getAbcissa());
		stmt.setDouble(4, ue.getOrdenada());
		stmt.setBoolean(5, ue.isVideo());
		stmt.setBoolean(6, ue.isTermometro());
		stmt.setBoolean(7, ue.isCo2());
		stmt.setBoolean(8, ue.isCh4());
		stmt.setBoolean(9, true);
		stmt.executeUpdate();
	}

	@Override
	public List<Unidade> getUns() throws Exception {
		
		List<Unidade> uns = new ArrayList<Unidade>();
		
		Statement stmt = this.getConnection().createStatement();
		boolean retorno = stmt.execute(GetAll);
		
		if(retorno == true) {
			ResultSet resultado = stmt.getResultSet();
			while(resultado.next()) {
				
				int id = resultado.getInt("ID");
				String nome = resultado.getString("NAME");
				double abcissa = resultado.getDouble("ABCISSA");
				double ordenada = resultado.getDouble("ORDENADA");
				boolean video = resultado.getBoolean("VIDEO");
				boolean termometro = resultado.getBoolean("TERMOMETRO");
				boolean co2 = resultado.getBoolean("CO2");
				boolean ch4 = resultado.getBoolean("CH4");
				boolean status = resultado.getBoolean("STATUS");
				
				if(nome.matches("Euclidiana") && status == true) {
					uns.add(new UnidadeEuclidiana(id, abcissa, ordenada, video, termometro, co2, ch4));
				}else if(nome.matches("Manhattan") && status == true) {
					uns.add(new UnidadeManhattan(id, abcissa, ordenada, video, termometro, co2, ch4));
				}
			}
		}
		
		return uns;
	}

	@Override
	public Unidade getUnById(int id) throws Exception {
		List<Unidade> unidades = this.getUns();
		Unidade ue = null;
		for(Unidade un : unidades) {
			if(un.getId() == ue.getId()) {
				ue = un;
			}else {
				continue;
			}
		}
		
		return ue;
	}

	@Override
	public void atualizar(Unidade un) throws Exception {
		PreparedStatement stmt = this.getConnection().prepareStatement(UPDATE_SQL);
		stmt.setDouble(1, un.getAbcissa());
		stmt.setDouble(2, un.getOrdenada());
		stmt.setInt(3, un.getId());
		stmt.executeUpdate();
	}

}
