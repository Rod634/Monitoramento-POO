package MONITORAMENTO;

public class App {

	public static void main(String[] args) {
		
		double abcissa = 10;
		double ordenada = 27;
		boolean video = true;
		boolean termometro = true;
		boolean co2 = true;
		boolean ch4 = true;
		
		Monitoramento monitorar = new Monitoramento();
				 
		monitorar.addUnidadeManhattan(1, 78, -27, true, false, false, false);
		monitorar.addUnidadeEuclidiana(2, 78, -27, false, true, false, false);
		monitorar.addUnidadeEuclidiana(3, 27, 18, false, false, true, false);
		monitorar.addUnidadeManhattan(4, 26, -13, false, false, false, true);
		
		System.out.println(monitorar.monitorar(abcissa, ordenada, video, termometro, co2, ch4));
	
	}

}
