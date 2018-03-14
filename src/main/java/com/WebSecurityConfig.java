package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
/*import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
*/import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.GzipResourceResolver;

/*import jp.co.everline.elineHCM.login.SampleAuthenticationFailureHandler;
import jp.co.everline.elineHCM.login.UserDetailsServiceImpl;*/

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
/*@ConfigurationProperties(prefix="db.elinehcm")
*/public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static String password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/", "/css/**", "/js/**", "/i18n/**", "/images/**","/webjars/**","/test","/kaisya","/kaisya/getKaisya","/program","/program/**","/financialInst","/financialInst/**","/item","/item/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Required to use GET method for logout
        .permitAll()
        .and()
        .formLogin()
        .permitAll()
        .loginPage("/login").failureUrl("/login-error")
        .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());


      /*  // ���O�C���ݒ�
        http.formLogin()
            .loginProcessingUrl("/loginProcess")   // �F�؏����̃p�X
            .loginPage("/login")            // ���O�C���t�H�[���̃p�X
            .failureHandler(new SampleAuthenticationFailureHandler())       // �F�؎��s���ɌĂ΂��n���h���N���X
            .defaultSuccessUrl("/index")     // �F�ؐ������̑J�ڐ�
            .usernameParameter("login_id").passwordParameter("login_password")  // ���[�U�[���A�p�X���[�h�̃p�����[�^��
            .and();

        // ���O�A�E�g�ݒ�
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))       // ���O�A�E�g�����̃p�X
            .logoutSuccessUrl("/login");*/

    }

  /*  @Configuration
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
    *//**
     * �ÓI���\�[�X�ɑ΂����`�B
     *
     * @param registry {@link ResourceHandlerRegistry}
     *//*
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

         // webjars �̒�`
         registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
                     .resourceChain(false) // ������ WebJarsResourceResolver ���L���������B
                     .addResolver(new GzipResourceResolver()); // gz �t�@�C���ւ̃A�N�Z�X�L�����B
    }*/
}