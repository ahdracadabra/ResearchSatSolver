import java.util.ArrayList;

/**
 * This parser parses string inputs into a nSAT formula.
 * The parser operates on the assumption that the input string is input in Conjunctive Normal Form
 */


class Parser{

    public Parser(){};

    public static Formula parse(String in){
        Clause currentClause = new Clause();
        boolean litValue = true;
        Formula answer = new Formula();

        char[] formula = in.toCharArray();
        for (char x : formula){
            switch (x){
                case '(' : continue;
                case ')' : answer.addClause(currentClause); currentClause = new Clause(); break;
                case '!' : litValue = false; break;
                default : {
                    if(Character.isLetter(x)){
                        currentClause.addLiteral(new Literal(x,litValue));
                        litValue = true;
                    }
                    break;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
       Formula answer = parse("(PQ)(RS)");
    }
}