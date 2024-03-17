import java.util.ArrayList;
import java.util.Scanner;

public class pr4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для ввода данных с клавиатуры

        String[] brands = {"Rolex", "Casio", "Cartier"}; // Массив с названиями брендов часов
        String[] models = {"Breitling", "G-Shock", "Panthere de Cartier Small"}; // Массив с названиями моделей часов
        ArrayList<String[]> orders = new ArrayList<>(); // Список заказов покупателей

        // Создание трех заказов
        for (int i = 0; i < 3; i++) {
            System.out.println("\nОформление заказа " + (i + 1) + ":");

            // Ввод информации о покупателе
            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Номер телефона: ");
            String number = scanner.nextLine();

            // Вывод доступных позиций (моделей и брендов) часов
            System.out.println("Доступные позиции:");
            for (int j = 0; j < models.length; j++) {
                System.out.println((j + 1) + ". " + brands[j] + " - " + models[j]);
            }

            // Выбор позиции и ввод количества товара
            System.out.print("Выберите позицию: ");
            int positionIndex = Integer.parseInt(scanner.nextLine()) - 1;

            String[] position = {models[positionIndex], brands[positionIndex]}; // Сохранение выбранной позиции (модели и бренда)

            System.out.print("Введите количество: ");
            int count = Integer.parseInt(scanner.nextLine());

            // Создание массива с информацией о заказе и добавление его в список заказов
            String[] order = {name, email, number, position[0], position[1], String.valueOf(count)};
            orders.add(order);
        }

        // Вывод деталей заказов
        System.out.println("\nДетали заказов:");
        for (String[] order : orders) {
            System.out.println("Клиент: " + order[0]);
            System.out.println("Email: " + order[1]);
            System.out.println("Телефон: " + order[2]);
            System.out.println("Позиция: " + order[3] + " - " + order[4]);
            System.out.println("Количество: " + order[5]);
            System.out.println("---------------------");
        }
    }
}
