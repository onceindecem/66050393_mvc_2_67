package mvc_2_67;

import mvc_2_67.Controller.SuperheroSuitController;
import mvc_2_67.Model.SuperheroSuitCSV;
import mvc_2_67.View.SuperheroSuitView;

public class SuperheroSuitWindow {
    public static void main(String[] args) {
        // Define the path to the CSV file containing cow data
        String filePath = "mvc_2_67\\suit_data.csv";

        // Initialize the model with the CSV file path
        SuperheroSuitCSV model = new SuperheroSuitCSV(filePath);

        // Create an instance of the view
        SuperheroSuitView view = new SuperheroSuitView();

        // Create the controller, passing in the view and model
        SuperheroSuitController controller = new SuperheroSuitController(view, model);

        // Set the controller in the view
        view.setController(controller);

        // Make the view visible to the user
        view.setVisible(true);
    }
}
