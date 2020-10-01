package MONITORAMENTO;

import java.util.ArrayList;
import java.util.List;

public class Monitoramento {

	List<Unidade> unidades = new ArrayList<Unidade>();

	public Monitoramento(List<Unidade> unidades) {
		setUnidades(unidades); 
	}
	
	public Monitoramento() {
		
	}
	
	public void addUnidadeEuclidiana(int id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		this.unidades.add(new UnidadeEuclidiana(id, abcissa, ordenada, video, termometro, co2, ch4));
	}
	
	public void addUnidadeManhattan(int id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		this.unidades.add(new UnidadeManhattan(id, abcissa, ordenada, video, termometro, co2, ch4));
	}
	
	protected List<Unidade> getUnidades() {
		return unidades;
	}

	protected void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
		
	private void atualizarUnidade(double abcissa, double ordenada, int id) {
		
		for(Unidade un : this.getUnidades()) {
			if(id == un.getId()) {
				un.setAbcissa(abcissa);
				un.setOrdenada(ordenada);
			}
		}
	}
	
	private boolean vadilarUnidade(boolean video, boolean termometro, boolean co2, boolean ch4, Unidade un){
		if((video && un.isVideo()) || (termometro && un.isTermometro()) || (co2 && un.isCo2()) || (ch4 && un.isCh4())) {
			return true;
		}else {
			return false;
		}
	}
	
	public String monitorar(double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		
		double menor = 	unidades.get(0).distancia(abcissa, ordenada);
		int id = 0;
				
		for(Unidade unidade : this.getUnidades()) {
			if(vadilarUnidade(video, termometro, co2, ch4, unidade)) {
				if(unidade.distancia(abcissa, ordenada) <= menor) {
					menor = unidade.distancia(abcissa, ordenada);
					id = unidade.getId();
				}
			}else if(!video && !termometro && !co2 && !ch4){
				return "Escolha no minimo 1 ferramenta de monitoramento";
			}
		}
			

		if(id == 0) {
			return "nenhuma unidade disponivel com a configuração desejada";
		}else {
			atualizarUnidade(abcissa, ordenada, id);
			return "Unidade: " + id + " (id), atualizou sua localização";
		}
	}
	
}
