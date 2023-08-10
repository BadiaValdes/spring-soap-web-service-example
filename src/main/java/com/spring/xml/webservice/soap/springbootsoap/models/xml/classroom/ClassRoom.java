package com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.*;
import lombok.experimental.Accessors;

/**
 * Code First Approach
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD) // Definimos que es un campo del xml
// Definimos el tipo y todos los atributos
@XmlType(name = "ClassRoom", propOrder = {
        "id",
        "number",
        "chairs",
        "tables"
})
@XmlRootElement(name = "ClassRoom") // Este valor me permite definirlo como elemento principal. Si fuera un objeto anidado, seria su padre
public class ClassRoom {
    @Id
    @Column
    @XmlElement(name = "id") // Decimos que es un elemento del recurso complejo
    private String id;

    @Column
    @XmlElement(name = "number")
    private int number;

    @Column
    @XmlElement(name = "chairs")
    private int chairs;

    @Column
    @XmlElement(name = "tables")
    private int tables;

    public ClassRoom(String id, int number, int chairs, int tables) {
        this.id = id;
        this.number = number;
        this.chairs = chairs;
        this.tables = tables;
    }

    public ClassRoom() {
    }

    public String getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public int getChairs() {
        return this.chairs;
    }

    public int getTables() {
        return this.tables;
    }

    public ClassRoom setId(String id) {
        this.id = id;
        return this;
    }

    public ClassRoom setNumber(int number) {
        this.number = number;
        return this;
    }

    public ClassRoom setChairs(int chairs) {
        this.chairs = chairs;
        return this;
    }

    public ClassRoom setTables(int tables) {
        this.tables = tables;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ClassRoom)) return false;
        final ClassRoom other = (ClassRoom) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        if (this.getNumber() != other.getNumber()) return false;
        if (this.getChairs() != other.getChairs()) return false;
        if (this.getTables() != other.getTables()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ClassRoom;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        result = result * PRIME + this.getNumber();
        result = result * PRIME + this.getChairs();
        result = result * PRIME + this.getTables();
        return result;
    }

    public String toString() {
        return "ClassRoom(id=" + this.getId() + ", number=" + this.getNumber() + ", chairs=" + this.getChairs() + ", tables=" + this.getTables() + ")";
    }
}
