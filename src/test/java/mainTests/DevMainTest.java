package mainTests;

import main.Main;

/**
 * Testing the dev mode.
 */
public class DevMainTest {
    /**
     * Main method of this test.
     *
     * @param args Command-line arguments (none needed nor supported).
     */
    public static void main(String[] args) {
        Main.main(new String[] {Main.DEV_MODE_ID});
    }
}