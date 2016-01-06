
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
   public static void main(String[] args) {
      int menuOp;
      Scanner in = new Scanner(System.in);
   
      do {
         Menu();
         menuOp = in.nextInt();
      
         if (menuOp < 0 || menuOp > 3) {
            InvalidOption();
         }
      
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

   public static  void MenuOption3(){
      System.out.println("This option is not working yet. Please enter another option.");
   }

   public static void MenuOption2(){
      final int RATE_NUMBER = 8000;
      int channelNum = 1;
      int legalBits = 8;
      int freqNum;
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter the filename and frequency you would like.");
      System.out.print("Filename: ");
      String name = in.nextLine();
      System.out.print("Frequency: ");
      freqNum = in.nextInt();
      double sineWav = Math.sin(2 * Math.PI * freqNum);
      WavFile fileFrequency = new WavFile(name + ".wav", channelNum, RATE_NUMBER, legalBits, RATE_NUMBER);
      ArrayList <Double> audioSamples = new ArrayList<>();
      audioSamples.toString();
   
      for(int i = 0; i < fileFrequency.getNumFrames(); i++){
         audioSamples.add(sineWav * i / fileFrequency.getSampleRate());
      }
   
      if(fileFrequency.getNumFrames() == fileFrequency.getSampleRate()){
         System.out.println(name + ".wav at a frequency of " + freqNum);
         fileFrequency.setSamples(audioSamples);
         fileFrequency.close();
      }
   
   }

   public static void MenuOption1(){
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter the name of the file you would like.");
      System.out.print("Filename: ");
      String name = in.nextLine();
      WavFile original = new WavFile(name + ".wav");
      ArrayList <Double> audioSamples = original.getSamples();
      ArrayList <Double> reversed = new ArrayList<>();
      audioSamples.toString();
   
      for(int i = audioSamples.size()-1; i >= 0; i--){
         reversed.add(audioSamples.get(i));
      }
      WavFile reverse = new WavFile(name + "r.wav", original.getNumChannels(),
          original.getNumFrames(), original.getValidBits(), original.getSampleRate());
      reverse.setSamples(reversed);
      reverse.close();
      System.out.println(name + "r.wav");
   }

   public static void Menu(){
      System.out.println("Menu:");
      System.out.println("0.) Exit");
      System.out.println("1.) do option 1");
      System.out.println("2.) do option 2");
      System.out.println("3.) do option 3");
      System.out.println("Please enter the option you would like:");
   }

   public static void InvalidOption(){
      System.out.println("That is not an option! Please enter a valid option.");
   }
}
