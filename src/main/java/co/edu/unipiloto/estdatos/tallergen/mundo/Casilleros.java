package co.edu.unipiloto.estdatos.tallergen.mundo;

public class Casilleros<T> {

	private Casillero c1;
	private Casillero c2;

	public Casilleros()
	{
		c1=new Casillero<>();
		c2=new Casillero<>();

	}


	public int almacenar(Producto producto) {

		if(c1.estaDesocupado())
		{
			c1.agregar(producto);
			return 1;
		}
		else if(c2.estaDesocupado())
		{
			c2.agregar(producto);
			return 2;
		}
		return -1;
	}

	public T despachar(int num) {

		switch(num)
		{
		case 1: return (T) c1.despachar();
		case 2: return (T) c2.despachar();
		}
		return null;
	}

	public void verProductos() {
		// TODO Auto-generated method stub
		if(c1.darProducto()!=null)
		{
			System.out.println("[Casillero 1] "+c1.darProducto().toString());
		}
		else
		{
			System.out.println("[Casillero 1] Vacío");
		}

		if(c2.darProducto()!= null)
		{
			System.out.println("[Casillero 2] "+c2.darProducto().toString());
		}
		else
		{
			System.out.println("[Casillero 2] Vacío");
		}

	}

}
