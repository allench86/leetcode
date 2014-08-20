import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SolutionTest {
    private static Solution solution;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        solution = new Solution();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void when_pass_in_string_of_plus_mark_it_returns_true() {
        String op = "+";
        assertTrue("", solution.isOperator(op));
    }
    
    @Test
    public void when_pass_in_string_of_minus_mark_it_returns_true() {
        String op = "-";
       assertTrue("", solution.isOperator(op));
    }
    
    @Test
    public void when_pass_in_string_of_multiply_mark_it_returns_true() {
        String op = "*";
        assertTrue("", solution.isOperator(op));
    }
    
    @Test
    public void when_pass_in_string_of_divise_mark_it_returns_true() {
        String op = "/";
        assertTrue("", solution.isOperator(op));
    }
    
    @Test
    public void when_pass_in_non_operation_it_returns_false() {
        String op = "1";
        assertFalse("", solution.isOperator(op));
    }
    
    @Test
    public void when_pass_in_null_it_returns_false() {
        String op = null;
        assertFalse("", solution.isOperator(op));
    }
    
    @Test
    public void when_pass_in_empty_string_it_returns_false() {
        String op = "";
        assertFalse("", solution.isOperator(op));
    }
    
    @Test
    public void given_two_integer_and_a_plus_mark_it_returns_correct_operation_result() throws Exception {
        int a = 2;
        int b = 13;
        String op = "+";
        int expectedResult = a + b;
        assertEquals(expectedResult, solution.calExp(a, b, op));
    }
    
    @Test
    public void given_two_integer_and_a_minus_mark_it_returns_correct_operation_result() throws Exception {
        int a = 2;
        int b = 13;
        String op = "-";
        int expectedResult = a - b;
        assertEquals(expectedResult, solution.calExp(a, b, op));
    }
    
    @Test
    public void given_two_integer_and_a_multiply_mark_it_returns_correct_operation_result() throws Exception {
        int a = 2;
        int b = 13;
        String op = "*";
        int expectedResult = a * b;
        assertEquals(expectedResult, solution.calExp(a, b, op));
    }
    
    @Test
    public void given_two_integer_and_a_divise_mark_it_returns_correct_operation_result() throws Exception {
        int a = 13;
        int b = 2;
        String op = "/";
        int expectedResult = a / b;
        assertEquals(expectedResult, solution.calExp(a, b, op));
    }
    
    @Test(expected=Exception.class)
    public void given_an_unsupported_operator_it_throw_exception() throws Exception {
        int a = 13;
        int b = 2;
        String op = ".";
        solution.calExp(a, b, op);
    }
    
    @Test
    public void given_a_well_formatted_reverse_polish_notation_it_returns_calculation_result() throws Exception {
        String a = "2";
        String b = "3";
        String c = "4";
        String d = "3";
        String e = "7";
        String op1 = "+";
        String op2 = "*";
        String op3 = "/";
        String op4 = "-";
        int exceptedResult = (Integer.valueOf(a) + Integer.valueOf(b) * Integer.valueOf(c)) / (Integer.valueOf(d) - Integer.valueOf(e));
        
        String[] tokens = {a, b, c , op2, op1, d, e, op4, op3};
        
//        String a = "4";
//        String b = "13";
//        String c = "5";
//        String op1 = "/";
//        String op2 = "+";
//        
//        int exceptedResult = Integer.valueOf(a) + Integer.valueOf(b) / Integer.valueOf(c);
//                
//        String[] tokens = {a, b, c, op1, op2};
         
        assertEquals(exceptedResult, solution.evalRPN(tokens));
    }
    
    @Test(expected=Exception.class)
    public void given_a_bad_formatted_reverse_polish_notation_it_throw_exception() throws Exception {
        String a = "2";
        String op1 = "+";

        String[] tokens = {a, op1};
        
        solution.evalRPN(tokens);
    }
}
