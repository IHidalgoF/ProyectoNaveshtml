package Naves;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {

	public static int pideDatoNumerico(String texto) {
		System.out.println(texto);
		Scanner teclado = new Scanner(System.in);
		int entrada = teclado.nextInt();
		return entrada;
	}
	
	public static Date pideDatoDate(String texto) {
		System.out.println(texto);
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha=null;
        try {
            fecha = format.parse(teclado.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
	}

	public static String pideDatoCadena(String texto) {
		System.out.println(texto);
		Scanner teclado = new Scanner(System.in);
		String entrada = teclado.nextLine();
		return entrada;
	}
	
	public static double pideDatoDecimal(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		double numero = scan.nextInt();
		
		return numero;
	}

	public static void pintaMenu(String menu) {
		System.out.println(menu);
	}
	
	public static void pintaMenu (String[] menuArray, String texto) {

		for (String opcion : menuArray) {
			System.out.println(opcion);
		}
		System.out.println(texto);
	}
}
