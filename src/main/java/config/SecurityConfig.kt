package whitecrow.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.WebSecurity
import whitecrow.service.interfaces.IUserSharedService

@Configuration
@EnableConfigurationProperties
class SecurityConfig @Autowired constructor(var userServiceImpl: IUserSharedService) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .authorizeRequests().anyRequest().authenticated()
            .and().httpBasic()
            .and().sessionManagement().disable()
    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/user/save")
        web.ignoring().antMatchers("/board")
        web.ignoring().antMatchers("/card")
        web.ignoring().antMatchers("/game/players")
        web.ignoring().antMatchers("/game/details/{id}")
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**") // allow preflight request
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    public override fun configure(builder: AuthenticationManagerBuilder?) {
        builder!!.userDetailsService<IUserSharedService>(userServiceImpl)
    }
}