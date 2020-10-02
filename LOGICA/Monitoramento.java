package MONITORAMENTO.LOGICA;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import MONITORAMENTO.DAO.SqlUnidade;
import MONITORAMENTO.DAO.UnidadeDAO;

public class Monitoramento {
	
	private UnidadeDAO unidadeDAO;

	public Monitoramento() throws SQLException {
		unidadeDAO = new SqlUnidade();
	}
	
	public void addUnidadeEuclidiana(int id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
		UnidadeEuclidiana ue = new UnidadeEuclidiana(id, abcissa, ordenada, video, termometro, co2, ch4);
		this.addUn(ue);
	}
	
	public void addUnidadeManhattan(int id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
		UnidadeManhattan um = new UnidadeManhattan(id, abcissa, ordenada, video, termometro, co2, ch4);
		this.addUn(um);
	}
	
	private void addUn(Unidade ue) throws Exception {
		this.unidadeDAO.salvar(ue);
	}
	
	private boolean vadilarUnidade(boolean video, boolean termometro, boolean co2, boolean ch4, Unidade un){
		if((video && un.isVideo()) || (termometro && un.isTermometro()) || (co2 && un.isCo2()) || (ch4 && un.isCh4())) {
			return true;
		}else {
			return false;
		}
	}
	
	public String monitorar(double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
		
		Unidade un = null;
		
		List<Unidade> unities = this.unidadeDAO.getUns();
		Collections.sort(unities, new OrderUnidadeByDistance(this.unidadeDAO.getUnById(0), abcissa, ordenada));
		

		for(Unidade unidade : unities) {
			if(vadilarUnidade(video, termometro, co2, ch4, unidade)) {
				un = unidade;
				this.unidadeDAO.atualizar(un);
				break;
			}else if(!video && !termometro && !co2 && !ch4){
				return "Escolha no minimo 1 ferramenta de monitoramento";
			}
		}
			
		if(un == null) {
			return "nenhuma unidade disponivel com a configuração desejada";
		}else {
			return "Unidade: " + un.getId() + " (id), atualizou sua localização";
		}
	}
	
}
