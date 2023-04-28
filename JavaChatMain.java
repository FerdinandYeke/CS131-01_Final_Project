import java.util.Scanner;

public class JavaChatMain extends QuestionMood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		QuestionMood user1 = new QuestionMood();
		
		System.out.println("Enter your name or type 'Anonymous.' to stay anonymous: ");
		
		String Name = scan.next();
		user1.setName(Name);
		
		user1.Greeting();
		
		String Respond = scan.next();
		
		/*
		 * This loop makes a continuous conversation 
		 */
		while(Respond != "0")
		{
			user1.readResponse(Respond);
			Respond = scan.next();
		}
		
		
	}

}
