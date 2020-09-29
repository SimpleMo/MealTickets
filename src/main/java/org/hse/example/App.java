package org.hse.example;

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
        MealTicketCounter mealTicketCounter = new MealTicketCounter();
        for (long i = 0; i < 1000000; i++) {
            //Получаем билет
            Ticket ticket = new Ticket(i);

            //Обрабтываем полученный билет
            mealTicketCounter.process(ticket);
        }
        System.out.println("Счастливых билетов " + mealTicketCounter.getCount());
    }

}
