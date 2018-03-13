package com.TomWielenbeck.Test;

import com.TomWielenbeck.FileInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertNotNull;

/**
 * FileInputTest:<br>
 *     FileInputTest tests if the files (places.csv, stuff.csv) can be opened, read, and closed
 */

public class FileInputTest
{
    //Fields for testing
    FileInput placesTest;
    FileInput stuffTest;

    //File input
    @Before
    public void setUp()
    {
        //Test the file inputs
        placesTest = new FileInput("places.csv");
        stuffTest = new FileInput("stuff.csv");
    }
    //Test to see if the files are being accessed properly.
    @Test
    public void testFile()
    {
        //Test for null values
        assertNotNull("Reader should return data.", stuffTest.fileReadLine());
        assertNotNull("Reader should return data.", placesTest.fileReadLine());
    }

    //Test file closure
    @After
    public void tearDown()
    {
        placesTest.fileClose();
        stuffTest.fileClose();
    }
}