package MONITORAMENTO.DTO;

public class UnidadeDTO {
		
	int id;
	double abcissa;
	double ordenada;
	double distancia;
	
	public UnidadeDTO(int id, double abcissa, double ordenada) {
		setId(id);
		setAbcissa(abcissa);
		setOrdenada(ordenada);
	}
	
	protected int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}

	protected double getAbcissa() {
		return abcissa;
	}

	private void setdistancia(double distancia) {
		this.distancia = distancia;
	}
	
	protected double getdistancia() {
		return distancia;
	}

	private void setAbcissa(double abcissa) {
		this.abcissa = abcissa;
	}


	protected double getOrdenada() {
		return ordenada;
	}

	private void setOrdenada(double ordenada) {
		this.ordenada = ordenada;
	}
	
}


