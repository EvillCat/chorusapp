package com.evillcat.chorusapp.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String nameAndSurname;

    @Column(name = "number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "members")
    private List<Position> positions;

    @ManyToMany
    @JoinTable(name = "member_group",
        joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private List<Group> groups;

    @ManyToMany
    @JoinTable(name = "member_status",
        joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "status_id", referencedColumnName = "id"))
    private List<Status> statuses;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equals(nameAndSurname, member.nameAndSurname) &&
            Objects.equals(phoneNumber, member.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAndSurname, phoneNumber);
    }
}
