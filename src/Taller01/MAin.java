package Taller01;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MAin {
	public static void main(String[] args) {
	// crear para archivos
		File archUsuario= new File ("d:/txts/Usuarios.txt");
		
		File archRegistro=new File ("d:/txts/Registros.txt");
		Scanner s = new Scanner (System.in);
		int menuPrincipal;
		
		do {  //para crear menu principal
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de Analisis");
			System.out.println("3) Salir");
			
			menuPrincipal= s.nextInt();
			
			while (menuPrincipal!=3) { //crear los 2 menus
				
				
				
				
			}
			
			
			
			
		}while (menuPrincipal!=1 && menuPrincipal!=2 &&menuPrincipal!=3 );
		
		 
		
		
		
		
		
		

	}

}
