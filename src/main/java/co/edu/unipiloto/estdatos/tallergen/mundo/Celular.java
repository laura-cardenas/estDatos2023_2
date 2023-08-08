package co.edu.unipiloto.estdatos.tallergen.mundo;

public class Celular extends Electronico{
	
	public enum Operador
	{
		CLARO, TIGO, VIRGIN, MOVISTAR, ETB, NINGUNO
	}
	
	private Operador operador;
	
	public Celular(Gama pGama, double pPrecio, Operador pOperador)
	{
		super(pGama, pPrecio);
		operador = pOperador;
	}
	
	public String toString()
	{
		return "Celular "+operador.name()+" - "+"Gama "+gama  +"($ "+precio + ")";
	}

}
