import java.util.ArrayList;

public class Literal{
    private char literal;
    private boolean value;
    //int score; for different heuristics

    public Literal(char lit, boolean val){
        literal = lit;
        value = val;
        //int = 0;
    }

    public void setVal(boolean newVal){
        value = newVal;
    }

    public boolean getVal(){
        return value;
    }

    //there should be no method to set a literal

    public char getLit(){
        return literal;
    }

    public boolean equals(Literal lit2){
        return(literal == lit2.getLit() ? true : false);
    }
}

public class Clause{
    private ArrayList literals;

    public Clause(){
        literals = new ArrayList<Literal>();
    }

    //not sure where I'd need this method but good to have just in case, I guess
    public int size(){
        return literals.size();
    }

    public void addLiteral(Literal lit){
        literals.add(lit);
    }

    public boolean satisfied(){
        for (Literal x : literals) {
            if(x.getVal){
                return true;
            }
        }
        return false;
    }

    public boolean empty(){
        return(size()==0 ? true : false);
    }

}

public class Formula{
    private ArrayList clauses;

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
            if(clause.satisfied()){
                clauses.remove(clause);
            }
        }
    }

    public boolean satisfied(){
        return(clauses.size()==0? true: false);
    }
}