package com.example.demo.src.file.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Objects;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "Workers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Workers {

    @EmbeddedId
    private WorkerId id;


    @Column(name = "user_id",  insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id",  insertable = false, updatable = false)
    private Works works;

    @Column(name = "write_yn")
    private boolean writeYn;


    @Column(name = "team_id")
    private Long teamId;

    public boolean getWriteYn() {
        return this.writeYn;
    }
    // 다른 메서드, getter, setter 등을 추가할 수 있습니다.
    @Embeddable
    public static class WorkerId implements Serializable {
        @Column(name = "work_id")
        private Long workId;

        @Column(name = "user_id")
        private Long userId;
        // equals() 메서드 구현
        public Long getWorkId() {
            return workId;
        }
        public Long getUserId() {
            return userId;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof WorkerId)) return false;
            WorkerId that = (WorkerId) o;
            return Objects.equals(getWorkId(), that.getWorkId()) &&
                    Objects.equals(getUserId(), that.getUserId());
        }

        // hashCode() 메서드 구현
        @Override
        public int hashCode() {
            return Objects.hash(getWorkId(), getUserId());
        }
    }
}