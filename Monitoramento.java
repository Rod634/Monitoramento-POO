package MONITORAMENTO;

public class Monitoramento {

	Unidade[] unidades;

	public Monitoramento(Unidade[] unidades) {
		setUnidades(unidades); 
	}
	
	protected Unidade[] getUnidades() {
		return unidades;
	}

	protected void setUnidades(Unidade[] unidades) {
		this.unidades = unidades;
	}
	

	protected Unidade validarFerramentas(boolean video, boolean termometro, boolean co2, boolean ch4) {
		

		return null;
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
		
		double menor = this.getUnidades()[0].distancia(abcissa, ordenada);
		int id = this.getUnidades()[0].getId();
				
		for(Unidade unidade : this.getUnidades()) {
			if(vadilarUnidade(video, termometro, co2, ch4, unidade)) {
				if(unidade.distancia(abcissa, ordenada) < menor) {
					menor = unidade.distancia(abcissa, ordenada);
					id = unidade.getId();
				}
			}else if(!video && !termometro && !co2 && !ch4){
				return "Escolha no minimo 1 ferramenta de monitoramento";
			}
		}
			
			atualizarUnidade(abcissa, ordenada, id);
	
		
		return "Unidade: " + id + " (id), atualizou sua localização";
	}
	
}
