package question1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant>
{
    private List<Cotisant> aListe;

    public GroupeDeContributeurs( final String pNomDuGroupe )
    {
        super( pNomDuGroupe );
        this.aListe = new LinkedList<Cotisant>() ;
        
        // a completer
    } // GroupeDeContributeurs(.)

    public void ajouter( final Cotisant pCotisant )
    {
        this.aListe.add(pCotisant) ;
        pCotisant.setParent(this);
    } // ajouter(.)

    public int nombreDeCotisants()
    {
        int vNombre = 0;
        for(Cotisant cotisant : aListe) 
        	vNombre += cotisant.nombreDeCotisants() ;
        // a completer
        return vNombre; // pourquoi n'est-ce pas this.aListe.size() ?
    } // nombreDeCotisants()

    @Override public String toString()
    {
        String vStr = "<Grp="+super.nom()+" ";
        
        for(Cotisant cotisant : aListe) 
        	vStr += cotisant.toString() ;
        // a completer
        
        return vStr+" />";
    } // toString()

    public List<Cotisant> getChildren()
    {
    	return new ArrayList<Cotisant>(aListe) ;
    } // getChildren()
    
    
    public void setList(List<Cotisant> list) {
    	this.aListe = list ;
    }

    public void debit( final int pSomme ) throws SoldeDebiteurException
    {
    	for(Cotisant cot : aListe)
    		cot.debit(pSomme);
        // a completer
    } // debit(.)

    public void credit( final int pSomme )
    {
    	for(Cotisant cot : aListe)
    		cot.credit(pSomme);
        // a completer
    } // credit(.)

    public int solde()
    {
        int vSolde = 0;
        for(Cotisant cot : aListe)
    		vSolde += cot.solde() ;
        // a completer
        return vSolde;
    } // solde()

    // m�thodes fournies

    public Iterator<Cotisant> iterator()
    {
        return new GroupeIterator( this.aListe.iterator() );
    } // iterator()

    private class GroupeIterator implements Iterator<Cotisant>
    {
        private Stack<Iterator<Cotisant>> aStk;

        public GroupeIterator( final Iterator<Cotisant> pIterator )
        {
            this.aStk = new Stack<Iterator<Cotisant>>();
            this.aStk.push( pIterator );
        } // GroupeIterator(.)

        @Override public boolean hasNext()
        {
            if ( this.aStk.empty() )
                return false;

            Iterator<Cotisant> vIterator = this.aStk.peek();
            if( ! vIterator.hasNext() ) {
                this.aStk.pop();
                return this.hasNext();
            } else {
                return true;
            }
        } // hasNext()

       @Override public Cotisant next()
       {
            if ( this.hasNext() ) {
                Iterator<Cotisant> vIterator = this.aStk.peek();
                Cotisant vCpt = vIterator.next();
                if ( vCpt instanceof GroupeDeContributeurs ) {
                    GroupeDeContributeurs vGr = (GroupeDeContributeurs)vCpt;
                    this.aStk.push( vGr.aListe.iterator() );
                }
                return vCpt;
            } else {
                throw new NoSuchElementException();
            }
       } // next()

        @Override public void remove()
        {
            throw new UnsupportedOperationException();
        } // remove()
    } // GroupeIterator

    @Override public <T> T accepter( final Visiteur<T> pVisiteur )
    {
        return pVisiteur.visite( this );
    }
} // GroupeDeContributeurs
