package org.hse.example;

/**
 * Приложение для работы со счастливым
 */
public class App {

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     * @param args аргументы
     */
    public static void main(String... args) {
        long count = 0L;
        for (long i = 0; i < 1000000; i++){
            //Получаем билет
            Ticket ticket = new Ticket(i); // почему не портится i?

            if(!ticket.isMealTicket()) {
                continue; // билет не является счастливым, пропускаем дальнейшее
            }

            //Если счастливый, увеличиваем счётчик и выводим
            count++;
            System.out.println(ticket.toString());
        }
        System.out.println("Счастливых билетов " + count);
    }

}
