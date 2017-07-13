package testPackage;

import java.util.Iterator;
import java.util.TreeSet;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "yash";
		String b = "dim";

		TreeSet<String> ts = new TreeSet<>();

		ts.add("yash");
		ts.add("adf");
		ts.add("dim");

		Iterator<String> itr = ts.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}

	}

}
