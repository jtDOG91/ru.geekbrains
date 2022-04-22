package lesson4;

public class main {

    public static void main(String[] args) {
        Person one = new Person("Petr", "director", "n@j", "3423768", 1780, 52);
        Person two = new Person("Dmitry", "IT", "oshurokdg@gmail.com", "+79650380910", 5750, 31);
        Person three = new Person("Olga", "accounted", "k@h", "348329", 850, 27);
        Person four = new Person("Irina", "secretary", "j@b", "4385398", 700, 45);
        Person five = new Person("Elena", "barista", "d@gh", "328479", 600, 22);
        Person[] employeesArray = new Person[5];
        employeesArray[0] = one;
        employeesArray[1] = two;
        employeesArray[2] = three;
        employeesArray[3] = four;
        employeesArray[4] = five;
        employeeSort(employeesArray);
    }

    public static void employeeSort(Person[] p) {
        for (int i = 0; i < 5; i++) {
            int w = p[i].getAge();
            if (w > 40){
                p[i].employeeInfo();
            }

        }
    }
}
