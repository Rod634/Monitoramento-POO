package MONITORAMENTO.LOGICA;

import MONITORAMENTO.DAO.UnidadeDAO;

public interface UnidadeLogica {

	public void setPersistencia(UnidadeDAO persistencia) throws Exception;

	public void addUnidadeEuclidiana(int id, double abcissa, double ordenada, boolean video, boolean termometro, boolean co2,
			boolean ch4) throws Exception;

	public void addUnidadeManhattan(int id, double abcissa, double ordenada, boolean video, boolean termometro, boolean co2,
			boolean ch4) throws Exception;

	public String monitorar(double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception;

}
