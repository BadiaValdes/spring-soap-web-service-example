package com.spring.xml.webservice.soap.springbootsoap.models.xml.classroom;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD) // Definimos esta clase como campo del XML
// Definimos el nombre del tipo y el orden de los campos
@XmlType(name = "ClassRoomRequest", propOrder = {
        "number",
        "chairs",
        "tables",
})
@XmlRootElement(name = "ClassRoomRequest") // Decimos que el mismo es su clase padre
public class ClassRoomRequest {
    @XmlElement(name = "number", required = true) // definimos un elemento del campo y que es requerido
    private int number;

    @XmlElement(name = "chairs", required = true)
    private int chairs;

    @XmlElement(name = "tables", required = true)
    private int tables;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }
}
