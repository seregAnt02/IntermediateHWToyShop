package IntermediateHWToyShop.presentation;

import java.util.Scanner;

import IntermediateHWToyShop.model.Toy;
import IntermediateHWToyShop.view.InputNumberValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;



public class ToyCSVHandler {

    private final String CSV_SEPARATOR = ",";    
    private final String FILE_NAME_TOYS = "/Project/IntermediateHWToyShop/db/toys.csv";

    /**
     * Добавление новой игрушки.
     */
     public void addNewToy() {

        PriorityQueue<Toy> toys = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя игрушки: ");
        String name = scanner.nextLine();
        System.out.println("Введите вес игрушки: ");
        int weight = InputNumberValidator.choice();       
        toys.add(new Toy(getNewToyId(), name, weight, chanceFallingOut(weight)));
        writeToFile(FILE_NAME_TOYS, toys);
    }

    /**
     * Шанс выпадения игрушки, в соответствий с весом.
     * @param weight вес игрушки.
     * @return
     */
     private int chanceFallingOut(int weight){
        switch (weight) {
            case 1: return 20;                                    
            case 2: return 40;
            case 3: return 60;
            default:
                break;
        }
        return 0;
    }

    /**
     * Добавление в массив модели типа Toy, в соответствии случайным весом.
     * @param toys
     * @return
     */
    public PriorityQueue<Toy> get(PriorityQueue<Toy> toys){
        PriorityQueue<Toy> toysOut = new PriorityQueue<>();            
            int randomInt = (int)(Math.random() * 3) + 1;
            for(Toy toy : toys){
                if(toy.getWeight() == randomInt){
                    toysOut.add(toy);
                }
            }
        return toysOut;
    }

    /**
     * Считывание файла и добавление в массив.
     * @param fileName
     * @return
     */
    public PriorityQueue<Toy> readFromFile(String fileName) {
        PriorityQueue<Toy> toys = new PriorityQueue<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(CSV_SEPARATOR);

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                int amount = Integer.parseInt(fields[2].trim());
                int dropFrequency = Integer.parseInt(fields[3].trim());


                Toy toy = new Toy(id, name, amount, dropFrequency);
                toys.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toys;
    }                                          

    private int getNewToyId() {
        return startId(FILE_NAME_TOYS);
    }

    private int startId(String fileNameBuyers) {
        int maxId = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileNameBuyers));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].replaceAll("\"", ""));
                if (id > maxId) {
                    maxId = id;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    /**
     * Запись массива в файл.
     * @param fileName имя файла.
     * @param toys массив игрушек.
     */
    public void writeToFile(String fileName, PriorityQueue<Toy> toys) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            appendToFileLine(toys, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendToFileLine(PriorityQueue<Toy> toys, FileWriter writer) throws IOException {
        for (Toy toy : toys) {
            //writer.append("\n");
            writer.append(String.valueOf(toy.getId()));
            writer.append(CSV_SEPARATOR);
            writer.append(toy.getName());
            writer.append(CSV_SEPARATOR);
            writer.append(String.valueOf(toy.getWeight()));
            writer.append(CSV_SEPARATOR);
            writer.append(String.valueOf(toy.getDropFrequency()));
            writer.append("\n");
        }

        writer.flush();
    }

}
