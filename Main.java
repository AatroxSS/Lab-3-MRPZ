import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Patient[] patients = {
                new Patient(1, "Коваленко", "вул. Шевченка, 12", "+380501234567", 1005, "Грип"),
                new Patient(2, "Іваненко", "вул. Франка, 34", "+380671234567", 1012, "Ангіна"),
                new Patient(3, "Петренко", "пр. Перемоги, 45", "+380631234567", 1050, "Грип"),
                new Patient(4, "Сидоренко", "вул. Лесі Українки, 5", "+380991234567", 1088, "Бронхіт"),
                new Patient(5, "Ткаченко", "вул. Грушевського, 77", "+380971234567", 1102, "Ангіна")
        };

        System.out.println("--- БАЗА ДАНИХ ПАЦІЄНТІВ ---");
        printPatients(patients);

        System.out.println("\n--- ПОШУК ЗА ДІАГНОЗОМ ---");
        System.out.print("Введіть діагноз для пошуку (наприклад, Грип): ");
        String targetDiagnosis = scanner.nextLine().trim();
        searchByDiagnosis(patients, targetDiagnosis);

        System.out.println("\n--- ПОШУК ЗА НОМЕРОМ МЕДИЧНОЇ КАРТКИ ---");
        int minRange = getValidIntInput(scanner, "Введіть початкове значення діапазону (від): ");
        int maxRange = getValidIntInput(scanner, "Введіть кінцевое значення діапазону (до): ");

        if (minRange > maxRange) {
            System.out.println("Помилка: початкове значення більше за кінцеве. Міняємо їх місцями.");
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        searchByMedicalCardRange(patients, minRange, maxRange);

        scanner.close();
    }

    private static void printPatients(Patient[] patients) {
        Patient.printTableHeader();
        for (Patient p : patients) {
            p.printTableRow();
        }
        Patient.printTableFooter();
    }

    private static void searchByDiagnosis(Patient[] patients, String diagnosis) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                if (!found) {
                    Patient.printTableHeader();
                }
                p.printTableRow();
                found = true;
            }
        }
        if (found) {
            Patient.printTableFooter();
        } else {
            System.out.println("❌ Пацієнтів із діагнозом '" + diagnosis + "' не знайдено.");
        }
    }

    private static void searchByMedicalCardRange(Patient[] patients, int min, int max) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getMedicalCardNumber() >= min && p.getMedicalCardNumber() <= max) {
                if (!found) {
                    Patient.printTableHeader();
                }
                p.printTableRow();
                found = true;
            }
        }
        if (found) {
            Patient.printTableFooter();
        } else {
            System.out.println("❌ Пацієнтів з номером картки в діапазоні [" + min + " - " + max + "] не знайдено.");
        }
    }

    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("⚠ Помилка: Номер не може бути від'ємним. Спробуйте ще раз.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("⚠ Помилка введення: Будь ласка, введіть коректне ціле число.");
            }
        }
    }
}
