package tokyo.boblennon.mwc22back.domain.developer;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public @Getter @Setter @NoArgsConstructor class Developer {

    @Id
    private String id;
    private String name;
    private String email;
    private DevCategoryEnum category;
    private String phone;
    private String date;

    public Developer(String id, String name, String email, DevCategoryEnum category, String phone, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
        this.phone = phone;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attendance day: " + date + "for the developer '" + name + "' on the category " + category
                + ". Contact info: email " + email + ", phone " + phone;
    }

}
