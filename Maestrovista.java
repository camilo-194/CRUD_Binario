

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
/**
 *
 * @author PERSONAL
 */
public class Maestrovista implements Serializable{

 
   public static void main(String[] args) throws FileNotFoundException, IOException {
       
        Scanner sc = new Scanner(System.in);
        int opcion;
     
        do {
            System.out.println("INSTITUTO LA FLORESTA");
            System.out.println("Seleccione tarea a realizar:");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Modificar estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Ver directorio de estudiantes");
            System.out.println("6. Salir");
            System.out.println("Opción:");
              
            
            
             opcion = sc.nextInt();

            switch (opcion) {
                case 1:    
                    
                    estudiante Estudiantes = new estudiante();
                    
                                   
                    sc.nextLine();
                    System.out.println("Ingresar estudiante");
                    System.out.println("Ingresar nombres:");
                    String nombres = sc.nextLine();
                    Estudiantes.setNombres(nombres);
                    
                    System.out.println("Ingresar apellidos:");
                    String apellidos = sc.nextLine();
                    Estudiantes.setApellidos(apellidos);
                    
                    
                    System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):");
                    String fechaNacimiento = sc.nextLine();
                    Estudiantes.setFechaNacimiento(fechaNacimiento)    ;

                    System.out.println("Ingresar correo institucional:");
                    String correoinstitucional = sc.next();
                    Estudiantes.setCorreoinstitucional(correoinstitucional);

                    System.out.println("Ingresar correo personal:");
                    String correopersonal = sc.next();
                    Estudiantes.setCorreopersonal(correopersonal); 
                   
                   try{

                    System.out.println("Ingresar número de celular:");
                    long telefonocel = sc.nextLong();
                    Estudiantes.setTelefonocelular(telefonocel);
                   }
                   catch (Exception e){
                    Estudiantes.setTelefonocelular(0);
                   }
                 
                    try{
                    System.out.println("Ingresar número fijo:");
                    long telefonofijo = sc.nextLong();
                   Estudiantes.setTelefonofijo(telefonofijo);
                    }
                   catch (Exception e){
                    Estudiantes.setTelefonofijo(0);
                   }
                
                    
                    System.out.println("Ingresar programa:");
                    String programa = sc.next();
                    Estudiantes.setPrograma(programa);
                  
                    System.out.println("Se agregó el estudiante");
                    
                    Controlador controler = new Controlador();
                    controler.crearPersona(Estudiantes);
                    
                     
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("datos_estudiantes.dat"));
                    os.writeObject(Estudiantes);
                    os.close();
                    
                   
                    break;

                case 2:
                    
                    System.out.println("Buscar estudiante");
                    System.out.println("Ingresar correo institucional:");
                    correoinstitucional = sc.next();

                    controler = new Controlador();

                    if (controler.validarPersona(correoinstitucional)) {

                        estudiante encontradosE = controler.consultarPersona(correoinstitucional);

                        System.out.println("Información del estudiante");
                        System.out.println("Nombres:" + encontradosE.getNombres());
                        System.out.println("Apellidos:" + encontradosE.getApellidos());
                        System.out.println("Fecha nacimiento:" + encontradosE.getFechaNacimiento());
                        System.out.println("Correo institucional:" + encontradosE.getCorreoinstitucional());
                        System.out.println("Correo personal:" + encontradosE.getCorreopersonal());
                        System.out.println("Número de teléfono celular:" + encontradosE.getTelefonocelular());
                        System.out.println("Número de teléfono fijo:" + encontradosE.getTelefonofijo());
                        System.out.println("Programa académico:" + encontradosE.getPrograma());
                    } else {
                        System.out.println("Estudiante no encontrado");
                    }

                    break;

                case 3:
                    System.out.println("Modificar estudiante");
                    System.out.println("Ingresar correo institucional:");
                    correoinstitucional = sc.next();

                    controler = new Controlador();
                    
                   
                    if (controler.validarPersona(correoinstitucional)) {
                        estudiante encontradosE = controler.consultarPersona(correoinstitucional);
                        int indice = controler.obtenerindice(encontradosE);
                        
                       System.out.println("Ingresar correo personal:"); 
                       encontradosE.setCorreopersonal(sc.next());
                       System.out.println("Ingresar número de celular:"); 
                       encontradosE.setTelefonocelular(sc.nextLong());
                       System.out.println("Ingresar número fijo:");
                       encontradosE.setTelefonofijo(sc.nextLong());
                       System.out.println("Ingresar programa:"); 
                       encontradosE.setPrograma(sc.next());
                       
                       
                       estudiante e = controler.actualizarPersona(encontradosE, indice);
                       if(e!= null)  { 
                        System.out.println("Se modificó el estudiante"); 
                       }
                       else {
                        System.out.println("Ocurrio un error intente de nuevo ");
                        
                       }
                                     
                    }
                    break;

                case 4:
                    
                    System.out.println("Eliminar estudiante");
                    System.out.println("Ingresar correo institucional:");
                    correoinstitucional = sc.next();

                    controler = new Controlador();
                    
                    if (controler.validarPersona(correoinstitucional)) {
                        estudiante encontradosE = controler.consultarPersona(correoinstitucional);
                        controler.eliminarPersona(encontradosE);
                        
                        System.out.println("Se eliminó el estudiante");
                        
                    }

                    break;
                    
                case 5:
                    
                    System.out.println("El directorio de los estudiantes");
                    controler = new Controlador();
                    
                    ArrayList<estudiante> directorio = controler.obtenerestudiante();
                    
                    for (estudiante e:directorio){
                    
                    System.out.println("Nombres:" + e.getNombres());
                    System.out.println("Apellidos:" + e.getApellidos());
                    System.out.println("Fecha nacimiento:" + e.getFechaNacimiento());
                    System.out.println("Correo institucional:" + e.getCorreoinstitucional());
                    System.out.println("Correo personal:" + e.getCorreopersonal());
                    System.out.println("Número de teléfono celular:" + e.getTelefonocelular());
                    System.out.println("Número de teléfono fijo:" + e.getTelefonofijo());
                    System.out.println("Programa académico:" + e.getPrograma());
                            
                    }      
                            
                    break;        
                            
                case 6:
                   
                    System.out.println("Hasta pronto");
                    
            }

        } while (opcion <= 5);

    }
}
