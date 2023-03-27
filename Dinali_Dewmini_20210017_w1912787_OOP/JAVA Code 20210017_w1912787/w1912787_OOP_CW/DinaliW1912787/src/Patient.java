import java.time.LocalDate;

class Patient extends Person {

    private String id;

    public Patient(String name, String surname, LocalDate DOB, String mno,String newid) {
        super(name, surname, DOB, mno);
        this.id = newid;
    }




    public String getId() {return id;}

    public void setId(int id) {
        this.id = String.valueOf(id);}

}
