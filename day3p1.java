import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class day3 {
  public static void main(String[] args) {
    try {
      File myObj = new File("day3.txt");
      Scanner myReader = new Scanner(myObj);
      int total = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        int pocketSize = data.length() / 2;
        String pocket1 = data.substring(0, pocketSize);
        String pocket2 = data.substring(pocketSize);
        
        char[] items = pocket2.toCharArray();
        
        for(int i = 0; i < items.length; i++) {
          if(pocket1.contains(String.valueOf(items[i]))) {

            char match = items[i];

            int unformatedPriority = (int) match;
            if(unformatedPriority >= 97) {
              System.out.printf("%s %d %n", match, unformatedPriority - 96);
              total += unformatedPriority - 96;
            } else {
              System.out.printf("%s %d %n", match, unformatedPriority - 38);
              total += unformatedPriority - 38;
            }
            break;
          } 
        }
       
        

      }
      System.out.println("total: " + total);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}