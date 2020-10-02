package MONITORAMENTO.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import MONITORAMENTO.LOGICA.Unidade;
import MONITORAMENTO.LOGICA.UnidadeEuclidiana;
import MONITORAMENTO.LOGICA.UnidadeManhattan;

public class SqlUnidade implements UnidadeDAO{

	private static final String URI = "jdbc:h2:~/test";
	
	private static final String Euclidiana = "Euclidiana";
	private static final String Manhattan = "Manhattan";
	
	private static String INSERT_SQL = "INSERT INTO UNIDADES(ID, NAME, abcissa, ordenada, video, termometro, co2, ch4, status) values\r\n" + 
									   "(?, ?, ?, ?, ?, ?, ?, ?, ?)\r\n" + 
									   "";

	public SqlUnidade() throws SQLException {
		DriverManager.registerDriver(new org.h2.Driver());
	}
	
	public Connection getConnection() throws SQLException {
		Connection conect = DriverManager.getConnection(URI);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unidade getUnById(int i) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Unidade un) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
