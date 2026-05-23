public class Patient {
    private int id;
    private String surname;
    private String address;
    private String phone;
    private int medicalCardNumber;
    private String diagnosis;

    public Patient(int id, String surname, String address, String phone, int medicalCardNumber, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public String getSurname() { return surname; }
    public int getMedicalCardNumber() { return medicalCardNumber; }
    public String getDiagnosis() { return diagnosis; }

    public void printTableRow() {
        System.out.printf("| %-4d | %-15s | %-20s | %-15s | %-17d | %-15s |%n",
                id, surname, address, phone, medicalCardNumber, diagnosis);
    }

    public static void printTableHeader() {
        System.out.println(new String(new char[102]).replace("\0", "-"));
        System.out.printf("| %-4s | %-15s | %-20s | %-15s | %-17s | %-15s |%n",
                "ID", "Прізвище", "Адреса", "Телефон", "Номер мед. картки", "Діагноз");
        System.out.println(new String(new char[102]).replace("\0", "-"));
    }

    public static void printTableFooter() {
        System.out.println(new String(new char[102]).replace("\0", "-"));
    }
}
