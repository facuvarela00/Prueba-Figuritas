package FiguritasPackage;

import java.util.Scanner;

public class Qatar2022 {
	
	private static final int ACTUALIZAR_DATOS_FIGURITA = 1, COMPRAR_SOBRE = 2, VISUALIZAR_FIGURITAS_ACTUALES = 3, CALCULAR_PORCENTAJE_DE_COMPLETADO = 4, SALIR = 9;
	
	public static void main(String[] args) {
		
		Album actual = new Album(); /*Crea album*/
		Album.inicializarCodigosDeFiguritas(); //Crea todos los codigos para el vector de 704 posiciones
		
		int opcionIngresada;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Bienvenido album de figuritas Panini Virtual");

		do {
			mostrarMenu();
			opcionIngresada = teclado.nextInt();
			actual = determinarAccionARealizar(actual, opcionIngresada, teclado);
		}while (!actual.elAlbumEstaCompleto());
	}

	private static void mostrarMenu() {
		
		
		
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println(ACTUALIZAR_DATOS_FIGURITA + " - Actualizar datos de la figurita");
		System.out.println(COMPRAR_SOBRE + " - Comprar sobre ");
		System.out.println(VISUALIZAR_FIGURITAS_ACTUALES + " - Visualizar figuritas actuales");
		System.out.println(SALIR + " - Salir");
		System.out.println("************************");
	}

	private static Album determinarAccionARealizar(Album actual, int opcionIngresada, Scanner teclado) {

		switch(opcionIngresada) {
		case ACTUALIZAR_DATOS_FIGURITA:
			actualizardatosFigurita(teclado, actual);
			break;
		case COMPRAR_SOBRE:
			comprarSobre(teclado, actual);
			break;
		case VISUALIZAR_FIGURITAS_ACTUALES:
			visualizarFiguritasActuales(teclado, actual);
			break;
		case CALCULAR_PORCENTAJE_DE_COMPLETADO:
			calcularElPorcentajeDeCompletado(teclado, actual);
			break;
		case SALIR:
			break;
		}
		return actual;
	}

	private static void actualizardatosFigurita(Scanner teclado, Album actual) {
		String codigo;
		char grupo;
		String seleccion;
		String nombreJugador;
		double valor;
		Figurita aActualizar;

		System.out.println("***************");
		System.out.println("Actualizar datos de figurita");
		System.out.println("***************"); 

		System.out.println("Ingrese el codigo a actualizar");
		codigo = teclado.next(); //codigo ingresado manualmente
		aActualizar = Album.getFigurita(codigo); 
		if (aActualizar==null) {
			System.out.println("xD");
		}
		
		System.out.println("Selecci�n: " + aActualizar.getSeleccion());
		
		System.out.println("Ingrese el grupo al que pertenece la selecci�n");
		grupo = teclado.next().charAt(0);
		
		System.out.println("Ingrese el nombre del jugador");
		nombreJugador = teclado.next();
		System.out.println("Ingrese el valor");
		valor = teclado.nextDouble();
		System.out.println(Album.getFigurita(codigo));
		Album.actualizarDatosFigurita(codigo.toUpperCase(), grupo, nombreJugador, valor); //Actualiza la figurita luego de ingresar los datos a mano
		System.out.println(Album.getFigurita(codigo));
	}

	private static void comprarSobre(Scanner teclado, Album actual) {
		/*
		 * Mostrar las figuritas obtenidas
		 */
		System.out.println("Las figuritas son");
		Figurita compradas[] = actual.comprarSobre();
		
		for (int i=0;i<5;i++) {
			System.out.println(compradas[i]);
			actual.agregarFigurita(compradas[i]);
		}
		
		/* 
		 * Por cada figurita comprada, agregarlas al album actual actual.agregarFigurita(compradas[i]);
		 */
		
	}
	
	private static void visualizarFiguritasActuales(Scanner teclado, Album actual) {
		/*
		 * Se deben mostrar las figuritas que posee el usuario de manera ordenada.
		 */
	}
	
	private static void calcularElPorcentajeDeCompletado(Scanner teclado, Album actual) {
		System.out.println("El album est� completo en un " + actual.calcularPorcentajeCompletado() + "%");
	}
}