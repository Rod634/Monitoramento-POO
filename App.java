package MONITORAMENTO;

public class App {

	public static void main(String[] args) {
		UnidadeEuclidiana ue = new UnidadeEuclidiana(1, 35, 27, true, false, false, false);
		System.out.println("Id: " + ue.getId());
		System.out.println("Abcissa: " + ue.getAbcissa());
		System.out.println("Ordenada: " + ue.getOrdenada());
		System.out.println("Video: " + ue.isVideo());
		System.out.println("Termometro: " + ue.isTermometro());
		System.out.println("Co2: " + ue.isCo2());
		System.out.println("Ch4: " + ue.isCh4());
		System.out.println("distancia euclidiana: " + String.format("%.2f", ue.distancia(10, 17)));
		
		System.out.println("------------------------------------------------------------------------");
		
		UnidadeManhattan um = new UnidadeManhattan(2, 35, 27, true, false, false, false);
		System.out.println("Id: " + um.getId());
		System.out.println("Abcissa: " + um.getAbcissa());
		System.out.println("Ordenada: " + um.getOrdenada());
		System.out.println("Video: " + um.isVideo());
		System.out.println("Termometro: " + um.isTermometro());
		System.out.println("Co2: " + um.isCo2());
		System.out.println("Ch4: " + um.isCh4());
		System.out.println("distancia Manhhatan: " + String.format("%.2f", um.distancia(10, 27)));
		
		System.out.println("------------------------------------------------------------------------");
		
		Unidade[] unidades = { um, ue };
		
		Monitoramento mn = new Monitoramento(unidades);
		System.out.println(mn.monitorar(10, 27, true, false, false, false));
		
	}

}
