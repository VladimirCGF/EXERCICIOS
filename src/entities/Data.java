package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Data {
    private LocalDate date;
    private final LocalDate dateNow = LocalDate.now();

    public Data() {


    }

    public Data(LocalDate date) {
        this.date = date;
    }

    public Data clone() {
        Data cloneDate;
        return cloneDate = new Data(date);
    }

    public static void play() {
        Data date = new Data(LocalDate.of(1997, 3, 26));


        if (date.compare() == 0) {
            System.out.println(date.compare() + " Datas iguais");
        } else if (date.compare() == 1) {
            System.out.println(date.compare() + " Data corrente maior");
        } else
            System.out.println(date.compare() + "Data do parâmetro maior");
        System.out.println("Dia -> " + date.getDia());
        System.out.println("Mes -> " + date.getMes());
        System.out.println("Ano -> " + date.getAno());
        System.out.println("Data corrente extenso -> " + date.getMesExtenso());
        System.out.println("Se ano é bissexto -> " + date.isBissexto());
    }

    public int compare() {
        if (dateNow.compareTo(date) == 0) {
            return 0;
        } else if (dateNow.compareTo(date) > 0) {
            return 1;
        } else
            return -1;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public int getDia() {
        return date.getDayOfMonth();
    }

    public int getMes() {
        return date.getMonthValue();
    }

    public int getAno() {
        return date.getYear();
    }

    public int getAnoNow() {
        return dateNow.getYear();
    }

    public boolean isBissexto() {
        return getAnoNow() % 4 == 0;
    }

    public String getMesExtenso() {
        return dateNow.format(DateTimeFormatter.ofPattern("MMMM", new Locale("pt", "BR")));
    }


}
