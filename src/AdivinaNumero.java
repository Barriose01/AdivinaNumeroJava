import java.util.*;
public class AdivinaNumero {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	String opcion = "";
	int parseOpcion = 0;

	public void juego() {
		System.out.print("\nDame tu nombre: ");
		String nombre = sc.nextLine();
		System.out.println("\nBienvenido, " + nombre.toUpperCase() + ". Adivina un numero del 1 al 20");
		System.out.println("Tiene 5 intentos");
		System.out.println("Presione el numero cero (0) en cualquier momento para salir");
		int numeroSecreto = rd.nextInt((20 - 1) + 1) + 1;
		String juegoGanado = "";
		int n = 0;
		while(n < 5) {
			System.out.println("\nINTENTO #" + (n + 1));
			System.out.print("Ingrese un numero del 1 al 20: ");
			try {
				opcion = sc.nextLine().strip();
				parseOpcion = Integer.parseInt(opcion);
			}catch(Exception e) {
				System.out.println("Ingrese un numero valido");
				continue;
			}
			if(parseOpcion == 0) {
				break;
			}else if(parseOpcion < 0 || parseOpcion > 20) {
				System.out.println("Ingrese un numero en el rango especificado");
			}else if(parseOpcion < numeroSecreto) {
				n+= 1;
				if(n != 5) {
					System.out.println("Un poco bajo. Intentelo de nuevo");
				}else {
					juegoGanado = "F";
				}
			}else if(parseOpcion > numeroSecreto) {
				n+= 1;
				if(n != 5) {
					System.out.println("Un poco alto. Intentelo de nuevo");
				}else {
					juegoGanado = "F";
				}
			}else if(parseOpcion == numeroSecreto) {
				juegoGanado = "V";
				break;
			}
		}
		this.resultados(juegoGanado,nombre,n,numeroSecreto);
	}
	
	private void resultados(String resultado, String nombre, int intentos, int numeroSecreto) {
		if(resultado == "V") {
			System.out.println("\nFelicidades, " + nombre.toUpperCase() + "!. Adivinaste el numero secreto en " + (intentos +1) + " intentos");
		}else if(resultado == "F") {
			System.out.println("\nNo adivinaste el numero. El numero correcto era: " + numeroSecreto);
		}
	}
	
	public String menuInicio() {
		System.out.println("\n(1): Jugar");
		System.out.println("(2): Salir");
		opcion = sc.nextLine().strip();
		return opcion;
	}
	

}
