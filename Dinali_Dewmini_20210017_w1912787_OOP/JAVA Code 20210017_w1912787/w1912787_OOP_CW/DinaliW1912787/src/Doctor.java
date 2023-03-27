import java.time.LocalDate;

class Doctor extends Person {

    private String licensenumber;
    private String spec;

    public Doctor(String name, String surname, LocalDate DOB, String mno, String licensenum, String spec) {
        super(name, surname, DOB, mno);
        this.spec = spec;
        this.licensenumber = licensenum;

    }

    public String toString(){
        return "01. Name            : " + this.getName() + '\n' +
               "02. Surname         : " + this.getSurname() + '\n' +
               "03. Date of Birth   : " + this.getDOB()+ '\n' +
               "04. Mobile No.      : " + this.getMno()+ '\n' +
               "05. License No.     : " + this.licensenumber+ '\n' +
               "06. Specilisation   : " + this.spec+ '\n';
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;

    }
}
