package com.grassparty.tft.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
// 해당 클래스의 인스턴스들이 JPA로 관리되는 엔티티 객체라는 것을 의미한다 / 해당 어노테이션이 붙은 클래스는 오셥에 따라 자동으로 테이블 생성이 가능하고 클래스의 멤버 변수에 따라 자동으로 컬럼들도 생성된다

@Table(name = "record")
// @Entity 어노테이션과 같이 사용할 수 있는 어노테이션 -> DB상에서 엔티티 클래스를 어떤 테이블로 생성할 것인지에 대한 정보를 담기위함

@Data
@Builder
@AllArgsConstructor // @Builder 를 이용하기 위해서 항상 같이 처리해야 컴파일 에러가 발생하지 않는다
@NoArgsConstructor // @Builder 를 이용하기 위해서 항상 같이 처리해야 컴파일 에러가 발생하지 않는다
public class RecordDAO {

    @Id
    @Column
    private String matchID;

    // 추가적인 필드(컬럼)이 팔요한 경우 사용 * DB 테이블에는 컬럼으로 생성되지 않는 필드의 경우 @Transient를 사용한다
    @Column(length = 100000)
    private String json;

}
