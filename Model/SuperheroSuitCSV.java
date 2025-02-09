package mvc_2_67.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuperheroSuitCSV {
    private String FILE_NAME;
    private List<SuperheroSuit> suits = new ArrayList<>();

    public SuperheroSuitCSV(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
        readSuitData();
    }

    private void readSuitData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isHeader = true; // Flag to skip the header line

            while ((line = br.readLine()) != null) {
                // Skip header line
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                if (data.length == 3) {
                    SuperheroSuit suit = createSuit(data[0], data[1], Integer.parseInt(data[2]));
                    suits.add(suit);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private SuperheroSuit createSuit(String id, String type, int durability) {
        return switch (type) {
            case "ชุดทรงพลัง" -> new PowerSuit(id, durability);
            case "ชุดลอบเร้น" -> new StealthSuit(id, durability);
            case "ชุดปกปิดตัวตน" -> new ConcealSuit(id, durability);
            default -> throw new IllegalArgumentException("Invalid suit type");
        };
    }

    public List<SuperheroSuit> getSuits() {
        return suits;
    }

    public SuperheroSuit findSuitById(String id) {
        System.out.println("Searching for Cow ID: " + id); // Debugging line
        for (SuperheroSuit suit : suits) {
            System.out.println("Found Cow ID: " + suit.getId()); // Debugging line
            if ((suit.getId()).equals(id)) {
                return suit;
            }
        }
        return null;
    }
}
