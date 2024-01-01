import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+=============================================+");
            System.out.println("|           Aplikasi Konversi Suhu            |");
            System.out.println("+=============================================+");
            System.out.println("|1. Celsius                                   |");
            System.out.println("|2. Fahrenheit                                |");
            System.out.println("|3. Kelvin                                    |");
            System.out.println("|4. Keluar                                    |");
            System.out.println("+=============================================+");
            System.out.print("Pilih jenis suhu yang ingin dikonversi:");

            int jenisSuhuAwal = scanner.nextInt();

            if (jenisSuhuAwal == 4) {
                System.out.println("Terima kasih! Program selesai.");
                break;
            }

            KonversiSuhu konversiSuhu;

            switch (jenisSuhuAwal) {
                case 1:
                    konversiSuhu = new KonversiCelcius();
                    break;
                case 2:
                    konversiSuhu = new KonversiFahrenheit();
                    break;
                case 3:
                    konversiSuhu = new KonversiKelvin();
                    break;
                default:
                    System.out.println("Pilihan jenis suhu tidak valid");
                    return;
            }

            System.out.print("Masukkan suhu: ");
            double suhuAwal = scanner.nextDouble();

            System.out.println("+=============================================+");
            System.out.println("|           Aplikasi Konversi Suhu            |");
            System.out.println("+=============================================+");
            System.out.println("|1. Celsius                                   |");
            System.out.println("|2. Fahrenheit                                |");
            System.out.println("|3. Kelvin                                    |");
            System.out.println("+=============================================+");
            System.out.print("Pilih jenis suhu konversi:");

            int jenisSuhuKonversi = scanner.nextInt();

            double hasilKonversi;

            switch (jenisSuhuKonversi) {
                case 1:
                    hasilKonversi = konversiSuhu.konversiKeCelsius(suhuAwal);
                    System.out.println("Hasil konversi: " + hasilKonversi + " Celsius");
                    break;
                case 2:
                    hasilKonversi = konversiSuhu.konversiKeFahrenheit(suhuAwal);
                    System.out.println("Hasil konversi: " + hasilKonversi + " Fahrenheit");
                    break;
                case 3:
                    hasilKonversi = konversiSuhu.konversiKeKelvin(suhuAwal);
                    System.out.println("Hasil konversi: " + hasilKonversi + " Kelvin");
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan jenis suhu konversi tidak valid");
            }

            System.out.println("Tekan Enter untuk melanjutkan atau ketik 'clear' untuk membersihkan layar:");
            String input = scanner.nextLine(); // Consume the previous newline
            input = scanner.nextLine(); // Read user input

            if (input.equalsIgnoreCase("clear")) {
                clearScreen();
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
