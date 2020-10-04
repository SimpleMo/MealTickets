package org.hse.example;

import java.util.function.Consumer;
import java.util.function.Supplier;

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
