public class EnumInterface{
	public static void main(String...args){
		
		Operation sum = new Operation(10, 5, EOperator.SUM);
		Operation subtraction = new Operation(10, 5, EOperator.SUBTRACT);
    
		System.out.println("Sum: " + sum.calculate());
		System.out.println("Subtraction: " + subtraction.calculate());
		
	}
}

interface Operator{
	int calculate(int firstOperand, int secondOperand);
}

enum EOperator implements Operator{
	
	SUM {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
      return firstOperand + secondOperand;
    }
  },
  SUBTRACT {
	  
    @Override
    public int calculate(int firstOperand, int secondOperand) {
      return firstOperand - secondOperand;
    }
  };
}

class Operation {

  private int firstOperand;
  private int secondOperand;
  private EOperator operator;
  
  public Operation(int firstOperand, int secondOperand, 
                    EOperator operator) {

    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
    this.operator = operator;
  }
  
  public int calculate(){
    return operator.calculate(firstOperand, secondOperand);
  }
}