package MONITORAMENTO.DAO;

import java.util.ArrayList;
import java.util.List;

import MONITORAMENTO.LOGICA.Unidade;

public class MemUnidade implements UnidadeDAO{
	
	List<Unidade> unidades = new ArrayList<Unidade>();
	
	protected void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	
	protected List<Unidade> getUnidades() {
		return unidades;
	}
	

	@Override
	public void salvar(Unidade ue) {
		this.unidades.add(ue);
	}

	@Override
	public Unidade getUnById(int i) {
		return this.unidades.get(i);
	}

	@Override
	public List<Unidade> getUns() {
		return this.getUnidades();
	}

	@Override
	public void atualizar(Unidade un) {
		for(Unidade ue : this.getUnidades()) {
			if(ue.getId() == un.getId()) {
				ue = un;
			}
		}
	}

	
		
}
