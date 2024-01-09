import java.util.Comparator;

public class OrdenSociosDniAsc implements Comparator<Socio> {

	@Override
	public int compare(Socio socio1, Socio socio2) {
		String dni1 = socio1.getDni();
		String dni2 = socio2.getDni();
		return dni1.compareTo(dni2);
	}

}
