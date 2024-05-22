package com.team2_project1.project1.service;

import com.team2_project1.project1.Mapper.EmailVerificationMapper;
import com.team2_project1.project1.Mapper.MemberMapper;
import com.team2_project1.project1.domain.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmailVerificationService {
    @Autowired
    private JavaMailSender mailSender; // JavaMailSender를 사용하여 이메일을 전송합니다.
    @Autowired
    private EmailVerificationMapper emailVerificationMapper;
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 이메일 인증 링크를 전송합니다.
     * @param email 사용자가 입력한 이메일 주소
     */
    public void sendVerificationEmail(String email) {
        // UUID를 사용하여 고유한 토큰을 생성합니다.
        String token = UUID.randomUUID().toString();
        // 현재 시간에 5분을 더하여 만료 시간을 설정합니다.
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(5);

        // EmailVerification 엔터티 객체를 생성하고 설정합니다.
        EmailVerification emailVerification = new EmailVerification();
        emailVerification.setEmail(email);
        emailVerification.setToken(token);
        emailVerification.setExpirationTime(expirationTime);

        emailVerificationMapper.insertEmailVerification(emailVerification);

        // 인증 링크를 생성합니다.
        String link = "http://localhost:8080/verify?token=" + token;
        // 이메일 메시지를 생성하고 설정합니다.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("블루아카이브 100주년 사전예약 이메일");
        message.setText("안내된 링크를 클릭해 인증을 완료해주세요: " + link);

        // 이메일을 전송합니다.
        mailSender.send(message);
    }

    /**
     * 토큰을 검증합니다.
     * @param token 이메일 인증 토큰
     * @return 토큰이 유효한 경우 true, 그렇지 않은 경우 false
     */
    public boolean verifyToken(String token) {
        EmailVerification emailVerification = emailVerificationMapper.findByToken(token);

        if (emailVerification != null && emailVerification.getExpirationTime().isAfter(LocalDateTime.now())) {
            saveEmail(emailVerification.getEmail());
            return true;
        }

        return false;
    }

    private void saveEmail(String email) {
        if (memberMapper.countByEmail(email) == 0) {
            memberMapper.insertEmail(email);
        } else {
            // 이메일 중복 시 처리 로직을 추가할 수 있습니다.
            System.out.println("이메일이 이미 존재합니다: " + email);
        }
    }

}
