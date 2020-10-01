package MONITORAMENTO;

public class UnidadeEuclidiana extends Unidade{

	public UnidadeEuclidiana(int id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		super(id, abcissa, ordenada, video, termometro, co2, ch4);
	}
	
	public double distancia(double abcissa, double ordenada) {
		double distancia = Math.sqrt((Math.pow(abcissa - this.abcissa, 2)) + (Math.pow(ordenada - this.ordenada, 2)));
		return distancia;
	}
	
}
