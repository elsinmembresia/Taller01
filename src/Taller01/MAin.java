package Taller01;
//Alvaro Sevastian Orrego Ramírez RUT:22185824-7  Carrera: ITI
//Anita Constanza Rojas Urrutia RUT: 22286335-K  Carrera: ITI

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class MAin {
	
	
	public static void main(String[] args) {
	// crear para archivos
		File archUsuario= new File ("txts/Usuarios.txt");
		File archRegistro=new File ("txts/Registros.txt");
		

		//definir el Scanner "Input"
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

			//seleccion de menu 
			if(menuPrincipal==1) {
				
				
				//definir si existe el usuario y crear la posicion del dato
				boolean existeUsuario=false;
				boolean existeContra=false;
				
				String respuestaUsuario;
				
				//ciclo si no existe el usuario
				do{
					
					System.out.print("Ingrese Usuario: ");
					
					respuestaUsuario = s.nextLine();
					
					System.out.print("Ingrese Contraseña: ");
					String respuestaContra= s.nextLine();
					
					
					
					try {
						// definir scanner de "Usuario"
						Scanner archUsuarioScan = new Scanner(archUsuario);
					
						
						// Lectura de "Usuario"
						while (archUsuarioScan.hasNextLine()) {
							
							String linea = archUsuarioScan.nextLine();
							String[] partes =linea.split(";");
							String nombre= partes[0]; 
							String contraseña=partes[1];
							

							
							//Preguntar por igualdad de nombre
							if(respuestaUsuario.equals(nombre)&& respuestaContra.equals(contraseña)) {
								existeUsuario=true;
								existeContra=true;
								System.out.println("Usuario encontrado");
								
							}
								
						}// fin while
						
						
						if (!existeUsuario && !existeContra) { //control de error contraseña y/o usuario
							System.out.println("Usuario y/o Contraseña incorrectos");
							
						}
						
					} catch(Exception e) {
						//En caso que el archivo no sea encontrado
						System.out.println("Error archivo Usuarios no se encuentra");
					}
					
				} while(!existeUsuario && !existeContra) ;
				
				
				System.out.print("Bienvenido ");
				System.out.println(respuestaUsuario);
				System.out.println();
				System.out.println("¿Que deseas realizar?");
				System.out.println();
				System.out.println("1) Registrar actividad");
				System.out.println("2) Modificar");
				System.out.println("1) Eliminar actividad");
				System.out.println("2) Modificar");
				System.out.println("5) Salir");
				System.out.print(">");
				
				//ingreso de menu usuario
				String opUsuario;
				int menuUsuario=0;
				do {
					opUsuario=s.nextLine();
					menuUsuario= Integer.parseInt(opUsuario);
					
					//registrar acctividad
					try {
						Scanner archRegistroScan = new Scanner(archRegistro);
						
						
						// Lectura de "REgistro"
						while (archRegistroScan.hasNextLine()) {
							String linea = archRegistroScan.nextLine();
							String[] partes =linea.split(";");

						}
						
						
					}catch(Exception e) {
						//En caso que el archivo no sea encontrado
						System.out.println("Error archivo Registros no se encuentra");
					}
					
					
					if (menuUsuario==1) {
						//Solicitar Actividad
						System.out.println("Registre actividad con el formato (Fecha(00/00/0000);Horas;Actividad) ");
						System.out.print(">");
						String nuevaAct = s.nextLine();
						
						
						//definir las maneras de escribir texto
						try {
							FileWriter writerRegistro = new FileWriter("txts/Registros.txt", true); //cada vez que quieras escribir un archivo hay que hacer un "FileWriter" (El True es para que empieze desde la ultima linea)
							BufferedWriter escritor =new BufferedWriter(writerRegistro); // despues se usa como este
							//Escritura en el archivo
							
							escritor.newLine();
							escritor.write(respuestaUsuario + ";" + nuevaAct);
							escritor.close();
							
							//IMPORTANTE CADA VEZ QUE SE RESCRIBA ALGO RECUERDA QUE SE GUARDA EN EL TXT
							
						} catch(Exception e2){
							System.out.println("Error al momento de  abrir elarchivo para escritura");
						} //fin try catch JAVA NO GUARDA NADA SI NO SE CIERRA EL ESCRITOR
						
						
					}//fin op1MU
					
					else {
						break;
					}
					
				}while (menuUsuario!=1 && menuUsuario!=2 && menuUsuario!=3 &&menuUsuario!=4 && menuUsuario!=5);
				//control de menu de usuario
				
				
			}//fin op1MP
			//opcion de "Salir"
			else if(menuPrincipal==3) {
				break;
			}
			menuPrincipal=-1;	
		}while (menuPrincipal!=1 && menuPrincipal!=2 && menuPrincipal!=3 );
		 
		
		
		
		
		
		

	}

}
