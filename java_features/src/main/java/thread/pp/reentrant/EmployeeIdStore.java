package thread.pp.reentrant;

import java.util.HashMap;
import java.util.Map;

public class EmployeeIdStore {
    private final Map<String, String> employees;

    private static EmployeeIdStore INSTANCE = null;

    private EmployeeIdStore() {
        this.employees = new HashMap<>();

        //read DB
        this.employees.put("101", "Navya Tiwari");
        this.employees.put("102", "Kavya Tiwari");
        this.employees.put("103", "Sandeep Tiwari");
        this.employees.put("104", "Aadvik Tiwari");
    }

    public static EmployeeIdStore getInstance() {
        if (INSTANCE == null) {
            return new EmployeeIdStore();
        }

        return INSTANCE;
    }
}
