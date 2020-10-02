package MONITORAMENTO.DAO;

import java.util.List;

import MONITORAMENTO.LOGICA.Unidade;
import MONITORAMENTO.LOGICA.UnidadeEuclidiana;

public interface UnidadeDAO {

	void salvar(Unidade ue) throws Exception;

	List<Unidade> getUns() throws Exception;

	Unidade getUnById(int i) throws Exception;

	void atualizar(Unidade un) throws Exception;

}
