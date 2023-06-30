import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

import util.ListenerClass;

public class TestRunner {

//	public static void main(String[] args){
//		TestNG testNG=new TestNG();
//		List<String> list = new ArrayList<>();
//		InputStream stream = TestRunner.class.getResourceAsStream("/testng.xml");
//        System.out.println(stream != null);
//        stream = TestRunner.class.getClassLoader().getResourceAsStream("testng.xml");
//	//	list.add(".//src//test//resouces//resourcespackage//testng.xml");
//		list.add(".//src//main//resources//resourcespackage//testng.xml");
//		
//		testNG.setTestSuites(list);;
//		testNG.run();
//
//	}
//	

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> list = new ArrayList<>();
        //String absolutepath=new File("src/main/resources/testng.xml").getAbsolutePath();
        //System.out.println(absolutepath);
        ////InputStream stream = TestRunner.class.getResourceAsStream("/testng.xml");
        //System.out.println(stream != null);
        //stream = TestRunner.class.getClassLoader().getResourceAsStream("testng.xml");
        list.add(".//src//main//resources//testng.xml");
        testng.setTestSuites(list);
        testng.run();
    }
//	
//	public static void main(String[] args) {
//        TestNG testng = new TestNG();
//       
//        ListenerClass l= new ListenerClass();
//        testng.setTestClasses(new Class[] {ContactsRegression.class});
//        testng.addListener(l);
////        list.add( "testng.xml");
////        testng.setTestSuites(list);
//        testng.run();
//    }

}
