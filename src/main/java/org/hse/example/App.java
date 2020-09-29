package org.hse.example;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Приложение для работы со счастливым
 */
public class App {

    private static long count = 0; // для грязного хака с лямблами

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     *
     * @param args аргументы
     */
    public static void main(String... args) {
        Consumer<Ticket> mealTicketCounter = getTicketConsumer();
        for (long i = 0; i < 1000000; i++) {
            //Получаем билет
            Ticket ticket = new Ticket(i);

            //Обрабтываем полученный билет
            mealTicketCounter.accept(ticket) ;
        }
        System.out.println("Счастливых билетов " + count);
    }

    /**
     * Возвращает {@link Consumer} экземпляров класса {@link Ticket}.
     * В данном случае обработка следующая: считает количество счастливых билетов
     * сохраняя результат в {@link App#count} и выводит в консоль счастливые билеты
     *
     * @return сформированный
     */
    private static Consumer<Ticket> getTicketConsumer() {
        Consumer<Ticket> mealTicketCounter =
                (ticket) -> {
                    if (!ticket.isMealTicket()) {
                        return;
                    }

                    count++;
                };
        return mealTicketCounter
                .andThen((ticket) -> {
                    if (!ticket.isMealTicket()) {
                        return;
                    }

                    System.out.println(ticket.toString());
                });
    }

}
