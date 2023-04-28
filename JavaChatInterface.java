/*
 *This class contains an array of positive words that 
 *the java chat-bot can reference and look at to detect
 *a positive and negative word from the user.
 *@author Ferdinand K. Yeke
 * 
 */

public interface JavaChatInterface {

	String [] positiveMood = {"Happy","Upbeat","Energetic",
			"Charismatic","Jolly","Excited","Giddy","Good",
			"Alright","Fine","OK","Amazing","Good State","Confident","Lovely", "Great"
			};
	
	String[] negativeMood = {"Sad", "Angry", "Mad", "Foggy","Disappointed",
			"Despair","Denial","Conflicted","Apathatic",
			"Bad", "Negative","Hateful","Not","Disappointed","Terrible","Frustrated"};
	
	String[] PositiveForeTellMood = {"Feel", "Doing", "Acting", "Moving","Accomplished","Impressive","Feat"
										,"Achieved","Reward"};
	String[] negativeForeTellMood = {"Nothing"};
	
	String[] FinishConversation = {"end it here", "done talking to you", "stop the conversation here"};
	
	
}
