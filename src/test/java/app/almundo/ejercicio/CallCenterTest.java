package app.almundo.ejercicio;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CallCenterTest extends TestCase{
	
	public CallCenterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CallCenterTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

}
