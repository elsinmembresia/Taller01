package Taller01;
//Alvaro Sebastian Orrego Ramírez RUT:22185824-7  Carrera: ITI
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
				
				
				
			
				String opUsuario;
				int menuUsuario=0;
				do {
					//ingreso de menu usuario
					System.out.print("Bienvenido ");
					System.out.println(respuestaUsuario);
					System.out.println();
					System.out.println("¿Que deseas realizar?");
					System.out.println();
					System.out.println("1) Registrar actividad");
					System.out.println("2) Modificar actividad");
					System.out.println("3) Eliminar actividad");
					System.out.println("4) Cambiar contraseña");
					System.out.println("5) Salir");
					System.out.print(">");
					
					opUsuario=s.nextLine();
					menuUsuario= Integer.parseInt(opUsuario);
					
					//registrar acctividad
					try {
						Scanner archRegistroScan = new Scanner(archRegistro);

						// Lectura de "REgistro"
						while (archRegistroScan.hasNextLine()) {
							String linea = archRegistroScan.nextLine();
						}
	
					}catch(Exception e) {
						//En caso que el archivo no sea encontrado
						System.out.println("Error archivo Registros no se encuentra");
					}
					
					
					if (menuUsuario==1) {
						//Solicitar Actividad
						System.out.println();
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
							System.out.println("Error al momento de  abrir el archivo para escritura");
						} //fin try catch JAVA NO GUARDA NADA SI NO SE CIERRA EL ESCRITOR
						
						
					}//fin op1MU
					
					else if (menuUsuario==2) { // Modificar Actividad
						System.out.println("¿Cual actividad desear modificar?");
						
						int cont=0; //para el menu
						int numActividad;//para la actividad
						
						try {
							Scanner archRegistroScan = new Scanner(archRegistro);
							
							
							// Lectura de "REgistro"
							while (archRegistroScan.hasNextLine()) {
								String linea = archRegistroScan.nextLine();
								String[] partes =linea.split(";");
								String nombre= partes[0];
								if (nombre.equals(respuestaUsuario)) {
									if (cont ==0) {
										System.out.printf("%d) Regresar %n",cont); 
										cont++;
									}else {

										System.out.printf("%d) %s %n",cont,linea); //imprime registros del usuario
										cont++;
									}
								}

							}
							
							
						}catch(Exception e) {
							//En caso que el archivo no sea encontrado
							System.out.println("Error archivo Registros no se encuentra");
						}
						
						int indiceAct=0;
						
						
						System.out.println();
						System.out.print(">"); //elegir actividad
						int opRegistro;
						String registroOp = s.nextLine();
						opRegistro= Integer.parseInt(registroOp);
						String actividad="";
						if (opRegistro!=0) {
							try {
								Scanner archRegistroScan = new Scanner(archRegistro);
	
								
								while (archRegistroScan.hasNextLine()) {
									String linea = archRegistroScan.nextLine();
									String[] partes =linea.split(";");
									String nombre= partes[0];
									if (nombre.equals(respuestaUsuario)) {
										if (indiceAct==opRegistro) {
											actividad=linea;
										}
										indiceAct++;									
									}
								}
								archRegistroScan.close();
			
							}catch(Exception e) {
								//En caso que el archivo no sea encontrado
								System.out.println("Error archivo Registros no se encuentra");
							
							}
							System.out.println(actividad);
							System.out.println();
							System.out.println("¿Que desear modificar?");
							System.out.println("0) Regresar");
							System.out.println("1) Fecha");
							System.out.println("2) Duracion");
							System.out.println("3) Tipo de actividad");
							System.out.print(">");
							int menuModificar;
							
							String opModificar = s.nextLine();
							menuModificar= Integer.parseInt(opModificar);
							if (menuModificar==0) {
								//pendiente Regresar
								
							} else if (menuModificar==1) {//menu fecha
								
								System.out.println("0) Regresar");
								System.out.print("Ingrese nueva Fecha:");
								String respuestaFecha= s.nextLine();
								
								if (respuestaFecha.equals("0")) {
									//pendiente Regresar
									
								}else {
									try {
										FileWriter writerRegistro = new FileWriter("txts/Registros.txt", true); 
										BufferedWriter escritor =new BufferedWriter(writerRegistro); 
										//Escritura en el archivo
										
										Scanner archRegistroScan = new Scanner(archRegistro);
	
										
										while (archRegistroScan.hasNextLine()) {
											String linea = archRegistroScan.nextLine();
											
											if (linea.equals(actividad)) {
												String[] partes =linea.split(";");
												partes[1] = respuestaFecha ;
												linea = String.join(";", partes);							
											}
											escritor.newLine();
											escritor.write(linea);
										}
										archRegistroScan.close();
										escritor.close();
										
										
									} catch(Exception e2){
										System.out.println("Error al momento de  abrir el archivo para escritura");
									} 
									
								}
	
								
							}else if (menuModificar==2) { //menu duracion
								System.out.println("0) Regresar");
								System.out.print("Ingrese nueva Duracion:");
								String respuestaDuracion= s.nextLine();
								
								if (respuestaDuracion.equals("0")) {
									//pendiente Regresar
								}else {
									try {
										FileWriter writerRegistro = new FileWriter("txts/Registros.txt", true); //cada vez que quieras escribir un archivo hay que hacer un "FileWriter" (El True es para que empieze desde la ultima linea)
										BufferedWriter escritor =new BufferedWriter(writerRegistro); // despues se usa como este
										//Escritura en el archivo
										
										Scanner archRegistroScan = new Scanner(archRegistro);
	
										
										while (archRegistroScan.hasNextLine()) {
											String linea = archRegistroScan.nextLine();
											
											if (linea.equals(actividad)) {
												String[] partes =linea.split(";");
												partes[2] = respuestaDuracion ;
												linea = String.join(";", partes);							
											}
											escritor.newLine();
											escritor.write(linea);
										}
										archRegistroScan.close();
										escritor.close();
										
										//IMPORTANTE CADA VEZ QUE SE RESCRIBA ALGO RECUERDA QUE SE GUARDA EN EL TXT
										
									} catch(Exception e2){
										System.out.println("Error al momento de  abrir el archivo para escritura");
									} 
									
								}
								
							}else if (menuModificar==3) { //menu tipo de actividad
								System.out.println("0) Regresar");
								System.out.print("Ingrese nuevo tipo de actividad:");
								
								String respuestaTipoAct= s.nextLine();
								
								if (respuestaTipoAct.equals("0")) {
									//pendiente Regresar
								}else {
									try {
										FileWriter writerRegistro = new FileWriter("txts/Registros.txt", true); 
										BufferedWriter escritor =new BufferedWriter(writerRegistro); 
										
										Scanner archRegistroScan = new Scanner(archRegistro);
	
										
										while (archRegistroScan.hasNextLine()) {
											String linea = archRegistroScan.nextLine();
											
											if (linea.equals(actividad)) {
												String[] partes =linea.split(";");
												partes[3] = respuestaTipoAct ;
												linea = String.join(";", partes);
											}
											escritor.newLine();
											escritor.write(linea);
										}
										archRegistroScan.close();
										escritor.close();
										
										
										
									} catch(Exception e2){
										System.out.println("Error al momento de  abrir el archivo para escritura");
									} 
									
								}
								
							}
						}
					}//fin op2MU
					
					//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
					
					else if (menuUsuario==3) {
						System.out.println("¿Cual actividad desea eliminar?");
						
						int cont=0; //para el menu
						int numActividad;//para la actividad
						
						try {
							Scanner archRegistroScan = new Scanner(archRegistro);
							
							
							// Lectura de "REgistro"
							while (archRegistroScan.hasNextLine()) {
								String linea = archRegistroScan.nextLine();
								String[] partes =linea.split(";");
								String nombre= partes[0];
								if (nombre.equals(respuestaUsuario)) {
									if (cont ==0) {
										System.out.printf("%d) Regresar %n",cont); 
										cont++;
									}else {

										System.out.printf("%d) %s %n",cont,linea); //imprime registros del usuario
										cont++;
									}
								}

							}
							
							
						}catch(Exception e) {
							//En caso que el archivo no sea encontrado
							System.out.println("Error archivo Registros no se encuentra");
						}
						
						int indiceAct=0;
						
						
						System.out.println();
						System.out.print(">"); //elegir actividad
						int opRegistro;
						String registroOp = s.nextLine();
						String actividad="";
						opRegistro= Integer.parseInt(registroOp);
						
						if (opRegistro!=0) {
							try {
								Scanner archRegistroScan = new Scanner(archRegistro);
								FileWriter writerRegistro = new FileWriter("txts/Registros.txt", true); 
								BufferedWriter escritor =new BufferedWriter(writerRegistro);
								
								while (archRegistroScan.hasNextLine()) {
									String linea = archRegistroScan.nextLine();
									String[] partes =linea.split(";");
									String nombre= partes[0];
									if (nombre.equals(respuestaUsuario)) {
										if (indiceAct==opRegistro) {
											actividad=linea;
										}
										indiceAct++;									
									}
								}
								System.out.println(actividad);
								//sistema de borrado
								try {
									
									Scanner sistemaBorrado = new Scanner(archRegistro);

									while (sistemaBorrado.hasNextLine()) {
										String linea = sistemaBorrado.nextLine();
										
										System.out.println(linea);
										
										if (linea.equals(actividad)) {
											System.out.println(linea);
											linea = String.join(";", "");
											System.out.println(linea);
										}
										
									}
									archRegistroScan.close();
									escritor.close();
									
									
									
								} catch(Exception e2){
									System.out.println("Error al momento de  abrir el archivo para escritura");
								} 
								
								
								archRegistroScan.close();
								}catch(Exception e) {
									System.out.println("Error archivo Registros no se encuentra");
								}
							
							}	
						
						
						
					}//fin op3MU
					
					else if (menuUsuario==4) {
						
					}//fin op4MU
					
					else if (menuUsuario==5) { //op5MU
						break;
					}
				}while (menuUsuario!=5);
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
