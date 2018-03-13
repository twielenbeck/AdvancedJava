package com.TomWielenbeck.Test;

import com.TomWielenbeck.FileInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * FileInputTest:<br>
 *     FileInputTest tests if the file (date_diff) can be opened, read, and closed
 */

public class FileInputTest
{
    //Fields for testing
    FileInput dateTest;

    //File input
    @Before
    public void setUp()
    {
        //Test the file inputs
        dateTest = new FileInput("date_diff.csv");
    }
    //Test to see if the files are being accessed properly.
    @Test
    public void testFile()
    {
        //Test for null values
        assertNotNull("Reader should return data.", dateTest.fileReadLine());
    }

    //Test file closure
    @After
    public void tearDown()
    {
        dateTest.fileClose();
    }
}