package MONITORAMENTO.DTO;

public class UnidadeDTO {
		
	int id;
	double abcissa;
	double ordenada;
	
	public UnidadeDTO(int id, double abcissa, double ordenada) {
		setId(id);
		setAbcissa(abcissa);
		setOrdenada(ordenada);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}

	public double getAbcissa() {
		return abcissa;
	}

	private void setAbcissa(double abcissa) {
		this.abcissa = abcissa;
	}


	public double getOrdenada() {
		return ordenada;
	}

	private void setOrdenada(double ordenada) {
		this.ordenada = ordenada;
	}
	
}


