import java.util.Random;
import java.util.Iterator;
/*
 * This class provides a list of greeting questions to the user that javaChat runs on. 
 * It also uses the Random class to randomly choose a question from the
 * array based on each index value.
 *@author Ferdinand K. Yeke 
 */

public class QuestionMood implements JavaChatInterface{
	
	//Sets up the list of greeting questions
	private String[] GreetingQuestion = {"How are you doing?", "How are you feeling?",
								"How has the day been so far?", "What do you feel like during today?",
								};
	private int pickQuestion;
	//GreetingQuestion array setup ends here
	
	private String Anonymous;
	Random generator = new Random();
	private boolean isPositive;
	private boolean isNegative;
	
	/*
	 * Constructors start here
	 * These Constructors sets up the user's name
	 * so that JavaChat can know the user name and start the greeting.
	 * 
	 */
	//Default Constructor starts here
	public QuestionMood()
	{
		this.Anonymous = "Anonymous";
	}//Default Constructor ends here
	
	//Preferred Constructor starts here
	public QuestionMood(String Anonymous)
	{
		this.Anonymous = Anonymous;
	}//Preferred Constructor ends here
	
	//Set and getName starts here
	
	public void setName(String Anonymous)
	{
		this.Anonymous = Anonymous;
	}
	
	public String getName()
	{
		return Anonymous;
	}
	
	/*
	 * Greeting method starts here.
	 * This method has a int variable to hold the array's length
	 * as the value for the generator.nexInt variable. The length
	 * is the total array size, and the generator.nextInt method
	 * randomly generates the number from 0 to the max array length.
	 * Once it does, the pickQuestion variable stores that, then
	 * gets put in a sysOut line with a GreetingQuestion in the index.
	 */
	public void Greeting()
	{
		System.out.println("Hello "+getName()+"!");
		System.out.println("I am JavaChat");
		pickQuestion = generator.nextInt(GreetingQuestion.length);
		System.out.println(GreetingQuestion[pickQuestion]);
		
	}//Greeting method ends here
	
	//Sets up the follow up questions in array format
	private String [] followQuestion = 
		{"Why do feel that way?", "Why do you feel like that?",
		"What happened to made you feel that way?", "Why?",
		"Can you explain why?", "Why is that the case?"};
	protected static String respond;
	//Array follow up question ends here
	
	/*
	 * followUpQuestion method starts here
	 * This methods acts in a similar fashion to the 
	 * Greeting method, however it produces random
	 * follow up questions to the user.
	 * 
	 */
	public void followUpQuestion()
	{
		pickQuestion = generator.nextInt(followQuestion.length);
		System.out.println(followQuestion[pickQuestion]);
	}//followUpQuestion method ends here
	
	//Read response method starts here
	/*
	 * This method reads the input response of the user.
	 * If the user enters a positive response that is part of the 
	 * positiveMood array, then JavaChat can respond in a positive way
	 * with the followUpQuestion method. If the user enters a negative response
	 * that is part of the negativeMood array, then JavaChat can be sorry to here that,
	 * while continuing with the followUpQuestion method.
	 * Otherwise, if the user enters a response that is not part of either array,
	 * JavaChat can try to question what the user means by being in a loop of nested
	 * if-else statements. This will go on until it founds the word that equals at least one and continue
	 * with the followUpQuestion. 
	 * 
	 */
	public void readResponse(String respond)
	{
		this.respond = respond;
		//int positiveListSize = positiveMood.length-1;
		//int negativeListSize = negativeMood.length-1;
		
		//int moodListSize = positiveListSize + negativeListSize;
		//Legacy code starts here
		/*
			for(int i = 0; i < (moodListSize); i++)
			{
				if(positiveMood[positiveMood.length].equalsIgnoreCase(respond))
				{
					System.out.println("Im happy you feel that way!");
					this.followUpQuestion();
				}
				
				else if(negativeMood[negativeMood.length].equalsIgnoreCase(respond))
				{
					System.out.println("I'm sorry to hear that.");
					this.followUpQuestion();
				}
		*/
		//Legacy code ends here
		//if((positiveMood[positiveListSize].equalsIgnoreCase(respond)))
		
		/*
		 * This if block is based on if the user enters a positive response
		 * 
		 */
		
		for(int i = 0; i < positiveMood.length; i++)
		{
			//if the specific word of the index has a upper case letter at the beginning while
			/*the respond contains that same word that is not upper case, then it sets the word from 
			 * the array to lower case.
			 * 
			 */
			
			/*If the respond contains the word, then it sets boolean isPositive to true. 
			 * if isPositive is true, then it runs the inner loop that also contains the same 
			 * conditions.
			 */
			if(respond.contains(positiveMood[i].toLowerCase()) || respond.contains(positiveMood[i]) && 
				!respond.contains(negativeMood[i].toLowerCase()) && !respond.contains(negativeMood[i]))
			{
				isPositive = true;
				if(isPositive == true)
				{
					/*
					 * This line "(respond.length()-respond.length()+1)" is VERY IMPORTANT!!
					 * the line shows that the entire respond length is subtracted by itself plus one.
					 * This means that the loop repeats only ONE TIME!
					 * this is the same as saying for(int j = 0; j < 1; j++).
					 * 
					 */
					for(int j = 0; j < (respond.length()-respond.length()+1); j++)
					{
						if(respond.contains(positiveMood[i].toLowerCase()) || respond.contains(positiveMood[i]))
						{//this.respond = ""+positiveMood[i]+""+foreTellMood[ForeTellMoodDrive];//Legacy code
							
							System.out.println("I'm happy you feel that way!");
							this.followUpQuestion();
						}
						/*
						else 
						{
							this.WhatResponseIsThat();
						}
						*/		
						//Third Nested if statement block ends here
					}//Inner For loop block ends here
				}//Outer if statement block ends here			
			}//Main if statement block ends here
			
			
		}//Main for loop block ends here
		
		
		//For loop block for negativeMood
		for(int i = 0; i < negativeMood.length; i++)
		{
			//if the specific word of the index has a upper case letter at the beginning while
			/*the respond contains that same word that is not upper case, then it sets the word from 
			 * the array to lower case.
			 * 
			 */
			
			/*If the respond contains the word, then it sets boolean isNegative to true. 
			 * if isNegative is true, then it runs the inner loop that also contains the same 
			 * conditions.
			 */
			if(respond.contains(negativeMood[i].toLowerCase()) || respond.contains(negativeMood[i])
					&& !respond.contains(positiveMood[i].toLowerCase()) || !respond.contains(positiveMood[i]))
			{
				isNegative = true;
				if(isNegative == true)
				{
					/*
					 * This line "(respond.length()-respond.length()+1)" is VERY IMPORTANT!!
					 * the line shows that the entire respond length is subtracted by itself plus one.
					 * This means that the loop repeats only ONE TIME!
					 * this is the same as saying for(int j = 0; j < 1; j++).
					 * 
					 */
					for(int j = 0; j < (respond.length()-respond.length()+1); j++)
					{
						if(respond.contains(negativeMood[i].toLowerCase()) || respond.contains(negativeMood[i]))
						{	//this.respond = ""+positiveMood[i]+""+foreTellMood[ForeTellMoodDrive];//Legacy code
							
							System.out.println("I'm sorry to hear that.");
							this.followUpQuestion();
						}
						/*
						else 
						{
							this.WhatResponseIsThat();
						}
						*/
						//Third Nested if statement block ends here
					}//Inner For loop block ends here
				}//Outer if statement block ends here	
			}//Main if statement block ends here
		}//Main for loop block ends here
	for(int L = 0; L < FinishConversation.length; L++)
	{
		if(respond.contains(FinishConversation[L].toLowerCase()) || respond.contains(FinishConversation[L]))
		{	
			System.out.println("I'm happy we get to talk! I hope everything will be more positive! Good bye!");
			System.exit(0);
		
		}
	}
			//Big for loop and if-else block
		/*
			for(int j = 0; j < (respond.length()-respond.length()+1); j++)
			{
				if(!respond.contains(positiveMood[j].toLowerCase()) || !respond.contains(positiveMood[j]))
				this.WhatResponseIsThat(respond);
			}
			*/
		
		//Legacy code starts here
		
		
		//Legacy code ends here
		
		//If user wants to end convo
		
		
	}//Read response method ends here
	
	public void readResponseV2(String respond)
	{
		for(int L = 0; L < FinishConversation.length; L++)
		{
			for(int m = 0; m < (respond.length()-respond.length()+1); m++)
			{
				if(respond.contains(FinishConversation[L].toLowerCase()) || respond.contains(FinishConversation[L]))
				{	
					respond = "0";
					
					if(respond == "0")
					{
					
					}
				}
			}
			
		}
		
	}
	/*Another followUpQuestion()/Read response method will be developed here,
	 * where it continues to read the response of why
	 * the user feels that way and JavaChat will respond.
	 * It can work like detecting key words like "Achieve" and
	 * "reward" (probably from an array) as an indicator of that.
	 */
	
	public void WhatResponseIsThat()
	{
		for(int k = 0; k < positiveMood.length; k++)
		{
			if(!respond.contains(positiveMood[k].toLowerCase()) || !respond.contains(positiveMood[k]) && 
					!respond.contains(negativeMood[k].toLowerCase()) && !respond.contains(negativeMood[k]))
				{
					isPositive = false;
					if(isPositive == false)
					{
						/*
						 * This line "(respond.length()-respond.length()+1)" is VERY IMPORTANT!!
						 * the line shows that the entire respond length is subtracted by itself plus one.
						 * This means that the loop repeats only ONE TIME!
						 * this is the same as saying for(int j = 0; j < 1; j++).
						 * 
						 */
						for(int l = 0; l < (respond.length()-respond.length()+1); l++)
						{
							if(!respond.contains(positiveMood[l].toLowerCase()) || !respond.contains(positiveMood[l]))
							{//this.respond = ""+positiveMood[i]+""+foreTellMood[ForeTellMoodDrive];//Legacy code
								
								System.out.println("What do you mean that that? Can you explain");
								
							}
							
							//Third Nested if statement block ends here
						}//Inner For loop block ends here
					}//Outer if statement block ends here			
				}//Main if statement block ends here
				
				
			}//Positive Main for loop block ends here
			
			//negative for loop starts here
			for(int k = 0; k < negativeMood.length; k++)
			{
				//For loop block for negativeMood
				for(int i = 0; i < negativeMood.length; i++)
				{
					//if the specific word of the index has a upper case letter at the beginning while
					/*the respond contains that same word that is not upper case, then it sets the word from 
					 * the array to lower case.
					 * 
					 */
					
					/*If the respond contains the word, then it sets boolean isNegative to true. 
					 * if isNegative is true, then it runs the inner loop that also contains the same 
					 * conditions.
					 */
					if(!respond.contains(negativeMood[i].toLowerCase()) || !respond.contains(negativeMood[i])
							&& !respond.contains(positiveMood[i].toLowerCase()) || !respond.contains(positiveMood[i]))
					{
						isNegative = false;
						if(isNegative == false)
						{
							/*
							 * This line "(respond.length()-respond.length()+1)" is VERY IMPORTANT!!
							 * the line shows that the entire respond length is subtracted by itself plus one.
							 * This means that the loop repeats only ONE TIME!
							 * this is the same as saying for(int j = 0; j < 1; j++).
							 * 
							 */
							for(int j = 0; j < (respond.length()-respond.length()+1); j++)
							{
								if(!respond.contains(negativeMood[i].toLowerCase()) || !respond.contains(negativeMood[i]))
								{	//this.respond = ""+positiveMood[i]+""+foreTellMood[ForeTellMoodDrive];//Legacy code
									
									System.out.println("What do you mean by that? Can you explain?");
								}
								
								//Third Nested if statement block ends here
							}//Inner For loop block ends here
						}//Outer if statement block ends here
						
						
					}//Main if statement block ends here
					
				}//Main negative for loop block ends here		
			}
	}
	
	
	/*legacy code starts here
	//Respond why method starts here
	legacy code ends here*/
	
}//Class ends here
