package org.hse.example;

/**
 * Приложение для работы со счастливым
 */
public class App {
    /**
     * Счётчик счастливых билетов
     */
    private static long count = 0; // для грязного хака с лямблами

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     *
     * @param args аргументы
     */
    public static void main(String... args) {
        //Реализуем служеюный Iterable
        //todo подменить генератор на тот, что для билетов из 4-х цифр
        TicketsGenerator generator = new TicketsGenerator();
        generator.forEachRemaining(
                ticket -> {
                    if (!ticket.isMealTicket()) {
                        return;
                    }
                    count++;
                    System.out.println(ticket.toString());
                });

        System.out.println("Счастливых билетов " + count);
    }

}
