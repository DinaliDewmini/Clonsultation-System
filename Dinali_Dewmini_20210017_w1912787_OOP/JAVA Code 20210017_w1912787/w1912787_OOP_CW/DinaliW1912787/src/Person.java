import java.time.LocalDate;


public class Person{
    private String name;
    private String surname;
    private String Mno;
    private LocalDate DOB;




    public Person(String name, String surname, LocalDate DOB, String mno) {
        this.name = name;
        this.surname = surname;
        this.DOB = DOB;
        Mno = mno;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getMno() {
        return Mno;
    }

    public void setMno(String mno) {
        Mno = mno;
    }
}
