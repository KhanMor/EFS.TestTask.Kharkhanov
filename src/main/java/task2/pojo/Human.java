package task2.pojo;

import task2.jaxb.XmlDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by Mordr on 12.04.2017.
 */
@XmlRootElement
@XmlType(propOrder = {"number", "firstName", "surname", "patronymic", "birthDay", "height", "weight", "sex"})
public class Human {
    private int number;
    private String firstName;
    private String surname;
    private String patronymic;
    private Date birthDay;
    private double height;
    private double weight;
    private String sex;

    public int getNumber() {
        return number;
    }

    @XmlElement
    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @XmlElement
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    @XmlElement
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public double getHeight() {
        return height;
    }

    @XmlElement
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    @XmlElement
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    @XmlElement
    public void setSex(String sex) {
        this.sex = sex;
    }
}
