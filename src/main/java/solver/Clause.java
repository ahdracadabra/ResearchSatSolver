import java.util.ArrayList;

public class Clause{
    private ArrayList<Literal> literals;

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

    //this method should only be used for testing
    public Literal getLiteral(int pos){
        return literals.get(pos);
    }

    //this method should only be used for testing
    public ArrayList<Literal> getLiterals(){
        return literals;
    }

    public boolean satisfied(){
        for (Literal x : literals) {
            if(x.getVal()){
                return true;
            }
        }
        return false;
    }

    public boolean empty(){
        return(size()==0 ? true : false);
    }

}