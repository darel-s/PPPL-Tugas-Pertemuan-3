package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet("John Doe");
    }

    @Test
    public void testAddMoney() {
        wallet.addMoney(10000);
        assertEquals(1, wallet.getMoneys().get(10000));
    }

    @Test
    public void testAddCoin() {
        wallet.addCoin(500);
        assertEquals(1, wallet.getCoins().get(500));
    }

    @Test
    public void testAddCard() {
        wallet.addCard("Credit Card");
        assertTrue(wallet.getCards().contains("Credit Card"));
    }

    @Test
    public void testTakeCard() {
        wallet.addCard("Credit Card");
        wallet.takeCard("Credit Card");
        assertFalse(wallet.getCards().contains("Credit Card"));
    }

    @Test
    public void testTakeCoins() {
        wallet.addCoin(500);
        wallet.takeCoins(500);
        assertEquals(0, wallet.getCoins().get(500));
    }

    @Test
    public void testTakeMoneys() {
        wallet.addMoney(10000);
        wallet.takeMoneys(10000);
        assertEquals(0, wallet.getMoneys().get(10000));
    }

    @Test
    public void testCalculateCoins() {
        wallet.addCoin(500);
        wallet.addCoin(500);
        assertEquals(1000, wallet.calculateCoins());
    }

    @Test
    public void testCalculateMoneys() {
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        assertEquals(15000, wallet.calculateMoneys());
    }

    @Test
    public void testGetMoneyAvailable() {
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addCoin(500);
        wallet.addCoin(500);
        assertEquals(16000, wallet.getMoneyAvailable());
    }
}