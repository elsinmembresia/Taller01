package Taller01;
//Alvaro Sevastian Orrego Ramírez RUT:22185824-7

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MAin {
	public static void main(String[] args) {
	// crear para archivos
		File archUsuario= new File ("txts/Usuarios.txt");
		File archRegistro=new File ("txts/Registros.txt");
		

		//definir el Scanner "Imput"
		Scanner s = new Scanner (System.in);
		
		int menuPrincipal=0;
		String respuesta;
		
		do {  //para crear menu principal
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de Analisis");
			System.out.println("3) Salir");
			System.out.print(">");
			
			
			respuesta =s.nextLine(); //se lee en String porque si lo leiamos en int explota el siguiente Scanner 
			menuPrincipal= Integer.parseInt(respuesta); //por eso el cambio :D

			//seleccion de muenu 
			if(menuPrincipal==1) {
				
				
				//definir si existe el usuario y crear la posicion del dato
				boolean existeUsuario=false;
				
				
				//ciclo si no existe el usuario
				do{
					
					System.out.print("Ingrese Usuario: ");
					String respuestaUsuario; 
					respuestaUsuario = s.nextLine();
					
					//Guardar Posicion del dato 
					int posicionUsuario=-1;
					
					
					try {
						// definir scanner de "Usuario"
						Scanner archUsuarioScan = new Scanner(archUsuario);
					
						
						// Lectura de "Usuario"
						while (archUsuarioScan.hasNextLine()) {
							++posicionUsuario;
							String linea = archUsuarioScan.nextLine();
							String[] partes =linea.split(";");
							String nombre= partes[0]; //Aparentemente no puedo usar equals con una lisa >:C
							
							//Test
							System.out.println(partes[0]);
							System.out.println("buscando...");
							
							
							//Preguntar por igualdad de nombre
							if(respuestaUsuario.equals(nombre)) {
								existeUsuario=true;
								System.out.println("se ha encontrado");
				
							}
							
						}
						
					} catch(Exception e) {
						//En caso que el archivo no sea encontrado
						System.out.println("Error archivo Usuarios no se encuentra");
					}
					
				} while(!existeUsuario);
				
				
			}
			//opcion de "Salir"
			if(menuPrincipal==3) {
				break;
			}
				
		}while (menuPrincipal!=1 && menuPrincipal!=2 && menuPrincipal!=3 );
		 
		
		
		
		
		
		

	}

}
