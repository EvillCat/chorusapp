package com.evillcat.chorusapp.model;

import java.util.List;
import javax.persistence.Entity;
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
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String position;

    @ManyToMany
    @JoinTable(name = "position_member",
        joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "id"))
    private List<Member> members;

}
