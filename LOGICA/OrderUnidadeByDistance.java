package MONITORAMENTO.LOGICA;

import java.util.Comparator;

public class OrderUnidadeByDistance implements Comparator<Unidade>{

	private Unidade un;
	double abcissa;
	double ordenada;
	
	
	public OrderUnidadeByDistance(Unidade un, double abcissa, double ordenada) {
		setUn(un);
		setAbcissa(abcissa);
		setOrdenada(ordenada);
	}
	
	protected double getAbcissa() {
		return this.abcissa;
	}

	protected void setAbcissa(double abcissa) {
		this.abcissa = abcissa;
	}

	protected double getOrdenada() {
		return this.ordenada;
	}

	protected void setOrdenada(double ordenada) {
		this.ordenada = ordenada;
	}

	protected Unidade getUn() {
		return this.un;
	}

	protected void setUn(Unidade un) {
		this.un = un;
	}

	public OrderUnidadeByDistance (Unidade un) {
		setUn(un);
	}
	
	@Override
	public int compare(Unidade un1, Unidade un2) {
		if(un1.distancia(this.abcissa, this.ordenada) > un2.distancia(this.abcissa, this.ordenada)) {
			return 1;
		}else if(un1.distancia(this.abcissa, this.ordenada) < un2.distancia(this.abcissa, this.ordenada)) {
			return -1;
		}else {
			return 0;
		}
	}

}
