package fp.compras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EstadisticasCompra {
	
	private List<Compra> compras;

	public EstadisticasCompra(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticasCompra other = (EstadisticasCompra) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s= compras.stream()
					.map(Compra::toString)
					.collect(Collectors.joining(",\n"));
		return "EstadisticasCompra [compras=" + compras + "]";
	}

	
	public List<Double> compraMaximaMinimaProvincia(String provincia){
		DoubleSummaryStatistics st=		compras.stream()
					.filter(compra->compra.getProvincia().equals(provincia))
					.collect(Collectors.summarizingDouble(Compra::getTotalCompra));
		List<Double> res = new ArrayList<Double>();
		res.add(st.getMax());
		res.add(st.getMin());
		return res;
	}
	
	public Integer horaMenosAfluencia () {
		Map<Integer, Long> conteo = contarComprasPorHora(); 
		
		Comparator<Map.Entry<Integer, Long>> c = Map.Entry.comparingByValue();
		return conteo.entrySet().stream()
					.min(c)
					.get()
					.getKey();
	}
	
	private Map<Integer, Long> contarComprasPorHora(){
		return compras.stream()
					.collect(Collectors.groupingBy(compra->compra.getFechaLlegada().getHour(),
												   Collectors.counting()));
	}

	public List<String> supermercadosMasFacturacion (Integer n){
		Map<String, Double> acum = acumularComprasPorSupermercado();
		Comparator<Map.Entry<String, Double>> c = Map.Entry.comparingByValue(); 
		return acum.entrySet().stream()
				.sorted(c.reversed())
				.limit(n)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());		
	}
	
	private Map<String, Double> acumularComprasPorSupermercado(){
		return compras.stream()
				.collect(Collectors.groupingBy(Compra::getSupermercado,
										Collectors.summingDouble(Compra::getTotalCompra)));
					
	}

}
