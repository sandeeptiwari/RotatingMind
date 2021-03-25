/*Write a program to read words from a file. Count the repeated or duplicated words. Sort it by maximum repeated or duplicated word count.*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class FindDuplicateWordsInFile{
	
	public Map<String, Integer> getWordCout(String filePath){
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
	
		try{
			FileInputStream fIs = new FileInputStream(filePath);
			BufferedReader bR = new BufferedReader(new InputStreamReader(fIs));
			String line = null;
			while ((line = bR.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreTokens()){
                    String tmp = st.nextToken().toLowerCase();
                    if(wordMap.containsKey(tmp)){
						wordMap.put(tmp, wordMap.get(tmp) + 1);
					}else{
						wordMap.put(tmp, 1);
					}
				}
			}
		}catch(FileNotFoundException fnfe){
			
		}catch(IOException ex){
			
		}
		return wordMap;
	}
	
	 public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap){
         
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return list;
    }

	public static void main(String...args){
		
		FindDuplicateWordsInFile findDuplicateWordsInFile = new FindDuplicateWordsInFile();
		Map<String, Integer> wordMap = findDuplicateWordsInFile.getWordCout("D:/practice/play_with_code/RotatingMind/test.txt");
		List<Entry<String, Integer>> list = findDuplicateWordsInFile.sortByValue(wordMap);
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
	}
}