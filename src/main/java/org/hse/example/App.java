package org.hse.example;

import java.util.stream.Stream;

/**
 * Приложение для работы со счастливым
 */
public class App {
    /**
     * Счётчик счастливых билетов
     */
    private static long count = 0L;

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     *
     * @param args аргументы
     */
    public static void main(String... args) {
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
