import java.util.ArrayList;


public class Formula{
    private ArrayList<Clause> clauses;

    public Formula(){
        clauses = new ArrayList<Clause>();
    }

    public Formula(Formula other){
        clauses = other.getClauses();
    }

    private ArrayList<Clause> getClauses(){
        return clauses;
    }

    public void addClause(Clause santa){
        clauses.add(santa);
    }

    public void cleanUp(){
        for (Clause clause : clauses) {
            if(clause.satisfied() || clause.empty()){
                clauses.remove(clause);
            }
        }
    }

    public boolean satisfied(){
        return(clauses.size()==0? true: false);
    }
}