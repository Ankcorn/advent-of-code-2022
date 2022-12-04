import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class day3 {
  public static void main(String[] args) {
    try {
      File myObj = new File("day3.txt");
      Scanner myReader = new Scanner(myObj);
      int part1 = 0;
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
              part1 += unformatedPriority - 96;
            } else {
              part1 += unformatedPriority - 38;
            }
            break;
          } 
        }
       
        

      }
      System.out.println("part1: " + part1);
      myReader.close();

      Scanner input2 = new Scanner(myObj);
      int part2 = 0;
      while (input2.hasNextLine()) {
        String data1 = input2.nextLine();
        String data2 = input2.nextLine();
        String data3 = input2.nextLine();

        found:
        for(int y = 0; y< data1.length(); y++) {
            for(int i = 0; i < data2.length(); i++) {
                        for(int j = 0; j < data3.length(); j++) {
                              if(data1.split("")[y].equals(data2.split("")[i]) && data2.split("")[i].equals(data3.split("")[j])) {
                                    char match = data3.toCharArray()[j];
                                    
                                    int unformatedPriority = (int) match;
                                    if(unformatedPriority >= 97) {
                                    part2 += unformatedPriority - 96;
                                    } else {
                                    part2 += unformatedPriority - 38;
                                    }
                                 break found;
                              }
                        }
                  }
            }
      }
      System.out.println("part2: " + part2);
      input2.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}