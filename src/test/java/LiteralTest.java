import org.junit.*;
import static org.junit.Assert.*;

public class LiteralTest {

    @Test
    public void literalShouldBeNotNull() {
        Literal tester1 = new Literal('P', true);   //constructor is tested
        Literal tester2 = new Literal('P', false);

        //assert statements
        assertNotNull(tester1);
        assertNotNull(tester2);
    }

    @Test
    public void getLitShouldReturnLit() {
        Literal tester1 = new Literal('P',true); // Literal is tested
        Literal tester2 = new Literal('X', false);
        Literal tester3 = new Literal('q', true);
        Literal tester4 = new Literal('y', false);

        // assert statements
        assertEquals('P', tester1.getLit());
        assertEquals('X', tester2.getLit());
        assertEquals('q', tester3.getLit());
        assertEquals('y', tester4.getLit());
    }

    @Test
    public void getValShouldReturnCorrectVal() {
        Literal tester1 = new Literal('P',true); 
        Literal tester2 = new Literal('X', false);

        //assert statements
        assertTrue(tester1.getVal());
        assertFalse(tester2.getVal());
    }

    @Test 
    public void setValShouldUpdateTheVale() {
        Literal tester1 = new Literal('P',true); 
        Literal tester2 = new Literal('X', false);

        //assert statements
        assertTrue(tester1.getVal());
        assertFalse(tester2.getVal());

        tester1.setVal(false);
        tester2.setVal(true);

        //assert that values changed
        assertFalse(tester1.getVal());
        assertTrue(tester2.getVal());
    }

    @Test
    public void equalsShouldCompareLiterals() {
        //equals method should only compare if literals' chars are equal, regardless of the values

        //A literal should be equal to itself
        Literal tester = new Literal('P', true);

        assertTrue(tester.equals(tester));


        //SameLiterals, Same Values
        Literal tester1 = new Literal('P',true); 
        Literal tester2 = new Literal('P', true);

        
        assertTrue(tester1.equals(tester2));
        assertTrue(tester2.equals(tester1)); //it should work both ways

        //Same Literals, Different Values
        Literal tester3 = new Literal('P',true); 
        Literal tester4 = new Literal('P', false);

        assertTrue(tester3.equals(tester4));
        assertTrue(tester4.equals(tester3)); //it should work both ways

        //Different Literals, Same Values
        Literal tester5 = new Literal('P',false); 
        Literal tester6 = new Literal('X', false);

        assertFalse(tester5.equals(tester6));
        assertFalse(tester6.equals(tester5)); //it should work both ways

        //Different Literals, Different Values
        Literal tester7 = new Literal('P',true); 
        Literal tester8 = new Literal('X', false);

        assertFalse(tester7.equals(tester8));
        assertFalse(tester8.equals(tester7)); //it should work both ways
    }
   
}
