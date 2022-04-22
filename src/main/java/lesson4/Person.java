package lesson4;

public class Person {
    private String name;
    private String post;
    private String email;
    private String cellNumber;
    private int salary;
    private int age;

    public Person(String name, String post, String email, String cellNumber, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.cellNumber = cellNumber;
        this.salary = salary;
        this.age = age;
    }

    public void employeeInfo() {
        System.out.println("Employee name is " + name + ", post: " + post + ", email: " + email + ", cell number: " + cellNumber + ", salary: " + salary + ", age: " + age + ".");
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName() {
        this.name = name;
    }

    public void setPost() {
        this.post = post;
    }

    public void setEmail() {
        this.email = email;
    }

    public void setCellNumber() {
        this.cellNumber = cellNumber;
    }

    public void setSalary() {
        this.salary = salary;
    }

    public void setAge() {
        this.age = age;
    }
}
