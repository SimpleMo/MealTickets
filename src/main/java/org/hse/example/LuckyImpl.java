package org.hse.example;

import java.util.Arrays;

/**
 * Класс для моделирования билета
 */
public class LuckyImpl implements Lucky {
    private int[] ticket;

    /**
     * @param ticket номер билета в виде целого числа
     */
    public LuckyImpl(long ticket) {
        this.ticket = new int[]{0, 0, 0, 0, 0, 0};
        int j = 5;
        while (ticket > 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    /**
     * @return true, если билет счастливый
     */
    public boolean isLucky() {
        int firstSum = ticket[0] + ticket[1] + ticket[2];
        int lastSum = ticket[3] + ticket[4] + ticket[5];

        return firstSum == lastSum;
    }

    @Override
    public String toString() {
        return "Ticket{" + Arrays.toString(ticket) + "}";
    }
}