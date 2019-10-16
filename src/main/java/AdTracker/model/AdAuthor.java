/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdTracker.model;

import java.util.Objects;

/**
 *
 * @author mselv
 */
public class AdAuthor {
    private String name;
    private String location;
    private String phone;

    AdAuthor() {
    }

    AdAuthor(String name, String location, String phone) {
        this.name = name;
        this.location = location;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AdAuthor{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdAuthor adAuthor = (AdAuthor) o;
        return Objects.equals(name, adAuthor.name) &&
                Objects.equals(location, adAuthor.location) &&
                Objects.equals(phone, adAuthor.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, phone);
    }
}
