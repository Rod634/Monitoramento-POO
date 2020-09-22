package MONITORAMENTO;

public class App {

	public static void main(String[] args) {
		
		double abcissa = 10;
		double ordenada = 27;
		boolean video = true;
		boolean termometro = true;
		boolean co2 = true;
		boolean ch4 = true;
		
		UnidadeEuclidiana ue = new UnidadeEuclidiana(1, 78, -27, true, false, false, false);
		System.out.println("Id: " + ue.getId());
		System.out.println("Abcissa: " + ue.getAbcissa());
		System.out.println("Ordenada: " + ue.getOrdenada());
		System.out.println("Video: " + ue.isVideo());
		System.out.println("Termometro: " + ue.isTermometro());
		System.out.println("Co2: " + ue.isCo2());
		System.out.println("Ch4: " + ue.isCh4());
		System.out.println("distancia euclidiana: " + String.format("%.2f", ue.distancia(abcissa, ordenada)));
		
		System.out.println("------------------------------------------------------------------------");
		
		UnidadeManhattan um = new UnidadeManhattan(2, 78, -27, true, false, false, false);
		System.out.println("Id: " + um.getId());
		System.out.println("Abcissa: " + um.getAbcissa());
		System.out.println("Ordenada: " + um.getOrdenada());
		System.out.println("Video: " + um.isVideo());
		System.out.println("Termometro: " + um.isTermometro());
		System.out.println("Co2: " + um.isCo2());
		System.out.println("Ch4: " + um.isCh4());
		System.out.println("distancia Manhhatan: " + String.format("%.2f", um.distancia(abcissa, ordenada)));
		
		System.out.println("------------------------------------------------------------------------");
		
		UnidadeEuclidiana ue2 = new UnidadeEuclidiana(3, 27, 18, false, false, false, true);
		System.out.println("Id: " + ue2.getId());
		System.out.println("Abcissa: " + ue2.getAbcissa());
		System.out.println("Ordenada: " + ue2.getOrdenada());
		System.out.println("Video: " + ue2.isVideo());
		System.out.println("Termometro: " + ue2.isTermometro());
		System.out.println("Co2: " + ue2.isCo2());
		System.out.println("Ch4: " + ue2.isCh4());
		System.out.println("distancia Manhhatan: " + String.format("%.2f", ue2.distancia(abcissa, ordenada)));
		
		System.out.println("------------------------------------------------------------------------");
		
		UnidadeManhattan um2 = new UnidadeManhattan(4, 26, -13, false, false, false, false);
		System.out.println("Id: " + um2.getId());
		System.out.println("Abcissa: " + um2.getAbcissa());
		System.out.println("Ordenada: " + um2.getOrdenada());
		System.out.println("Video: " + um2.isVideo());
		System.out.println("Termometro: " + um2.isTermometro());
		System.out.println("Co2: " + um2.isCo2());
		System.out.println("Ch4: " + um2.isCh4());
		System.out.println("distancia Manhhatan: " + String.format("%.2f", um2.distancia(abcissa, ordenada)));
		
		System.out.println("------------------------------------------------------------------------\n");
		
		Unidade[] unidades = { ue, um, ue2, um2 };
		
		Monitoramento mn = new Monitoramento(unidades);
		System.out.println(mn.monitorar(abcissa, ordenada, video, termometro, co2, ch4));
		
		System.out.println("\n---------------------Unidades depois da Atualização------------------");
		for(Unidade un : unidades) {
			System.out.println("\nId: " + un.getId());
			System.out.println("Abcissa: " + un.getAbcissa());
			System.out.println("Ordenada: " + un.getOrdenada());
		}
	}

}
