
public class AdivinaNumeroMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdivinaNumero an = new AdivinaNumero();
		
		while(true) {
			String opcion = an.menuInicio();
			if(opcion.equals("1")) {
				an.juego();
			}else if(opcion.equals("2")) {
				break;
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
	}

}
