import org.junit.*;
import static org.junit.Assert.*;

public class ClauseTest {

    @Test
    public void constructorShouldCreateNotNull() {
        Clause tester = new Clause();

        //assert statement
        assertNotNull(tester);
    }

    @Test
    public void getLiteralShouldGetCorrectLiteral() {
        Clause testClause = new Clause();
        Literal testLit1 = new Literal('P', true);
        Literal testLit2 = new Literal('X', false);

        testClause.addLiteral(testLit1);
        testClause.addLiteral(testLit2);

        //assert statements
        assertEquals(testLit1, testClause.getLiteral(0));
        assertEquals(testLit2, testClause.getLiteral(1));
        assertNotEquals(testLit1, testClause.getLiteral(1));
        assertNotEquals(testLit2, testClause.getLiteral(0));
    }

    @Test
    public void addLiteralShouldAddLiteralToClause() {
        Clause testClause = new Clause();
        Literal testLiteral = new Literal('P', true);
        
        testClause.addLiteral(testLiteral);

        //assert statement
        assertEquals(testLiteral, testClause.getLiteral(0));
    }

    @Test
    public void emptyShouldReturnTrueWhenSizeIsZero() {
        Clause tester = new Clause();

        //assert statements
        assertTrue(tester.empty());
    }

    @Test
    public void emptyShouldReturnFalseWhenSizeIsNotZero() {
        Clause tester = new Clause();
        tester.addLiteral(new Literal('P', true));

        //assert statements
        assertFalse(tester.empty());
    }
    
    @Test
    public void sizeReturnsCorrectSize() {
        Clause tester = new Clause();

        //assert statements
        assertEquals(0, tester.size());
    }

    @Test
    public void satisfiedShouldReturnTrueOnSatisfiedClause() {
        Clause testSatisfied = new Clause();
        Literal satisfiedLiteral = new Literal('P', true);

        testSatisfied.addLiteral(satisfiedLiteral);

        //assert statement
        assertTrue(testSatisfied.satisfied());
    }

    @Test
    public void satisfiedShouldReturnFalseOnUnsatisfiedClause() {
        Clause testUnsatisfied = new Clause();
        Literal unsatisfiedLiteral = new Literal('X', false);

        testUnsatisfied.addLiteral(unsatisfiedLiteral);

        //assert statement
        assertFalse(testUnsatisfied.satisfied());
    }
}