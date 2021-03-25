import model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test1.TestEmployee;

import java.util.Arrays;
import java.util.List;

public class TestSamples {

	private TestEmployee testEmployee;
	List<Employee> emps;
	@Before
	public void setUp() {
		testEmployee = new TestEmployee();
		emps = Arrays.asList(
				new Employee(100l, "A", 21),
				new Employee(1001l, "B", 32),
				new Employee(1002l, "A", 33),
				new Employee(99l, "B", 10)
		);
	}

	@Test
	public void testEmpSort() {
		List<Employee> employees = testEmployee.sortByNameThenAge(emps);
		Assert.assertTrue(employees.size() == 4);
		Assert.assertTrue(employees.get(0).getName().equals("A"));
		Assert.assertTrue(employees.get(0).getAge() == 21);
	}

	@Test
	public void should_not_contains_greater_age_first_if_name_is_same() {
		List<Employee> employees = testEmployee.sortByNameThenAge(emps);
		Assert.assertTrue(employees.get(0).getAge() == 21);
	}

   /* @Test
    public void testCustomStack(){
        CustomStack stack = new CustomStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        //System.out.print("Top ele is :: "+stack.pop());

    }*/
	
	public static void main(String...args){
		/*Emp emp = new Emp(11, "A", 2000);
		try{
            //serializing
            String fileName = "E://practice//test//file.ser";
            FileOutputStream fous = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fous);

            oos.writeObject(emp);
			
			fous.close();
			oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        } */
		
	}
}
