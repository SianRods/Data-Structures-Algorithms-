import java.util.Scanner ;
public class SearchStrings {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String name ="Rodrigues";
		System.out.println("Enter the Character you want to Search :");
		char let =Character.valueOf(sc.next().charAt(0));

	}

	// Searching for a Character in a String 

	static boolean CharInString(String str, char c){
		for(int i=0;i<str.length();i++){
			if (str.charAt(i)==c ){
				return true;
			}
		}
		return false;
	}
}
