
import java.util.ArrayList;



public class Controlador {
 
    private final DAO dao = new DAO();
    
    public void crearPersona(estudiante personaACrear){
        dao.create(personaACrear);        
    }
    
    public estudiante consultarPersona(String correoinstitucional){
        return dao.read(correoinstitucional);
    }
    
    public estudiante actualizarPersona(estudiante personaAActualizar, int indice){
       return dao.update(personaAActualizar,indice);
    }
    
    public void eliminarPersona(estudiante personaAEliminar){
        dao.delete(personaAEliminar);
    }
    
    public boolean validarPersona(String correoinstitucional){
        return dao.validar(correoinstitucional);
    }
    
    
   public int obtenerindice (estudiante e){
       
       return dao.obtenerindicador(e);
   }
 
   public ArrayList<estudiante> obtenerestudiante (){
       return dao.obtenerestudiantes();
   }

   
}