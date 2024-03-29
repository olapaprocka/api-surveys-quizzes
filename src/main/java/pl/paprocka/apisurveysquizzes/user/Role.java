package pl.paprocka.apisurveysquizzes.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(unique = true)
    private String roleName;

    @Override
    public String toString() {
        return roleName;
    }

    public Role(String roleName) {

        this.roleName = roleName;
    }

}
