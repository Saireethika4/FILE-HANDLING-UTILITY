import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = "output.txt";

        while (true) {
            System.out.println("\n===== FILE HANDLING UTILITY =====");
            System.out.println("1. Create a File");
            System.out.println("2. Write to a File");
            System.out.println("3. Read a File");
            System.out.println("4. Append to a File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createFile(fileName);
                    break;
                case 2:
                    System.out.print("Enter content to write: ");
                    String writeContent = scanner.nextLine();
                    writeToFile(fileName, writeContent);
                    break;
                case 3:
                    readFile(fileName);
                    break;
                case 4:
                    System.out.print("Enter content to append: ");
                    String appendContent = scanner.nextLine();
                    appendToFile(fileName, appendContent);
                    break;
                case 5:
                    System.out.println("Exiting the utility.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    
    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getName());
            } else {
                System.out.println("⚠️ File already exists.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error creating the file.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("✅ Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to the file.");
            e.printStackTrace();
        }
    }

    
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("📄 File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading the file.");
            e.printStackTrace();
        }
    }

     
    public static void appendToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + content);
            System.out.println("✅ Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("❌ Error appending to the file.");
            e.printStackTrace();
        }
    }
}
