package mvc_2_67.Controller;

import mvc_2_67.Model.*;
import mvc_2_67.View.SuperheroSuitView;

public class SuperheroSuitController {
    private SuperheroSuitView view;
    private SuperheroSuitCSV model;
    private int totalPowerSuitRepair = 0;
    private int totalStealthSuitRepair = 0;
    private int totalConcealSuitRepair = 0;
    private SuperheroSuit curSuit;

    public SuperheroSuitController(SuperheroSuitView view, SuperheroSuitCSV model) {
        this.view = view;
        this.model = model;
    }

    public void checkSuit(String id) {
        // Validate the Suit ID
        if (!id.matches("\\d{8}")) {
            // Check if the ID is numeric but not 8 digits
            if (id.matches("\\d+")) {
                view.displayResult("Please enter 8 numbers.");
            } else {
                // Non-numeric ID or start with 0
                view.displayResult("Invalid Data !!!");
            }
            return;
        }

        // find Suit in database using ID
        curSuit = model.findSuitById(id);
        if (curSuit != null) {
            // Check if this suit need to be repaired
            boolean checkIfNeedRepair = curSuit.checkIfNeedRepair();
            if (checkIfNeedRepair) {
                view.needRepair(curSuit.checkIfNeedRepair());
                String output = String.format(
                        "Suit ID: %s\nType: %s\n" +
                        "Durability: %d\n" +
                        "Need to repair\n" ,
                        curSuit.getId(), curSuit.getType(),
                        curSuit.getDurability()
                        );
    
                // Display the result for the suit needs repair
                view.displayResult(output);
            } else {
                String output = String.format(
                        "Suit ID: %s\nType: %s\n" +
                        "Durability: %d\n" +
                        "No repair required\n" +
                        "Total Power Suit are Reapaired : %d\n" + 
                        "Total Stealth Suit are Reapaired : %d\n" + 
                        "Total Conceal Suit are Reapaired : %d\n",
                        curSuit.getId(), curSuit.getType(),
                        curSuit.getDurability(), totalPowerSuitRepair, 
                        totalStealthSuitRepair, totalConcealSuitRepair
                        );
    
                // Display the result for the suit doesn't need repair
                view.displayResult(output);
                view.clearInput();
            }
        } else {
            view.displayResult("Superhero Suit ID not found in the database.");
        }
    }

    public void repairSuit() {
        // Repair suit
        curSuit.repair();
        if (curSuit instanceof PowerSuit) {
            totalPowerSuitRepair++;
        } else if (curSuit instanceof StealthSuit) {
            totalStealthSuitRepair++;
        } else if (curSuit instanceof ConcealSuit) {
            totalConcealSuitRepair++;
        }

        String output = String.format(
                "Suit ID: %s\nType: %s\n" +
                "Repairing....\n" +
                "Repair Completed Durability(+25)\n" +
                "(^)Durability: %d\n" + 
                "Total Power Suit are Reapaired : %d\n" + 
                "Total Stealth Suit are Reapaired : %d\n" + 
                "Total Conceal Suit are Reapaired : %d\n" ,
                curSuit.getId(), curSuit.getType(),
                curSuit.getDurability(), totalPowerSuitRepair, 
                totalStealthSuitRepair, totalConcealSuitRepair
                );

        // Display the result
        view.displayResult(output);
        view.clearInput(); // prepare for next round
    }
}
