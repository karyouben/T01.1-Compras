package fp.compras.test;

import java.time.LocalDateTime;

import fp.compras.*;

public class TestCompra {

	public static void main(String[] args) {
		//String dni, String supermercado, String provincia, LocalDateTime fechaLlegada,
		//LocalDateTime fechaSalida, Double totalCompras
		LocalDateTime fechaLlegada = LocalDateTime.of(2022,2,10,15,36,0);
		LocalDateTime fechaSalida = LocalDateTime.of(2022,2,10,16,00,0);
		Compra c = new Compra("47241165Q","Aldi","Sevilla",fechaLlegada,fechaSalida,20.40);
		System.out.println(fechaLlegada);
		System.out.println(fechaSalida);
		System.out.println(c);
		
		int n = 5; //No creo objetos, tipo básico
		Integer n2 = 5; // Creo un objeto de tipo Integer
		// System.out.println(n2.dobleValue());
	}

}
