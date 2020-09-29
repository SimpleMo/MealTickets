package org.hse.example;

/**
 * Класс для обработки счастливого билета
 */
public class MealTicketCounter {

    private long count;

    /**
     * Первоначальные настройки обработчика
     */
    public MealTicketCounter() {
        count = 0;
    }

    /**
     * Метод обработчик. В данном случае считает счастливые билеты, и, если билет счастливый, выводит его в консоль
     *
     * @param ticket обрабатываемый билет
     */
    public void process(Ticket ticket) {
        if (!ticket.isMealTicket()) {
            return;
        }

        count++;
        System.out.println(ticket.toString());
    }

    /**
     * @return количество счастливых билетов
     */
    public long getCount() {
        return count;
    }
}
