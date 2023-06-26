package com.nasigolang.ddbnb.pet.petmom.entity;

import com.nasigolang.ddbnb.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "PetMom")
@Table(name = "petMom")
@SequenceGenerator(name = "petMom_sequence_generator", sequenceName = "sequence_petMom_id", initialValue = 1, allocationSize = 50)
public class PetMom {

    @Id
    @Column(name = "BOARD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petMom_sequence_generator")
    private long boardId;


    @Column(name = "HOURLY_RATE")
    private int hourlyRate; // 시간 당 요금`

    @Column(name = "DATE_RATE")
    private int dateRate;  // 1일 요금

    @Column(name = "HOUSE_TYPE")
    private String houseType; // 주거형태

    @Column(name = "PET_YN")
    private String petYN; // 펫 유무


    @Column(name = "BOARD_TITLE")
    private String boardTitle;

    @Column(name = "BOARD_CATEGORY")
    private String boardCategory;

    @Column(name = "BOARD_DATE")
    private Date boardDate;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "CARE")
    private String care;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "SIGNFICANT")
    private String signficant; // 특이사항

    @Column(name = "REQUEST")
    private String request; // 요청사항

    @Column(name = "MOM_STATUS", columnDefinition = "VARCHAR(255) DEFAULT '모집중'")
    private String momStatus;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    private Member member;

    @ManyToMany
    @JoinTable(name = "OTHER", joinColumns = @JoinColumn(name = "BOARD_ID"), inverseJoinColumns = @JoinColumn(name = "TYPE_ID"))
    private List<OtherType> otherCondition = new ArrayList<>();


}