import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends Patient {

    private LocalDate date;
    private LocalTime stime;
    private LocalTime etime;
    private String notes;
    private String consulid;

    public Consultation(String name, String surname, LocalDate DOB, String mno,String newid,LocalTime stime,LocalTime etime,LocalDate date,String notes,String consulid){
            super(name,surname,DOB,mno,newid);
            this.date = date;
            this.stime = stime;
            this.etime = etime;
            this.notes = notes;
            this.consulid = consulid;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStime() {
        return stime;
    }

    public void setStime(LocalTime stime) {
        this.stime = stime;
    }

    public LocalTime getEtime() {
        return etime;
    }

    public void setEtime(LocalTime etime) {
        this.etime = etime;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getConsulid() {
        return consulid;
    }

    public void setConsulid(String consulid) {
        this.consulid = consulid;
    }

    public String toString(){
        return "01. Name                : " + this.getName() + '\n' +
               "02. Surname             : " + this.getSurname() + '\n' +
               "03. Date of Birth       : " + this.getDOB()+ '\n' +
               "04. Mobile Number       : " + this.getMno()+ '\n' +
               "05. Patient ID          : " + this.getId()+ '\n' +
               "06. Consultation date   : " + date + '\n' +
               "07. Start Time          : " + stime + '\n' +
               "08. End Time            : " + etime + '\n' +
               "09. Consul Doc          : " + consulid + '\n' +
               "10. Note                : " + notes + '\n';
    }

    public void setVisible(boolean b) {
    }
}