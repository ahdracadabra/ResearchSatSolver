import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class FormulaTest {

    @Test
    public void constructorShouldConstructNotNullFormula() {
        Formula tester = new Formula();

        //assert statement
        assertNotNull(tester);
    }

    @Test
    public void copyConstructorShouldConstructNotNullFormula() {
        Formula tester = new Formula();
        Formula testCopy = new Formula(tester);

        //assert statements
        assertNotNull(testCopy);
    }

    @Test
    public void getClausesShouldGetCorrectClauses() {
        Clause testClause = new Clause();
        Formula tester = new Formula();
        ArrayList<Clause> testArray = new ArrayList();

        testClause.addLiteral(new Literal('P', true));
        
        testArray.add(testClause);
        tester.addClause(testClause);

        //assert statement
        assertEquals(testArray, tester.getClauses());
    }

    @Test
    public void addClausesShouldAddClauses() {
        Clause testClause = new Clause();
        Formula tester = new Formula();

        //assert that formula is empty
        assertEquals(0, tester.getClauses().size());

        testClause.addLiteral(new Literal('P', true));
        tester.addClause(testClause);

        //assert that formula is no longer empty
        assertTrue(tester.getClauses().size() >= 0);
    }

    @Test
    public void copiedFormulaShouldHaveSameClauses() {
        Formula tester = new Formula();
        Clause testClause = new Clause();

        testClause.addLiteral(new Literal('P', true));
        tester.addClause(testClause);

        Formula testCopy = new Formula(tester);

        //assert statements
        assertEquals(tester.getClauses(), testCopy.getClauses());
    }

    @Test
    public void copiedFormulaShouldActSeparately() {
        Formula tester = new Formula();
        Clause testClause = new Clause();

        testClause.addLiteral(new Literal('P', true));
        tester.addClause(testClause);

        Formula testCopy = new Formula(tester);

        //assert  they are equal
        assertEquals(tester.getClauses(), testCopy.getClauses());

        Clause testClause2 = new Clause();
        testClause2.addLiteral(new Literal('X', false));
        testCopy.addClause(testClause2);

        //assert they are no longer equal (ie copy can act independently)
        assertNotEquals(tester, testCopy);
    }

    @Test
    public void cleanUpShouldRemoveSatisfiedClauses() {
        Clause sat1 = new Clause();
        Clause sat2 = new Clause();
        Clause sat3 = new Clause(); //empty clause

        //only true literals
        sat1.addLiteral(new Literal('P', true));

        //mixed literals but still satisfied
        sat2.addLiteral(new Literal('Q', true));
        sat2.addLiteral(new Literal('X', false));

        Formula tester = new Formula();
        tester.addClause(sat1);
        tester.addClause(sat2);
        tester.addClause(sat3);

        tester.cleanUp();

        //assert statement
        assertTrue(tester.getClauses().size()==0);

    }

    @Test
    public void cleanUpShouldLeaveUnsatisfiedClauses() {
        Clause sat1 = new Clause(); //satisfied clause
        sat1.addLiteral(new Literal('P', true));
        Clause sat2 = new Clause(); //unsatisfied clause
        sat2.addLiteral(new Literal('P', false));

        Formula tester = new Formula();
        tester.addClause(sat1);
        tester.addClause(sat2);

        assertTrue(tester.getClauses().size()==2);

        tester.cleanUp();

        assertTrue(tester.getClauses().size()==1);
    }

    @Test
    public void satisfiedShouldReturnTrueOnEmptyFormula() {
        Formula tester = new Formula();

        assertTrue(tester.satisfied());
    }

    @Test
    public void satisfiedShouldReturnTrueOnFullyCleanedFormula() {
        Clause sat1 = new Clause();
        Clause sat2 = new Clause();
        Clause sat3 = new Clause(); //empty clause

        //only true literals
        sat1.addLiteral(new Literal('P', true));

        //mixed literals but still satisfied
        sat2.addLiteral(new Literal('Q', true));
        sat2.addLiteral(new Literal('X', false));

        Formula tester = new Formula();
        tester.addClause(sat1);
        tester.addClause(sat2);
        tester.addClause(sat3);

        tester.cleanUp();

        //assert statement
        assertTrue(tester.satisfied());

    }

    @Test
    public void satisfiedShouldReturnFalseOnNotEmptyFormula() {
        Clause sat1 = new Clause(); //satisfied clause
        sat1.addLiteral(new Literal('P', true));
        Clause sat2 = new Clause(); //unsatisfied clause
        sat2.addLiteral(new Literal('P', false));

        Formula tester = new Formula();
        tester.addClause(sat1);
        tester.addClause(sat2);

        assertTrue(tester.getClauses().size()==2);

        tester.cleanUp();

        assertFalse(tester.satisfied());
    }
}