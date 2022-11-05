package question4;

import java.util.List;
import java.util.ArrayList;

/** DAO/CRUD : un "DAO" (Data Access Object ) 
 *  qui propose les 4 operations elementaires Create Retrieve Update Delete (+ findAll)
 *  @param <T> pour Le type souhaite
 *  @param <ID> pour l'identifiant, en general unique, par instance de T
 */
public interface DAO<T,ID>{

   /** Creation de l'instance t en BDD.
    * @param t l'instance de T
    * @throws Exception si l'operation est en echec
    */
   public void create(T t) throws Exception;
   
   /** Permet de retrouver une instance de T a  partir de son identifiant.
    * @param id l'identifiant associe a  t
    * @return l'instance associee
    * @throws Exception si l'operation est en echec
    */
   public T retrieve(ID id) throws Exception;
   
   /** Obtention de la liste des elements.
    * @return la liste ordonnee selon l'ordre des enregistrements (des create)
    * @throws Exception si l'operation est en echec
    */
   public List<T> findAll() throws Exception;
   
   /** Mise a  jour de t dans la base.
    * @param t instance de T, existante
    * @throws Exception si l'operation est en echec
    */
   public void update(T t) throws Exception;
   
   /** Retrait de t dans la base.
    * @param id l'identifiant associe a  t
    * @throws Exception si l'operation est en echec
    */   
   public void delete(ID id) throws Exception;
   
     /** Critere de selection d'elements de type T. */
   public interface Criteria<T>{
       public boolean isTrue(T t);
   }
   
   /** Filtrage des elements selon le critere transmis.
    * 
    * @param criteria le critere de selection
    * @return la liste des elements satisfaisant le critere
    */
   public List<T> filter(Criteria<T> criteria) throws Exception;
   
   /** Une classe interne et static pour une implementation toute prete de filter.
    */
   public static class DAOUtils{
     public  static <T,ID> List<T> filter(DAO<T,ID> dao, Criteria<T> criteria) throws Exception{
           List<T> list = new ArrayList<T>();
           for(T t: dao.findAll()){
               if(criteria.isTrue(t))
                   list.add(t);
           }   
           return list;
         }
    }
   
}


