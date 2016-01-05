
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to create a menu for a user to choose what they would like
 * done with the audio files they input, and then specifies what each option should do.
 * @version
 */
public class Demo {
/**
 * This is the main method of the Lab1 class that utilizes the MeuOption1
 * and MenuOption2 methods to complete the tasks of each menu option.
 * @param args
 */
   public static void main(String[] args) {
   //Variables needed within this method.
      int menuOp;
      Scanner in = new Scanner(System.in);
   
   //The loop is used to keep reprompting the user for another menu option when needed.
      do {
         Menu();
         menuOp = in.nextInt();
      
      //makes sure that the program will not crash if other values are entered.
         if (menuOp < 0 || menuOp > 3) {
            InvalidOption();
         }
      
      //Switch statement used to complete each task the user
      // would like depending on the menu option they enter.
         switch (menuOp) {
            case 0:
               System.exit(0);
               break;
         
            case 1:
               MenuOption1();
               break;
         
            case 2:
               MenuOption2();
               break;
         
            case 3:
               MenuOption3();
               break;
         }
      
      } while (menuOp != 0);
   
      System.exit(0);
   }

/**
 * This method is supposed to complete the task for menu option 3.
 */
   public static  void MenuOption3(){
   //reprompts the user for another menu option because this one is not finished.
      System.out.println("This option is not working yet. Please enter another option.");
   }

/**
 * This method prompts the user for a WavFile file name and a frequency of their
 * choice and plays one second of the audio file back at that specific frequency.
  */
   public static void MenuOption2(){
     //all variables needed throughout this program.
      final int RATE_NUMBER = 8000;
      int channelNum = 1;
      int legalBits = 8;
      int freqNum;
      Scanner in = new Scanner(System.in);
   //prompts the user for a file name and frequency.
      System.out.println("Please enter the filename and frequency you would like.");
      System.out.print("Filename: ");
      String name = in.nextLine();
      System.out.print("Frequency: ");
      freqNum = in.nextInt();
      double sineWav = Math.sin(2 * Math.PI * freqNum);
      WavFile fileFrequency = new WavFile(name + ".wav", channelNum, RATE_NUMBER, legalBits, RATE_NUMBER);
   //ArrayList that stores all of the samples entered.
      ArrayList <Double> audioSamples = new ArrayList<>();
      audioSamples.toString();
   
   //loop that calculates the sine wav of each frequency.
      for(int i = 0; i < fileFrequency.getNumFrames(); i++){
         audioSamples.add(sineWav * i / fileFrequency.getSampleRate());
      }
   
   //if statement that checks that the number of frames and sampleRate
   // are equal so the audio will play.
      if(fileFrequency.getNumFrames() == fileFrequency.getSampleRate()){
      //outputs the whole file name
         System.out.println(name + ".wav at a frequency of " + freqNum);
       //Plays the audio at the frequency entered by the user.
         fileFrequency.setSamples(audioSamples);
         fileFrequency.close();
      }
   
   }

/**
 * This method is used to prompt the user for a WavFile file
 * name and stores it in an ArrayList. Then plays it back in reverse.
 */
   public static void MenuOption1(){
      Scanner in = new Scanner(System.in);
   //Prompts the user for a file name.
      System.out.println("Please enter the name of the file you would like.");
      System.out.print("Filename: ");
      String name = in.nextLine();
      WavFile original = new WavFile(name + ".wav");
   //ArrayList of all the samples entered.
      ArrayList <Double> audioSamples = original.getSamples();
   //New ArrayList for when the samples are flipped.
      ArrayList <Double> reversed = new ArrayList<>();
      audioSamples.toString();
   
    //loop that gets all of the file names and adds them to the ArrayList,
      for(int i = audioSamples.size()-1; i >= 0; i--){
         reversed.add(audioSamples.get(i));
      }
   
   //Takes all of the "flipped" files and plays them back in reverse.
      WavFile reverse = new WavFile(name + "Rev.wav", original.getNumChannels(),
          original.getNumFrames(), original.getValidBits(), original.getSampleRate());
      reverse.setSamples(reversed);
      reverse.close();
   //outputs the new reverse file name.
      System.out.println(name + "Rev.wav");
   }

/**
 * This method is used to generate a menu of all the menu options and what they do.
 */
   public static void Menu(){
   //The menu used throughout the program.
      System.out.println("Menu:");
      System.out.println("0.) Exit");
      System.out.println("1.) Play audio in reverse");
      System.out.println("2.) Play audio at specific frequency");
      System.out.println("3.) Play audio at specific frequency in stereo");
      System.out.println("Please enter the option you would like:");
   }

/**
 * This method tells the user when their entries are invalid.
 */
   public static void InvalidOption(){
      System.out.println("That is not an option! Please enter a valid option.");
   }
}
