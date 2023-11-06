package IntermediateHWToyShop.view;

public class ViewMenu {
    public static void delimiter() {
        System.out.println("*".repeat(50));
    }

    public static void pageHeadMenuView() {
        delimiter();
        System.out.println("\t\tМагазин детских товаров");
        delimiter();
        System.out.println("Выберите пункт меню:");
        System.out.println("1. Игрушки.");                
        System.out.println("2. Выход из программы.");
    }
    public static void pageToyView() {
        delimiter();
        System.out.println("\t\t\tИгрушки");
        delimiter();
        System.out.println("Выберите пункт меню:");
        System.out.println("1. Посмотреть игрушки, в соответствии с весом.");
        System.out.println("2. Добавить новую игрушку.");        
        System.out.println("3. Выход в главное меню.");
    }       
}
