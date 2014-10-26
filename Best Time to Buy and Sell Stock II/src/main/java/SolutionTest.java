import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolutionTest {
    private static Solution s;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        s = new Solution();
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
    public void testFindLowest1() {
        int[] prices = { 0 };
        Solution.PriceAndIndex expected = new Solution.PriceAndIndex(0, 0);
        Solution.PriceAndIndex priceAndIndex = s.findLowest(prices, 0);
        assertEquals(expected, priceAndIndex);
    }

    @Test
    public void testFindLowest2() {
        int[] prices = { 0, 1 };
        Solution.PriceAndIndex expected = new Solution.PriceAndIndex(0, 0);
        Solution.PriceAndIndex priceAndIndex = s.findLowest(prices, 0);
        assertEquals(expected, priceAndIndex);
    }

    @Test
    public void testFindLowest3() {
        int[] prices = { 1, 0 };
        Solution.PriceAndIndex expected = new Solution.PriceAndIndex(0, 1);
        Solution.PriceAndIndex priceAndIndex = s.findLowest(prices, 0);
        assertEquals(expected, priceAndIndex);
    }

    @Test
    public void testFindLowest4() {
        int[] prices = { 1, 0, 2 };
        Solution.PriceAndIndex expected = new Solution.PriceAndIndex(0, 1);
        Solution.PriceAndIndex priceAndIndex = s.findLowest(prices, 0);
        assertEquals(expected, priceAndIndex);
    }

    @Test
    public void testFindLowest5() {
        int[] prices = { 0, 1, 2 };
        Solution.PriceAndIndex expected = new Solution.PriceAndIndex(0, 0);
        Solution.PriceAndIndex priceAndIndex = s.findLowest(prices, 0);
        assertEquals(expected, priceAndIndex);
    }

    @Test
    public void testFindLowest6() {
        int[] prices = { 4, 0, 3, 1, 2 };
        Solution.PriceAndIndex expected = new Solution.PriceAndIndex(0, 1);
        Solution.PriceAndIndex priceAndIndex = s.findLowest(prices, 0);
        assertEquals(expected, priceAndIndex);
    }

    @Test
    public void testSolution1() {
        int[] prices = { 0 };
        int expected = 0;
        assertEquals(expected, s.maxProfit(prices));
    }

    @Test
    public void testSolution2() {
        int[] prices = { 1 };
        int expected = 0;
        assertEquals(expected, s.maxProfit(prices));
    }

    @Test
    public void testSolution3() {
        int[] prices = { 1, 2, 3 };
        int expected = 2;
        assertEquals(expected, s.maxProfit(prices));
    }

    @Test
    public void testSolution4() {
        int[] prices = { 3, 2, 1, 2, 3 };
        int expected = 2;
        assertEquals(expected, s.maxProfit(prices));
    }

    @Test
    public void testSolution5() {
        int[] prices = { 3, 2, 1, 2, 3, 2, 3, 4, 5 };
        int expected = 5;
        assertEquals(expected, s.maxProfit(prices));
    }

    @Test
    public void testSolution6() {
        int[] prices = { 3, 2, 1 };
        int expected = 0;
        assertEquals(expected, s.maxProfit(prices));
    }

    @Test
    public void testSolution7() {
        int[] prices = { 2, 2, 5 };
        int expected = 3;
        assertEquals(expected, s.maxProfit(prices));
    }
}
