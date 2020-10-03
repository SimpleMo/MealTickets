package org.hse.example;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        //Реализуем служеюный Iterable
        TicketsGenerator generator = new TicketsGenerator();
        Iterable<Ticket> ticketIterable = () -> generator;

        //А теперь получим результат с помощью собственного Stream!
        long count =
                StreamSupport // сервис для низкоуровневой работы со стримами
                        .stream(ticketIterable.spliterator(), false)
                        .filter(Ticket::isMealTicket)
                        .map(Ticket::toString)
                        .peek(System.out::println)
                        .count();

        System.out.println("Счастливых билетов " + count);
    }

}
