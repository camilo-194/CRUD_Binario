
import java.util.ArrayList;

public class DAO {


public void  create(estudiante personaNueva) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<estudiante> listaBaseDatos = Base.getListaPersonas();
        
           File f = new File ("datos_estudiantes.dat");
            if(!f.exists()) f.createNewFile();
        
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
        os.close();
        
        estudiante personaBuscada = read(personaNueva.getCorreoinstitucional());
        if(personaBuscada == null){ 
            listaBaseDatos.add(personaNueva);
                  
         
            
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
                for (estudiante e : listaBaseDatos) {
                    dos.writeUTF(e.getNombres());
                    dos.writeUTF(e.getApellidos());
                    dos.writeUTF(e.getFechaNacimiento());
                    dos.writeUTF(e.getCorreoinstitucional());
                    dos.writeUTF(e.getCorreopersonal());
                    dos.writeLong(e.getTelefonocelular());
                    dos.writeLong(e.getTelefonofijo());
                    dos.writeUTF(e.getPrograma());
                }
                
            }
        }
}
        
    public estudiante read(String correoinstitucional) throws FileNotFoundException, IOException, ClassNotFoundException{
        
            ArrayList<estudiante> listaBaseDatos = Base.getListaPersonas();;
        
            File f = new File ("datos_estudiantes.dat");
        
            if(!f.exists()) throw new FileNotFoundException("Fichero no encontrado");
            
            DataInputStream dis = new DataInputStream(new FileInputStream (f));
            
            
            boolean salir = false;
            
            do{
                try{  
                    String Nombres = dis.readUTF();
                    String Apellidos = dis.readUTF();
                    String FechaNacimiento = dis.readUTF();
                    String Correoinstitucional = dis.readUTF();
                    String Correopersonal = dis.readUTF();
                    Long Telefonocelular = dis.readLong();
                    Long  Telefonofijo = dis.readLong();
                    String Programa = dis.readUTF();
                    
                    
                    estudiante e = new estudiante();
                    
                    e.setNombres(Nombres);
                    e.setApellidos(Apellidos);
                    e.setFechaNacimiento(FechaNacimiento);
                    e.setCorreoinstitucional(Correoinstitucional);
                    e.setCorreopersonal(Correopersonal);
                    e.setTelefonocelular(Telefonocelular);
                    e.setTelefonofijo(Telefonofijo);
                    e.setPrograma(Programa);
                    
                    if(listaBaseDatos==null) listaBaseDatos = new ArrayList<estudiante>();
                    listaBaseDatos.add(e);
                    
                        
                } 
                catch(EOFException e){
                    salir = true;
                                       
                }
            }while(!salir);
                

            for(int i=0; i < listaBaseDatos.size(); i++){
            estudiante personaDeLista = listaBaseDatos.get(i);
            if(personaDeLista.getCorreoinstitucional().equals(correoinstitucional)){
                return  personaDeLista;
            }
        }
            
          
            return null;
                            
    }    
        
  
    /**
     * Metodo para actualizar un estudiante
     * @param personaAActualizar datos del estudiante que se modifican
     * @param indice posicion del objeto a modificar
     * @return el objeto modificado
     */
    
    
    public estudiante update(estudiante personaAActualizar, int indice){
        
           
        ArrayList<estudiante> listaBaseDatos = Base.getListaPersonas();
         return listaBaseDatos.set(indice, personaAActualizar);
         
    }
    
    public void delete(estudiante personaABorrar){
        ArrayList<estudiante> listaBaseDatos = Base.getListaPersonas();
        listaBaseDatos.remove(personaABorrar);
        
        
               
    }    
    
    /**
     * Metodo que permite buscar si el estudiante esta en la lista
     * @param correoinstitucional del estudiante
     * @return True si lo encuentra - False si no lo encuenta
     */
    
    public boolean validar(String correoinstitucional) { 
        boolean encontroestudiante = false ;
        ArrayList<estudiante> listaPersonas = Base.getListaPersonas();
        for (estudiante e:listaPersonas){
            if (e.getCorreoinstitucional().equals(correoinstitucional) ){
                encontroestudiante = true;
                break;
            }   
        }
        return encontroestudiante;
        
               
    }


    public int obtenerindicador (estudiante e){
        ArrayList<estudiante> listaPersonas = Base.getListaPersonas();
        return listaPersonas.indexOf(e);
    }

    
    public ArrayList<estudiante> obtenerestudiantes () throws FileNotFoundException, IOException{
        
        ArrayList<estudiante> listaBaseDatos = Base.getListaPersonas();;
        
         File f = new File ("datos_estudiantes.dat");
        
            if(!f.exists()) throw new FileNotFoundException("Fichero no encontrado");
            
            DataInputStream dis = new DataInputStream(new FileInputStream (f));
            
            
            boolean salir = false;
            
            do{
                try{  
                    String Nombres = dis.readUTF();
                    String Apellidos = dis.readUTF();
                    String FechaNacimiento = dis.readUTF();
                    String Correoinstitucional = dis.readUTF();
                    String Correopersonal = dis.readUTF();
                    Long Telefonocelular = dis.readLong();
                    Long  Telefonofijo = dis.readLong();
                    String Programa = dis.readUTF();
                    
                    
                    estudiante e = new estudiante();
                    
                   // e.setNombres(Nombres);
                    //e.setApellidos(Apellidos);
                    //e.setFechaNacimiento(FechaNacimiento);
                    //e.setCorreoinstitucional(Correoinstitucional);
                    //e.setCorreopersonal(Correopersonal);
                    //e.setTelefonocelular(Telefonocelular);
                    //e.setTelefonofijo(Telefonofijo);
                    //e.setPrograma(Programa);
                   
                                                        
                } 
                catch(EOFException e){
                    salir = true;
                                       
                }
            }while(!salir);
        
        
        return listaBaseDatos;
        
    }
    
}
    
    