package MONITORAMENTO.LOGICA;

public class UnidadeManhattan extends Unidade{

	public UnidadeManhattan(int id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		super(id, abcissa, ordenada, video, termometro, co2, ch4);
	}


	public double distancia(double abcissa, double ordenada) {
		
		double distancia = Math.abs(abcissa - this.abcissa) + Math.abs(ordenada - this.ordenada);
		return distancia;
	}

	
}
