package singletonExample;

public class ManagerOfCompany {
    private String name;
    private ManagerOfCompany(){

    }

    private static volatile ManagerOfCompany manager;

    public static ManagerOfCompany getInstance(){
        if(manager == null){
            synchronized (ManagerOfCompany.class){
                if (manager == null){
                    manager = new ManagerOfCompany();
                }
            }
        }
        return manager;
    }
    public synchronized void addName(String name){
        this.name = name;
    }
    public synchronized String getName(){
        return name;
    }
}
