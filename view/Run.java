package IntermediateHWToyShop.view;

import java.util.PriorityQueue;

import IntermediateHWToyShop.model.Toy;
import IntermediateHWToyShop.presentation.ToyCSVHandler;

public class Run {
    private final String FILE_NAME_TOYS = "/Project/IntermediateHWToyShop/db/toys.csv";

    private ToyCSVHandler toyCSVHandler;

    public Run() {
        toyCSVHandler = new ToyCSVHandler();
    }

    public void run() {
        int numberOfMenu;
        do {
            ViewMenu.pageHeadMenuView();
            numberOfMenu = InputNumberValidator.choice();
            switch (numberOfMenu) {
                case 1:
                    runToys();
                    break;                               
                case 2:
                    break;
                default:
                    System.out.println("\n\tНекорректный ввод. Попробуйте еще раз.");
            }
        } while (numberOfMenu != 2);
    }

    private void runToys() {
        int numberOfMenu;
        do {
            ViewMenu.pageToyView();
            numberOfMenu = InputNumberValidator.choice();
            switch (numberOfMenu) {
                case 1:
                     PriorityQueue<Toy> toys = toyCSVHandler.readFromFile(FILE_NAME_TOYS);                     
                    System.out.println(toyCSVHandler.get(toys));
                    break;
                case 2:
                    toyCSVHandler.addNewToy();
                    break;               
                case 3:
                    break;
                default:
                    System.out.println("\n\tНекорректный ввод. Попробуйте еще раз.");
            }
        } while (numberOfMenu != 3);
    }
    
}
