package design_principle;

public class JavaBean {
    public static void main(String[] args) {
        Students st=new Students();
        st.setFirstname("Aram");
        st.setLastname("Sargsyan");
        st.setId(4);
        System.out.println(st.getFirstname());
        System.out.println(st.getLastname());
        System.out.println(st.getId());
    }
}
class Students
{
    private  int id;
    private  String lastname;
    private String firstname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}