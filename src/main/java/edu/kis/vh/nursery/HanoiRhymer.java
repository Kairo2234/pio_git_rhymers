package edu.kis.vh.nursery;

/**
 * Klasa HanoiRhymer rozszerza funkcjonalność klasy DefaultCountingOutRhymer
 * o mechanizm odrzucania wprowadzonych wartości, które są większe niż
 * wartość na szczycie stosu. Klasa ta jest używana w kontekście
 * problemu wież Hanoi.
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {

    private int totalRejected = 0; // Liczba odrzuconych wartości

    /**
     * Zwraca łączną liczbę wartości, które zostały odrzucone
     * podczas dodawania nowych wartości do stosu.
     *
     * @return liczba odrzuconych wartości
     */
    public int reportRejected() {
        return totalRejected;
    }

    /**
     * Dodaje nową wartość do stosu. Jeśli stos nie jest pusty i
     * nowa wartość jest większa niż wartość na szczycie stosu,
     * to wartość zostaje odrzucona, a licznik odrzuconych
     * wartości zostaje zwiększony.
     *
     * @param in wartość do dodania do stosu
     */
    @Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo()) {
            totalRejected++; // Zwiększ licznik odrzuconych wartości
        } else {
            super.countIn(in); // Dodaj wartość do stosu
        }
    }
}
