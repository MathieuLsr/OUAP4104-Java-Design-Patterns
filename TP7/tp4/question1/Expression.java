package tp4.question1;

/**
 * Une expression arithm�tique
 */
public abstract class Expression implements java.io.Serializable {

  public abstract <T> T accepter(VisiteurExpression<T> v);

}