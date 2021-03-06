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
	public void salvar(Unidade ue) throws Exception{
		this.unidades.add(ue);
	}

	@Override
	public Unidade getUnById(int id) throws Exception{
		Unidade ue = null;
		for(Unidade un : this.getUnidades()) {
			if(un.getId() == id) {
				ue = un;
			}
		}
		return ue;
	}

	@Override
	public List<Unidade> getUns() throws Exception{
		return this.getUnidades();
	}

	@Override
	public void atualizar(Unidade un) throws Exception{
		for(Unidade ue : this.getUnidades()) {
			if(ue.getId() == un.getId()) {
				ue = un;
			}
		}
	}
	
	public void deletar(Unidade un) {
		
	}
		
}
