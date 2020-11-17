package ru.knisht.blackbox.security

import org.springframework.stereotype.Service

import java.security.SecureRandom
import java.util.concurrent.atomic.AtomicLong

@Service
@Newify(pattern = /[A-Z].*/)
class TokenService {
    private static final AtomicLong COUNTER = AtomicLong()

    private final SecureRandom random

    TokenService() {
        this.random = SecureRandom()
    }

    String createToken() {
        synchronized (random) {
            long r1 = random.nextLong()
            long r2 = random.nextLong()
            return Long.toString(r1, 36) + Long.toString(r2, 36) + COUNTER.get()
        }
    }
}
