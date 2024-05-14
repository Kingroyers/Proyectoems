
package Modelo;

public class Empleados { // *para nosotros poder tener acceso a atributos privados tendemos a utilizar getter and setter get
                           // se utiliza para obtener algo del objeto y set para ingresar informacion//
    private int id;     //atributos
    private int iden;
    private String name;
    private int phone;
    private String email;
    private String address;
    private String job;
    private String hire;
    private String start;
    private String end;

    public Empleados() {
    }
    // usamos conctrutores para inicializar nuestra variables y dar funcionalidad 
    // conctrutor se utilizar para establecer valores a los atributos 
    public Empleados(int id, int iden, String name, int phone, String email, String address, String job, String hire, String start, String end) {
        this.id = id;
        this.iden = iden;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.job = job;
        this.hire = hire;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    
    
       
    
}

    


