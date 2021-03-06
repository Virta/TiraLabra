/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiralabra.Utilities;

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
public class IntegerConverterTest {
    
    public IntegerConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testIntegerToByteConversion(){
        int one = 1;
        byte[] IntegerToByte = Utilities.IntegerConverter.IntegerToByte(one, 1);
        int converted = Utilities.IntegerConverter.ByteToInteger(IntegerToByte);
        assertEquals("Not a correct conversion: "+one, one, converted);
        assertEquals("Differing bytewidth: "+IntegerToByte.length, 1, IntegerToByte.length);
    }

    @Test
    public void integerToTwoBytes() {
        byte[] IntegerToByte;
        int converted;
        int twoBytes = 300;
        IntegerToByte = Utilities.IntegerConverter.IntegerToByte(twoBytes, 2);
        converted = Utilities.IntegerConverter.ByteToInteger(IntegerToByte);
        assertEquals("Not a correct conversion: "+twoBytes, twoBytes, converted);
        assertEquals("Differing bytewidth: "+IntegerToByte.length, 2, IntegerToByte.length);
    }

    @Test
    public void integerToManyBytes() {
        byte[] IntegerToByte;
        int converted;
        int manyBytes = 90000;
        IntegerToByte = Utilities.IntegerConverter.IntegerToByte(manyBytes, 3);
        converted = Utilities.IntegerConverter.ByteToInteger(IntegerToByte);
        assertEquals("Not a correct conversion: "+manyBytes, manyBytes, converted);
        assertEquals("Differing bytewidth: "+IntegerToByte.length, 3, IntegerToByte.length);
    }

    @Test
    public void bytesToInteger() throws NumberFormatException {
        byte[] byteArray = new byte[]{
          new Byte("2"), new Byte("9")
        };
        int byteToInteger = Utilities.IntegerConverter.ByteToInteger(byteArray);
        byte[] convertedBytes = Utilities.IntegerConverter.IntegerToByte(byteToInteger, 2);
        assertEquals("Unequal bytes in converted array: ", byteArray[0], convertedBytes[0]);
        assertEquals("Unequal bytes in converted array: ", byteArray[1], convertedBytes[1]);
    }
}