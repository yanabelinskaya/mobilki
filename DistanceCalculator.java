import java.util.Scanner;

public class DistanceCalculator {

    // Радиус Земли в километрах
    private static final double EARTH_RADIUS = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выводим приветственное сообщение
        System.out.println("Программа для вычисления расстояния между двумя точками на земной поверхности.");

        // Запрашиваем координаты первой точки
        System.out.println("Введите координаты первой точки:");
        double[] coordinates1 = readCoordinates(scanner);

        // Запрашиваем координаты второй точки
        System.out.println("Введите координаты второй точки:");
        double[] coordinates2 = readCoordinates(scanner);

        // Вычисляем расстояние между точками
        double distance = calculateDistance(coordinates1[0], coordinates1[1], coordinates2[0], coordinates2[1]);

        // Выводим результат
        System.out.println("Расстояние между двумя точками: " + distance + " км");

        scanner.close();
    }

    // Метод для чтения координат точки из консоли
    private static double[] readCoordinates(Scanner scanner) {
        // Выводим сообщение о запросе ввода долготы и широты
        System.out.println("Введите долготу в градусах:");
        double latitude = scanner.nextDouble();
        System.out.println("Введите широту в градусах:");
        double longitude = scanner.nextDouble();
        return new double[]{latitude, longitude}; // Возвращаем массив с введенными координатами
    }

    // Метод для вычисления расстояния между двумя точками на поверхности сферы с использованием формулы Винсента
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Переводим градусы в радианы
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Вычисляем разницу между долготами
        double dLon = lon2 - lon1;

        // Вычисляем расстояние с использованием формулы Винсента
        double a = Math.pow(Math.cos(lat2) * Math.sin(dLon), 2) +
                Math.pow(Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(dLon), 2);
        double b = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(dLon);

        return EARTH_RADIUS * Math.atan2(Math.sqrt(a), b); // Возвращаем расстояние между точками
    }
}
