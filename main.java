package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean salir = false;
		conexionBD conexion = new conexionBD();
		conexion.login();
		while (!salir) {
			try {

				System.out.print(
						"\n0. SALIR \n" + "1. Consultar todos los empleados \n" + "2. Consultar empleados por DNI \n"
								+ "3. Consultar empleados que tengan un salario superior al introducido \n"
								+ "4. Consultar empleados que tengan un salario igual o inferior al introducido\n"
								+ "******ELIGE EL NUMERO DE LA PRACTICA******: ");

				int opcion = entrada.nextInt();
				entrada.nextLine();
				if (opcion == 0) {
					System.out.println("HEMOS SALIDO SATISFACTORIAMENTE");
					conexion.cerrarConexion();
					salir = true;
				} else if (opcion == 1) {
					System.err.println("**HAS ELEGIDO CONSULTAR TODOS LOS USUARIOS**");
					conexion.consulta1();
				} else if (opcion == 2) {
					System.out.println("**HAS ELEGIDO CONSULTAR SEGUN DNI**");
					conexion.consulta2();
				} else if (opcion == 3) {
					System.out.println("**HAS ELEGIDO CONSULTAR SALARIO SUPERIOR A:");
					conexion.consulta3();
				} else if (opcion == 4) {
					System.out.println("**HAS ELEGIDO CONSULTAR SALARIO IGUAL O INFERIOR A:");
					conexion.consulta4();
				} else {
					System.out.println("\nOpcion no contemplada en el menu. ");
				}
			} catch (InputMismatchException e) {
				System.err.println("\nDebes insertar un número\n");
				entrada.next();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		entrada.close();
	}

}
