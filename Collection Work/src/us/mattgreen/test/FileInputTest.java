package us.mattgreen.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.mattgreen.FileInput;
import static org.junit.Assert.assertNotNull;


public class FileInputTest {
    private FileInput indata;
    @Before
    public void setUp() {
        indata = new FileInput("the_book.csv");
    }
    @Test
    public void testSomething() {
        assertNotNull("Reader should return data. ", indata.fileReadLine());
    }
    @After
    public void tearDown() {
        indata.fileClose();
    }
}
