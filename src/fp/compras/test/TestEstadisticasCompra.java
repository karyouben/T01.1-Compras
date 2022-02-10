package fp.compras.test;



import java.util.List;

import fp.compras.Compra;
import fp.compras.EstadisticasCompra;
import fp.compras.FactoriaCompras;

public class TestEstadisticasCompra {

	public static void testCompraMaximaMinimaProvincia(EstadisticasCompra e, String provincia) {
		System.out.println("Las compras máximas y minimas de " + provincia + " son:");
		System.out.println(e.compraMaximaMinimaProvincia(provincia));
	}
	
	public static void testHoraMenosAfluencia(EstadisticasCompra e) {
		System.out.println("La hora de menos afluencia es: " + e.horaMenosAfluencia());
	}
	
	public static void testSupermercadosMasFacturacion(EstadisticasCompra e, Integer n) {
		System.out.println("Los supermercados de más facturación son: ");
		System.out.println(e.supermercadosMasFacturacion(n));
		
	}	
	
	
	public static void main (String [] args) {
		
		
		List<Compra> compras = FactoriaCompras.leeCompras("./data/compras.csv");
		EstadisticasCompra e = new EstadisticasCompra(compras);
		
		testCompraMaximaMinimaProvincia(e, "Sevilla");
		
		testHoraMenosAfluencia(e);
		
		testSupermercadosMasFacturacion(e, 5);
		
	}


}
