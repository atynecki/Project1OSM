package mvc;
import java.util.*;

public class utils {
	static boolean isText (String line){
		if(line.isEmpty())
			return false;
		for(int i=0; i<line.length(); i++){
			if(!(Character.isLetter(line.charAt(i))))
					return false;
		}
		return true;
	}
	
	static boolean isNumber (String line){
		if(line.isEmpty())
			return false;
		for(int i=0; i<line.length(); i++){
			if(!(Character.isDigit(line.charAt(i))))
					return false;
		}
		return true;
	}
}
