package guru.springframework.sfgpc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners") // this is default behaviour
public class Owner extends Person {

    @Builder
    public Owner(final Long id, final String firstName, final String lastName, final String address,
                 final String city, final String telephone, final Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    private String address;
    private String city;
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Owner)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Owner owner = (Owner) o;

        if (getAddress() != null ? !getAddress().equals(owner.getAddress()) : owner.getAddress() != null) {
            return false;
        }
        if (getCity() != null ? !getCity().equals(owner.getCity()) : owner.getCity() != null) {
            return false;
        }
        if (getTelephone() != null ? !getTelephone().equals(owner.getTelephone()) : owner.getTelephone() != null) {
            return false;
        }
        return getPets() != null ? getPets().equals(owner.getPets()) : owner.getPets() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getTelephone() != null ? getTelephone().hashCode() : 0);
        result = 31 * result + (getPets() != null ? getPets().hashCode() : 0);
        return result;
    }
}
