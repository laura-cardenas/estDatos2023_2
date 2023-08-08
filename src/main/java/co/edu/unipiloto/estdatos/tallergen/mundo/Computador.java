package co.edu.unipiloto.estdatos.tallergen.mundo;

public class Computador extends Electronico{
	
	public enum SistemaOperativo
	{
		WINDOWS, MACOS, LINUX
	}
	
	private SistemaOperativo sistemaOperativo;
	
	public Computador(Gama pGama, double pPrecio, SistemaOperativo psistemaOperativo)
	{
		super(pGama, pPrecio);
		sistemaOperativo = psistemaOperativo;
	}
	
	public String toString()
	{
		return "Computador "+sistemaOperativo.name()+" - "+"Gama "+gama+ "($ "+precio + ")";
	}
        

}
