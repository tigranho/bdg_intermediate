package jaxb_example;

public class Customer {
    private String name;
    private String cstId;
    private  float overdue;
    private  int bucket;

    public Customer(String name){
        this.name=name;
    }
    public  Customer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCstId() {
        return cstId;
    }

    public void setCstId(String cstId) {
        this.cstId = cstId;
    }

    public float getOverdue() {
        return overdue;
    }

    public void setOverdue(float overdue) {
        this.overdue = overdue;
    }

    public int getBucket() {
        return bucket;
    }

    public void setBucket(int bucket) {
        this.bucket = bucket;
    }
}
