package co.edu.unipiloto.estdatos.tallergen.mundo;



public class Electronico extends Producto{
	
	public enum  Gama {
		ALTA, MEDIA, BAJA
	}
	
	protected Gama gama;
	
	public Electronico(Gama pGama,double pPrecio)
	{
		super(pPrecio);
		gama = pGama;
                precio = pPrecio;
	}

}
