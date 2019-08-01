import org.junit.*;
import static org.junit.Assert.*;

public class ParserTest {
//this class, despite being quite important, only has one method, and therefore limited tests

@Test    
public void parseShouldNotReturnNull() {
        Parser tester = new Parser();

        assertNotNull(tester.parse(""));
    }

    @Test
    public void parseShouldReturnCorrectFormula() {
        //input will be multi-clause and multi-literal
        //(PQ)(!RS)

        Parser tester = new Parser();

        Clause clause1 = new Clause();
        clause1.addLiteral(new Literal('P', true));
        clause1.addLiteral(new Literal('Q', true));
        Clause clause2 = new Clause();
        clause2.addLiteral(new Literal('R', false));
        clause2.addLiteral(new Literal('S', false));
        Formula testFormula = new Formula();
        testFormula.addClause(clause1);
        testFormula.addClause(clause2);

        Formula answer = tester.parse("(PQ)(!RS)");

        for(int i = 0; i < answer.getClauses().size(); i++){
            assertTrue(testFormula.getClauses().get(i).getLiterals().equals(answer.getClauses().get(i).getLiterals()));
           /*  for(int j = 0; j < answer.getClauses().get(i).getLiterals().size(); j++){
                assertTrue(testFormula.getClauses().get(i).getLiterals().equals(answer.getClauses().get(i).getLiterals()));
            } */
        }
    }

}