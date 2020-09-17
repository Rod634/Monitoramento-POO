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
	
	public String monitorar(double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		
		double menor = this.getUnidades()[0].distancia(abcissa, ordenada);
		int id = this.getUnidades()[0].getId();
		
		
		for(int i = 0; i<this.getUnidades().length; i++) {
			if((video && this.getUnidades()[i].isVideo()) || (termometro && this.getUnidades()[i].isTermometro()) || (co2 && this.getUnidades()[i].isCo2()) || (ch4 && this.getUnidades()[i].isCh4())) {
				if(this.getUnidades()[i].distancia(abcissa, ordenada) < menor) {
					menor = this.getUnidades()[i].distancia(abcissa, ordenada);
					id = this.getUnidades()[i].getId();
				}
			}else if(!video && !termometro && !co2 && !ch4){
				return "Escolha no minimo 1 ferramenta de monitoramento";
			}else {
				return "Sem Unidades disponiveis para o Monitoramento";
			}
		}
			
			atualizarUnidade(abcissa, ordenada, id);
	
		
		return "Unidade: " + id + "(id), atualizou sua localização para y = " + abcissa + " x = " + ordenada + ".";
	}
	
}
