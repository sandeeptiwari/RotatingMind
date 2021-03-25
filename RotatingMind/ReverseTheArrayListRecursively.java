import java.util.*;
public class ReverseTheArrayListRecursively{
	static int  pos;
	
	public List<String> reverse(int i, int j, List<String> strList){
		if(i < j){
			
			String tmp = strList.get(i);
			strList.set(i, strList.get(j));
			strList.set(j, tmp);
			i = i +1;
			j = j -1;
			//System.out.println("in "+strList);
			reverse(i, j, strList);
		}
		return strList;
	}
	
	public void reverse(List<String> list) {
        int size = list.size();
        ListIterator<String> front = (ListIterator<String>) list.listIterator();
        ListIterator<String> back = (ListIterator<String>) list
                .listIterator(size);
        for (int i = 0; i < size / 2; i++) {
            String frontNext = front.next();
            String backPrev = back.previous();
            front.set(backPrev);
            back.set(frontNext);
        }
    }
	
	public static void main(String...args){
		int i = 0;
		 
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		pos = (strList.size() - 1);
		System.out.println(strList);
		ReverseTheArrayListRecursively recursively = new ReverseTheArrayListRecursively();
		recursively.reverse(strList);
		System.out.println(strList);//reverse(i, pos, strList));
		
	}
}