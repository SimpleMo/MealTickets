package org.hse.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Приложение для работы со счастливым
 */
public class App {

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     *
     * @param args аргументы
     */
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.hse.example");
        Supplier<Long> mealTicketCounter = context.getBean("mealTicketCounter", Supplier.class);
        Integer ticketLength = context.getBean("ticketLength", Integer.class);

        System.out.println("Длина билета " + ticketLength);
        System.out.println("Счастливых билетов " + mealTicketCounter.get());
    }

}
