import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.rythmengine.utils.S;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsontoString {
    public static void main(String[] args) {
        Address address = new Address("TienCat", "VietTri", "PhuTho");
        Person person = new Person(null, 30, "vqh@gmail.com", address);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String Jsperson = gson.toJson(person);
        System.out.println(Jsperson);

//        String Jison = "{\"name\":\"vu quoc hung\",\"age\":30,\"email\":\"vqh@gmail.com\",\"address\":{\"street\":\"TienCat\",\"city\":\"VietTri\",\"country\":\"PhuTho\"}}";
//        Person person1 = gson.fromJson(Jison, Person.class);
//        System.out.println(person1);
//        Address address1 = new Address("GiaCam", "VietTri", "PhuTho");
//        Person person1 = new Person("NG Van A", 30, "NVA@gmail.com", address1);
//        Address address2 = new Address("ThoSon", "VietTri", "PhuTho");
//        Person person2 = new Person("Dinh Thi B", 12, "BBB@gmail.com", address2);
//        ArrayList<Person> List = new ArrayList<>();
//        List.add(person);
//        List.add(person1);
//        List.add(person2);
//        String DanhSach = gson.toJson(List);
//        System.out.println(DanhSach);
//        String Json = "[{\"name\":\"vu quoc hung\",\"age\":30,\"email\":\"vqh@gmail.com\",\"address\":{\"street\":\"TienCat\",\"city\":\"VietTri\",\"country\":\"PhuTho\"}},{\"name\":\"NG Van A\",\"age\":30,\"email\":\"NVA@gmail.com\",\"address\":{\"street\":\"GiaCam\",\"city\":\"VietTri\",\"country\":\"PhuTho\"}},{\"name\":\"Dinh Thi B\",\"age\":12,\"email\":\"BBB@gmail.com\",\"address\":{\"street\":\"ThoSon\",\"city\":\"VietTri\",\"country\":\"PhuTho\"}}]\n";
//        Person[]conNguoi = new Person[3];
//        conNguoi = gson.fromJson(Json, Person[].class);
//        System.out.println(conNguoi);


    }

    public static class Person {
        public String name;
        public int age;
        private String email;
        public Address address;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Person(String name, int age, String email, Address address) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static class Address {
        public String street;
        public String city;
        public String country;

        public Address(String street, String city, String country) {
            this.street = street;
            this.city = city;
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }


}
