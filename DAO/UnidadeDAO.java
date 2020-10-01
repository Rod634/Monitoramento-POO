package MONITORAMENTO.DAO;

import java.util.List;

import MONITORAMENTO.LOGICA.Unidade;

public interface UnidadeDAO {

	void salvar(Unidade ue);

	List<Unidade> getUns();

	Unidade getUnById(int i);

	void atualizar(Unidade un);

}
