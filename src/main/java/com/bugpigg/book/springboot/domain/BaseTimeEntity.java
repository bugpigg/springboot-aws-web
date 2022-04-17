package com.bugpigg.book.springboot.domain;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass // JPA Entity 들이 BaseTimeEntity 를 상속할 경우 이 클래스의 필드들도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) // 이 클래스에 Auditing 기능을 포함시킵니다. // Entity 영속성 및 업데이트에 대한 Auditing 정보를 캡처하는 JPA Entity Listener
public abstract class BaseTimeEntity { // 모든 Entity 의 상위 클래스가 되어 Entity 들의 createdDate, modifiedDate 를 자동으로 관리해준다.

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
