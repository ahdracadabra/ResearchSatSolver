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