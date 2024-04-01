package backend.likelion.todos;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtGenerator {
    public static void main(String[] args) {

        // 비밀키 생성, HS256 알고리즘 사용
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // 현재 시간 및 만료 시간 설정
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 1시간 후 만료
        Date exp = new Date(nowMillis + 3600000);

        // JWT 생성
        String jwt = Jwts.builder()
                .setSubject("likelion_sinseonghui") // 사용자별로 구체적인 식별값이 들어감
                .setIssuedAt(now) // 발행 시간 설정
                .setExpiration(exp) // 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, key) // 서명
                .compact(); // JWT 생성dddd

        System.out.println("Generated JWT: " + jwt);
    }
}