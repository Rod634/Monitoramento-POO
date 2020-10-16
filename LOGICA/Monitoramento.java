package MONITORAMENTO.LOGICA;

import java.util.Collections;
import java.util.List;

import MONITORAMENTO.DAO.UnidadeDAO;
import MONITORAMENTO.DTO.UnidadeDTO;

public class Monitoramento implements UnidadeLogica {
	
	private UnidadeDAO unidadeDAO;

	@Override
	public void setPersistencia(UnidadeDAO persistencia) throws Exception {
		this.unidadeDAO = persistencia;
	}

	public Monitoramento() {		
	}
	
	public void addUnidadeEuclidiana(int id, double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
		UnidadeEuclidiana ue = new UnidadeEuclidiana(id, abcissa, ordenada, video, termometro, co2, ch4);
		this.addUn(ue);
	}
	
	public void addUnidadeManhattan(int id, double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
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
		try {
			List<Unidade> unities = this.unidadeDAO.getUns();
			Collections.sort(unities, new OrderUnidadeByDistance(unities.get(0), abcissa, ordenada));
			

			for(Unidade unidade : unities) {
				if(vadilarUnidade(video, termometro, co2, ch4, unidade)) {
					un = unidade;
					un.setAbcissa(abcissa);
					un.setOrdenada(ordenada);
					this.unidadeDAO.atualizar(un);
					break;
				}else if(!video && !termometro && !co2 && !ch4){
					return "Escolha no minimo 1 ferramenta de monitoramento";
				}
			}
				
			if(un == null) {
				return "nenhuma unidade disponivel com a configuração desejada";
			}else {
				UnidadeDTO unDTO = new UnidadeDTO(un.getId(), un.getAbcissa(), un.getOrdenada());
				return "Unidade: " + unDTO.getId() + " (id), atualizou sua localização\n"
						+ "Para y: " + unDTO.getAbcissa() + " x: " + unDTO.getOrdenada();
			}
		}catch(IndexOutOfBoundsException e) {
		}catch(Exception e) {}
		
		return "";
	}
}
