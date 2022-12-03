import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class day3p2 {
  public static void main(String[] args) {
    try {
      File myObj = new File("day3.txt");
      Scanner myReader = new Scanner(myObj);
      int total = 0;
      while (myReader.hasNextLine()) {
        String data1 = myReader.nextLine();
        String data2 = myReader.nextLine();
        String data3 = myReader.nextLine();

        found:
        for(int y = 0; y< data1.length(); y++) {
            for(int i = 0; i < data2.length(); i++) {
                        for(int j = 0; j < data3.length(); j++) {
                              if(data1.split("")[y].equals(data2.split("")[i]) && data2.split("")[i].equals(data3.split("")[j])) {
                                    char match = data3.toCharArray()[j];
                                    
                                    int unformatedPriority = (int) match;
                                    if(unformatedPriority >= 97) {
                                    System.out.printf("%s %d %n", match, unformatedPriority - 96);
                                    total += unformatedPriority - 96;
                                    } else {
                                    System.out.printf("%s %d %n", match, unformatedPriority - 38);
                                    total += unformatedPriority - 38;
                                    }
                                 break found;
                              }
                        }
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