package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.net.UnknownHostException;

import org.junit.Test;

import java.util.List;
import java.util.Properties;

import com.sun.jna.platform.win32.Secur32;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

public class UserIdUserNameTest {

	@Test
	public void test() throws UnknownHostException {
		assertEquals("malathi.sankar",System.getProperty("user.name"));
		assertEquals("EME002511-LAP", java.net.InetAddress.getLocalHost().getHostName());
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getenv("user"));
		//System.out.println(System.getProperties());
	}
	
	@Test
	public void testUserNameWindows() {
		System.out.println((new com.sun.security.auth.module.NTSystem()).getName());
		
		char[] name = new char[100];
		Secur32.INSTANCE.GetUserNameEx(Secur32.EXTENDED_NAME_FORMAT.NameDisplay,name, new IntByReference(name.length));		
		assertEquals("Malathi Sankar", new String(name).trim().replaceAll("(.*), (.*)", "$2 $1"));
	}
	
	@Test
	public void testUserName() {
		Properties props = System.getProperties();
		if( ( props.getProperty( "os.arch" ).equals( "x86" ) ||
	             (props.getProperty( "os.arch" ).equals( "amd64" ) ) &&
	            props.getProperty( "os.name" ).startsWith( "Windows" ) ) ) {
	            try {
	        		char[] name = new char[100];
	        		Secur32.INSTANCE.GetUserNameEx(Secur32.EXTENDED_NAME_FORMAT.NameDisplay,name, new IntByReference(name.length));		
	        		assertEquals("Malathi Sankar", new String(name).trim().replaceAll("(.*), (.*)", "$2 $1"));
	            } catch (Throwable t) {
	            	System.out.println(t.toString());
	            }
	        } else {
	        	try {
	        		String un = "";
	        		//String un =  System.getProperty("user.name");
	        		//String un = (new com.sun.security.auth.module.UnixSystem()).getUsername();
	        		CLibrary libc = (CLibrary)Native.loadLibrary("c", CLibrary.class);
	                un = libc.getpwnam(un).pw_gecos;

	             } catch( Throwable t ) {
	                t.printStackTrace();
	            }

	        }

	}
	
	// Create our own platform-specific library
	 interface CLibrary extends Library {
	    // Method to shadow C library getpwname function
	    passwd getpwnam(String username);

	    // This matches the struct for passwd on Solaris
	    // Modify to match passwd struct on other platforms
	    public class passwd extends Structure {
	        public String pw_name;
	        public String pw_passwd;
	        public int pw_uid;
	        public int pw_gid;
	        public String pw_age;
	        public String pw_comment;
	        public String pw_gecos;
	        public String pw_dir;
	        public String pw_shell;
	        
			@Override
			protected List getFieldOrder() {
				// TODO Auto-generated method stub
				return null;
			}
	    }
	}

}
