package test.task.java.dao.entity;



public class User {

    private Long id;
    private String surname;
    private String name;
    private Integer age;
    private Character sex;
    private String mobileNumber;

    public User() {
    }

    public User(Long id, String surname, String name, Integer age, Character sex, String mobileNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mobileNumber = mobileNumber;
    }

    public User(String surname, String name, Integer age, Character sex, String mobileNumber) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
