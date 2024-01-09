
public class FichaDomino {

	//atributos
	private int extremo1;
	private int extremo2;
	
	//constructor
	public FichaDomino (int extremo1, int extremo2) {
		this.extremo1 = extremo1;
		this.extremo2 = extremo2;
	}
	
	public int getExtremo1() {
		return extremo1;
	}
	
	public int getExtremo2() {
		return extremo2;
	}
	
	public static boolean esValida(int extremo1, int extremo2) {
		if (extremo1 >= 0 && extremo1 <= 6 && extremo2 >= 0 && extremo2 <= 6 ) {
			return true;
		}
		else {
			return false;
		}
	}
	public String obtenerEstado() {
		return
				String.format("[%d|%d]", extremo1, extremo2);
		
	}
	public boolean esdoble() {
		if (extremo1 == extremo2) {
			return true;
		}
		else {
			return false;
		}
	}
	public int calcularPuntuacion() {
		return 
	     (this.extremo1 + this.extremo2);
		
		 
	}
	public boolean puedeColocarseAlLado(FichaDomino ficha2) {
		if ( this.extremo1 == ficha2.extremo1 || this.extremo1 == ficha2.extremo2 ||this.extremo2 == ficha2.extremo1 || this.extremo2 == ficha2.extremo2 ) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
}
