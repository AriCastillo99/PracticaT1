import java.util.Scanner;

public class PracticaT1 {	
	
	public static void main(String [] args) {
		
		Scanner comando = new Scanner(System.in);
		int tamano, respuesta;
		float[] calificaciones = null;
		float resultado;
		String[] nombres = null;
		
		System.out.println("Ingrese el tamaño del grupo: ");
		tamano = comando.nextInt();
		
		mostrarMenu();
	
		do {
			
			System.out.println("\n Ingrese opcion (Mostrar menu [5]): ");

			
		respuesta = comando.nextInt();
		switch (respuesta) {
			case 1:
				nombres = CapturaNom(tamano);
				calificaciones = capturaCal(tamano);
			break;
			case 2:
				resultado = promedio(calificaciones, tamano);
				for(int i=0; i < tamano ; i++) 
					System.out.println(nombres[i] + "\t-\t" + calificaciones[i]);
				System.out.println("PROMEDIO GENERAL: \t" + resultado);
				;
			break;
			case 3:
				resultado = masbajo(calificaciones, tamano);
				for(int i=0; i < tamano ; i++) 
					System.out.println(nombres[i] + "\t-\t" + calificaciones[i]);
				System.out.println("CALIFICACION MAS BAJA: \t" + resultado);
			break;
			case 4:
				resultado = masalto(calificaciones, tamano);
				for(int i=0; i < tamano ; i++) 
					System.out.println(nombres[i] + "\t-\t" + calificaciones[i]);
				System.out.println("CALIFICACION MAS ALTA: \t" + resultado);;
			break;
			case 5:
				mostrarMenu();
			break;
			
		}
		
		} while (respuesta != 6);
	}
	
	
	
	
	public static float[] capturaCal(int tamano){
		float[] calificaciones = new float [tamano];
		Scanner comando = new Scanner(System.in);
		
		for (int i=0; i < tamano; i++) {
			System.out.println("\nIngrese calificacion: ");
			calificaciones[i]=comando.nextFloat();
		}
		return calificaciones;
	}
	
	
	public static String[] CapturaNom(int tamano) {
		String[] nombres= new String[tamano];
		Scanner comando = new Scanner(System.in);
		
		for (int i=0; i < tamano; i++) {
			System.out.println("\nIngrese nombre: ");
			nombres[i]=comando.nextLine();
		}
		
		return nombres;
	}
	
	
	private static float promedio(float calificaciones[], int tamano){
		float suma = 0;
		for (int i=0; i < tamano; i++)
			suma += calificaciones[i];
		
		float prom = suma/tamano;
		
		return prom;
	}
	
	private static float masalto(float[] calificaciones, int tamano){
		float alto = calificaciones[0];
		for (int i=0; i < tamano-1; i++)
			if (calificaciones[i+1] > calificaciones[i])
				alto = calificaciones[i+1];
		return alto;
	}
	
	private static float masbajo(float[] calificaciones, int tamano) {
		float bajo = calificaciones[0];
		for (int i=0; i < tamano-1; i++)
			if (calificaciones[i+1] < calificaciones[i])
				bajo = calificaciones[i+1];
		return bajo;
	}
	
	private static void mostrarMenu() {
		System.out.println("\n\n\t |-------------[MENU]-------------|");
		System.out.println("\n 1) Captura de nombre y calificaciones.");
		System.out.println("\n 2) Imprimir calificaciones y promedio de calificaciones. ");
		System.out.println("\n 3) Imprimir calificaciones y calificacion mas baja. ");
		System.out.println("\n 4) Imprimir calificaciones y calificacion mas alta. ");
		System.out.println("\n 6) Salir. ");
	}
	
}