package org.hse.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;

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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.hse.example");
        Iterator<MealTicket> generator = context.getBean(Iterator.class);
        //todo вынести в отдельный класс все действия с билетами
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
