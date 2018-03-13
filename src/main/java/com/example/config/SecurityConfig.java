package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 * Spring Security�ݒ�N���X.
 */
@Configuration
@EnableWebSecurity   // Spring Security�̊�{�ݒ�
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // �Z�L�����e�B�ݒ�𖳎����郊�N�G�X�g�ݒ�
        // �ÓI���\�[�X(images�Acss�Ajavascript)�ɑ΂���A�N�Z�X�̓Z�L�����e�B�ݒ�𖳎�����
        web.ignoring().antMatchers(
                            "/images/**",
                            "/css/**",
                            "/javascript/**",
                            "/webjars/**",
                            "/item/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // �F�̐ݒ�
        http.authorizeRequests()
            .antMatchers("/", "/index").permitAll() // index�͑S���[�U�[�A�N�Z�X����
            .anyRequest().authenticated();  // ����ȊO�͑S�ĔF�ؖ����̏ꍇ�A�N�Z�X�s����
/*
        // ���O�C���ݒ�
        http.formLogin()
            .loginProcessingUrl("/login")   // �F�؏����̃p�X
            .loginPage("/index")            // ���O�C���t�H�[���̃p�X
            .failureHandler(new hoge())       // �F�؎��s���ɌĂ΂��n���h���N���X
            .defaultSuccessUrl("/menu")     // �F�ؐ������̑J�ڐ�
            .usernameParameter("login_id").passwordParameter("login_password")  // ���[�U�[���A�p�X���[�h�̃p�����[�^��
            .and();
*/
        
        /*
        // ���O�A�E�g�ݒ�
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))       // ���O�A�E�g�����̃p�X
            .logoutSuccessUrl("/index");                                        // ���O�A�E�g�������̃p�X
*/
    }

    /* �Q�l
    @Configuration
    protected static class AuthenticationConfiguration
    extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        UserDetailsServiceImpl userDetailsService;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            // �F�؂��郆�[�U�[��ݒ肷��
            auth.userDetailsService(userDetailsService)
            // ���͒l��bcrypt�Ńn�b�V���������l�Ńp�X���[�h�F�؂��s��
            .passwordEncoder(new BCryptPasswordEncoder());

        }
    }
    */
}