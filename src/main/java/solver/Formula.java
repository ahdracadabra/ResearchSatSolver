import java.util.ArrayList;


public class Formula{
    private ArrayList<Clause> clauses;

    public Formula(){
        clauses = new ArrayList<Clause>();
    }

    public Formula(Formula other){
        clauses = other.getClauses();
    }

    //public for testing
    public ArrayList<Clause> getClauses(){
        return clauses;
    }

    public void addClause(Clause santa){
        clauses.add(santa);
    }

    public void cleanUp(){
        int i = 0;
        while(i<clauses.size()){
            if((clauses.get(i).satisfied()) || clauses.get(i).empty()){
                clauses.remove(i);
            }
            else{
                i++;
            }
        }
    }

    public boolean satisfied(){
        return(clauses.size()==0? true: false);
    }
}