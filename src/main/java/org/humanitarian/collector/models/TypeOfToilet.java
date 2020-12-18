package org.humanitarian.collector.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sub_types_of_toilet", indexes = {
        @Index(columnList = "type")
})
public class TypeOfToilet {
    public static final String TYPE_WATER_SEALED = "water_sealed";
    public static final String TYPE_OPEN_PIT = "open_pit";
    public static final String TYPE_COMMUNAL = "communal";
    public static final String TYPE_NO_TOILET = "no_toilet";

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "form_data_id")
    @JsonIgnore
    private FormData formData;

    private String type;

    public TypeOfToilet() {

    }

    public TypeOfToilet(FormData formData, String type) {
        setFormData(formData);
        setType(type);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
