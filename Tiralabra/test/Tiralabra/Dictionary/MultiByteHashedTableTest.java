/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiralabra.Dictionary;

import Dictionary.MultiByteHashedTable;
import MultiByteEntities.MultiByte;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author virta
 */
public class MultiByteHashedTableTest {

    MultiByteHashedTable table;
    byte[] incrementalData;
    byte[] sameData;
    byte[] randomData;
    byte[] sortingData;

    public MultiByteHashedTableTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.incrementalData = new byte[]{
            new Byte("1"), new Byte("2"), new Byte("3"), new Byte("4"), new Byte("5"), new Byte("6"), new Byte("7"), new Byte("8"),
            new Byte("11"), new Byte("21"), new Byte("31"), new Byte("41"), new Byte("51"), new Byte("61"), new Byte("71"), new Byte("81")};

        this.sameData = new byte[]{
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"),
            new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7"), new Byte("7")
        };

        sortingData = new byte[]{
            new Byte("5"), new Byte("5"),
            new Byte("3"), new Byte("3"), new Byte("3"), new Byte("3"), new Byte("3"), new Byte("3"),
            new Byte("2"), new Byte("2"), new Byte("2"), new Byte("2"), new Byte("2"), new Byte("2"), new Byte("2"), new Byte("2"),
            new Byte("4"), new Byte("4"), new Byte("4"), new Byte("4"),
            new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1"), new Byte("1")
        };

        randomData = new byte[2000];
        Random r = new Random(2719); //seed is prime number for maximum randomness.
        r.nextBytes(randomData);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testContainsMethod() {


        for (int i = 2; i < 4; i++) {
            table = new MultiByteHashedTable(incrementalData.length);
            introduceValues(incrementalData, table, i);
            testWithData(incrementalData, i, table);
        }

        for (int i = 2; i < 4; i++) {
            table = new MultiByteHashedTable(sameData.length);
            introduceValues(sameData, table, i);
            testWithData(sameData, i, table);
        }

    }

    private void introduceValues(byte[] data, MultiByteHashedTable table, int width) {
        for (int i = 0; i < data.length; i += width) {
            if (i + width < data.length) {
                MultiByte mb = new MultiByte(width);
                for (int j = 0; j < width; j++) {
                    mb.addData(data[width]);
                }
                table.put(mb);
            }
        }
    }

    private void testWithData(byte[] data, int i, MultiByteHashedTable table) {
        for (int j = 0; j < data.length; j++) {
            if (j + i < data.length) {
                MultiByte mb = new MultiByte(i);
                for (int k = 0; k < i; k++) {
                    mb.addData(data[i]);
                }
                assertEquals("Unequal multibyte found", true, table.contains(mb));
            }
        }
    }

    @Test
    public void testPurgingRandomData() {
        fillTable(randomData, 2);

        int keyCountBeforePurge = table.getStats()[1];

        table.purgeAndClean(2);

        int keyCountAfterPurge = table.getStats()[1];

        assertTrue("keys were not purged", keyCountAfterPurge < keyCountBeforePurge);

    }

    @Test
    public void testKeyCountAfterSorting() {
        fillTable(randomData, 2);

        int keyCount = table.getStats()[1];

        MultiByte[] array = table.getArray();

        assertEquals("Keycount does not match", keyCount, array.length);
    }

    @Test
    public void testSortingOfData() {
        fillTable(sortingData, 2);

        MultiByte[] array = table.getArray();

        MultiByte mb1 = new MultiByte(2);
        mb1.addData(new Byte("1"));
        mb1.addData(new Byte("1"));
        MultiByte mb2 = new MultiByte(2);
        mb2.addData(new Byte("2"));
        mb2.addData(new Byte("2"));
        MultiByte mb3 = new MultiByte(2);
        mb3.addData(new Byte("3"));
        mb3.addData(new Byte("3"));
        MultiByte mb4 = new MultiByte(2);
        mb4.addData(new Byte("4"));
        mb4.addData(new Byte("4"));
        MultiByte mb5 = new MultiByte(2);
        mb5.addData(new Byte("5"));
        mb5.addData(new Byte("5"));

        int[] hashes = new int[]{
            mb1.hashCode(), mb2.hashCode(), mb3.hashCode(), mb4.hashCode(), mb5.hashCode()
        };

        assertEquals("wrong number of keys", 5, table.getStats()[1]);

        for (int i = 0; i < array.length; i++) {
            assertEquals("Wrong sorting", hashes[i], array[i].hashCode());
        }

    }

    private void fillTable(byte[] data, int width) {
        table = new MultiByteHashedTable(data.length);
        for (int i = 0; i < data.length; i += width) {
            if (i + width - 1 < data.length) {
                MultiByte mb = new MultiByte(width);
                for (int j = 0; j < width; j++) {
                    mb.addData(data[i + j]);
                }
                table.put(mb);
            }
        }
    }
}