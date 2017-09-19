package edu.wit.cs.comp1050.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.security.Permission;
import java.util.Scanner;

import edu.wit.cs.comp1050.PA2c;
import junit.framework.TestCase;

public class PA2cTestCase extends TestCase {

	private final static String ERR_NONAME = "Name could not be located in given file.";
	private final static String ERR_IOMAIN = "File I/O error at main()";
	private final static int STARTYEAR = 1890;
	private final static int NO_OF_LINES = 5870;
	private final static int NO_OF_DECADES = 13;

	private final static String pf = "Enter a filename: ";
	private final static String p0 = "Enter the name to search for: ";
	private final static String p1 = "Enter the gender to search for, M or F: ";
	private final static String p2 = "Would you like to search again? y or n: ";
	private final static String pn = "%n";

	
	@SuppressWarnings("serial")
	private static class ExitException extends SecurityException {}
	
	private static class NoExitSecurityManager extends SecurityManager 
    {
        @Override
        public void checkPermission(Permission perm) {}
        
        @Override
        public void checkPermission(Permission perm, Object context) {}
        
        @Override
        public void checkExit(int status) { super.checkExit(status); throw new ExitException(); }
    }
	
	@Override
    protected void setUp() throws Exception 
    {
        super.setUp();
        System.setSecurityManager(new NoExitSecurityManager());
    }
	
	@Override
    protected void tearDown() throws Exception 
    {
        System.setSecurityManager(null);
        super.tearDown();
    }
	
	private void _test(String ps, String fname, String uname, String ugender, String desired) throws Exception {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		final String input = String.format("%s%n%s%n%s%n", fname, uname, ugender);
		final String expected = TestSuite.stringOutput(new String[] {
			ps,
			desired
		}, new Object[] {});
		
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		System.setOut(new PrintStream(outContent));
		try {
			PA2c.main(new String[] { "foo" });
		} catch (ExitException e) {}
		
		assertEquals(expected, outContent.toString());
		
		System.setIn(null);
		System.setOut(null);
	}

	
	private void _testformatName (String uname, String expected) {
		String result = null;
		try {
			result = PA2c.formatName(uname);
		} catch (ExitException e) {}
		assertEquals(expected, (String) result);
	}

	
	private void _testfindName(String[] nameArray, String[] genderArray, String name, String gender, int expected) {
		Integer result = null;
		try {
			result = PA2c.findName(nameArray, genderArray, name, gender);
		} catch (ExitException e) {}
		assertEquals(expected, (int) result);
	}
	
	public void testformatName() {
		_testformatName("abc", "Abc");
		_testformatName("A", "A");
		_testformatName("a", "A");
		_testformatName("Karl", "Karl");
		_testformatName("MARC", "Marc");
		_testformatName("BeTte", "Bette");
		_testformatName("CHARles", "Charles");
		_testformatName("pAM", "Pam");

	}
	
	
	public void testfindName() {
		final String[] names= {"Jax", "Randall", "Minnie", "Minnie", "Rikki", "Banana", "Orange", "Cherry", "Apple", "Pineapple", "Melon", "Plum"}; 
		final String[] genders = {"M", "F", "M", "F", "M", "F", "M", "F", "M", "F", "M", "F" };
		
		_testfindName(names, genders, "Jax", "M", 0);
		_testfindName(names, genders, "Jax", "F", -1);

		_testfindName(names, genders, "Randall", "M", -1);
		_testfindName(names, genders, "Randall", "F", 1);
		
		_testfindName(names, genders, "Minnie", "M", 2);
		_testfindName(names, genders, "Minnie", "F", 3);
		
		_testfindName(names, genders, "Rikki", "M", 4);
		_testfindName(names, genders, "Rikki", "F", -1);
		
		_testfindName(names, genders, "Melon", "M", 10);
		_testfindName(names, genders, "Melon", "F", -1);

		_testfindName(names, genders, "Plum", "M", -1);
		_testfindName(names, genders, "Plum", "F", 11);
	}
	

	public void _testBadFile(String f, String a) {
		try {			
			_test(pf, f,a, a, a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//	private void _test(String ps, String fname, String uname, String ugender, String desired) throws Exception {
	public void _testBadName(String n, String g, String m) {
		try {			
			_test(pf+p0+p1, "names.txt", n, g, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void _testGood(String n, String g, String l, String a) {
		
		try {			
			_test(pf+p0+p1, "names.txt", n, g, l+pn+a+pn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void testProgram() {
	
		//Test error exception handling for file names
		String badf = "bad";
		_testBadFile(badf, "Exception at getFile: "+ badf+ " not found.%n"+ERR_IOMAIN+pn);
		
		badf = "name.txt";
		_testBadFile(badf, "Exception at getFile: "+ badf+ " not found.%n"+ERR_IOMAIN+pn);
		
		badf = "";
		_testBadFile(badf, "Exception at getFile: "+ badf+ " not found.%n"+ERR_IOMAIN+pn);
		
		//Test unknown names/genders
		String name = "voldermort";
		String gender = "M";
		_testBadName(name, gender, ERR_NONAME+pn);
		
		name = "Hermonie";
		gender = "f";
		_testBadName(name, gender, ERR_NONAME+pn);	
		
		//Test existing names/genders
		name = "Mark";
		gender = "M";
		String l = "1890:169 1900:153 1910:200 1920:219 1930:219 1940:149 1950:23 1960:6 1970:9 1980:30 1990:46 2000:79 2010:161 ";
		String a = "Name was most popular in the decade of 1960, ranking #6/1000.";	
		_testGood(name, gender, l, a);

		 name = "mark";
		 gender = "f";
		 l = "1890:0 1900:0 1910:0 1920:0 1930:0 1940:0 1950:0 1960:919 1970:932 1980:0 1990:0 2000:0 2010:0 ";
		 a = "Name was most popular in the decade of 1960, ranking #919/1000.";	
		_testGood(name, gender, l, a);
		
		 name = "KAREN";
		 gender = "f";
		 l = "1890:747 1900:0 1910:0 1920:0 1930:688 1940:34 1950:12 1960:4 1970:12 1980:54 1990:120 2000:154 2010:247 ";
		 a = "Name was most popular in the decade of 1960, ranking #4/1000.";	
		_testGood(name, gender, l, a);
		
		 name = "karen";
		 gender = "m";
		 l = "1890:0 1900:0 1910:0 1920:0 1930:0 1940:0 1950:0 1960:895 1970:0 1980:0 1990:0 2000:0 2010:0 ";
		 a = "Name was most popular in the decade of 1960, ranking #895/1000.";	
		_testGood(name, gender, l, a);
		
		 name = "newman";
		 gender = "m";
		 l = "1890:856 1900:0 1910:0 1920:0 1930:0 1940:0 1950:0 1960:0 1970:0 1980:0 1990:0 2000:0 2010:0 ";
		 a = "Name was most popular in the decade of 1890, ranking #856/1000.";	
		_testGood(name, gender, l, a);
		
		 name = "bette";
		 gender = "f";
		 l = "1890:0 1900:0 1910:943 1920:196 1930:221 1940:233 1950:376 1960:859 1970:0 1980:0 1990:0 2000:0 2010:0 ";
		 a = "Name was most popular in the decade of 1920, ranking #196/1000.";	
		_testGood(name, gender, l, a);

	}
	
}
