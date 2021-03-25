import java.io.Serializable;

public class Emp implements Serializable{
	private static final long serialVersionUID = 45l;
	private int id;
	private String name;
	private double salary;
	
	public Emp(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
    public String toString() {
        return "id "+id+" name "+name+" salary "+salary;
    }
	
}