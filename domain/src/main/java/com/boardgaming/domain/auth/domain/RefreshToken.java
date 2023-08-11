package com.boardgaming.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.util.concurrent.TimeUnit;

@Getter
@RedisHash("refreshToken")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshToken {
    @Id
    private String userId;

    @Indexed
    private String value;

    @TimeToLive(unit = TimeUnit.MILLISECONDS)
    private Long timeout;

    public RefreshToken(
        final String userId,
        final String value,
        final Long timeout
    ) {
        this.userId = userId;
        this.value = value;
        this.timeout = timeout;
    }
}
