package MONITORAMENTO.UI;

import MONITORAMENTO.LOGICA.UnidadeLogica;

public interface MonitoramentoUi {

	public void setLogica(UnidadeLogica logica) throws Exception;
	public  void run() throws Exception;
}
