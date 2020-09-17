package MONITORAMENTO;

public abstract class Unidade {
	
	int id;
	double abcissa;
	double ordenada;
	boolean video;
	boolean termometro;
	boolean co2;
	boolean ch4;
	
	public Unidade(int id, double abcissa, double ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		setId(id);
		setAbcissa(abcissa);
		setOrdenada(ordenada);
		setVideo(video);
		setTermometro(termometro);
		setCo2(co2);
		setCh4(ch4);
	}
	
	protected abstract double distancia(double abcissa, double ordenada);
	
	protected int getId() {
		return id;
	}
	
	protected void setId(int id) {
		this.id = id;
	}

	protected double getAbcissa() {
		return abcissa;
	}

	protected void setAbcissa(double abcissa) {
		this.abcissa = abcissa;
	}

	protected double getOrdenada() {
		return ordenada;
	}

	protected void setOrdenada(double ordenada) {
		this.ordenada = ordenada;
	}

	protected boolean isVideo() {
		return video;
	}

	protected void setVideo(boolean video) {
		this.video = video;
	}

	protected boolean isTermometro() {
		return termometro;
	}

	protected void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}

	protected boolean isCo2() {
		return co2;
	}

	protected void setCo2(boolean co2) {
		this.co2 = co2;
	}

	protected boolean isCh4() {
		return ch4;
	}

	protected void setCh4(boolean ch4) {
		this.ch4 = ch4;
	}
	
}
