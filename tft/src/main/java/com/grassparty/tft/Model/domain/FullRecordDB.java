package com.grassparty.tft.Model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static java.awt.SystemColor.text;

@Entity
// 해당 클래스의 인스턴스들이 JPA로 관리되는 엔티티 객체라는 것을 의미한다 / 해당 어노테이션이 붙은 클래스는 오셥에 따라 자동으로 테이블 생성이 가능하고 클래스의 멤버 변수에 따라 자동으로 컬럼들도 생성된다

@Table(name = "tbl_matchID")
// @Entity 어노테이션과 같이 사용할 수 있는 어노테이션 -> DB상에서 엔티티 클래스를 어떤 테이블로 생성할 것인지에 대한 정보를 담기위함

@Data

@Builder
@AllArgsConstructor // @Builder 를 이용하기 위해서 항상 같이 처리해야 컴파일 에러가 발생하지 않는다
@NoArgsConstructor // @Builder 를 이용하기 위해서 항상 같이 처리해야 컴파일 에러가 발생하지 않는다
public class FullRecordDB {
    @Id // @Entity 가 붙은 클래스는 PK에 해당하는 특정필드를 @Id로 지정해야 한다
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 해당 어노테이션은 사용자가 입력하는 값을 사용하는 경우가 아니면 자동으로 생성되는 번호를 사용하기 위해 사용한다
    private Long id;

    @Column
    private String matchID;

    // 추가적인 필드(컬럼)이 팔요한 경우 사용 * DB 테이블에는 컬럼으로 생성되지 않는 필드의 경우 @Transient를 사용한다
    @Column
    private String json;

}
