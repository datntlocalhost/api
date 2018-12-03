package jp.co.run;

public class People {

    private String name;
    private int age;
//    private List<String> address;
    
    public People(String name, int age
//        , List<String> address
        ) {
        super();
        this.name = name;
        this.age = age;
//        this.address = address;
    }
    public String getName(int n) {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(int n) {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
//    public List<String> getAddress() {
//        return address;
//    }
//    public void setAddress(List<String> address) {
//        this.address = address;
//    }
}
