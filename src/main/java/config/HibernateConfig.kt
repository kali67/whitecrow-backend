package whitecrow.config

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.net.URI
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence-local.properties")
@Profile("local")
class PostgresHibernateConfig : DataSourceConfig() {

    @Autowired
    private lateinit var environment: Environment

    @Bean
    override fun dataSource (): DataSource {
        val dataSource =  BasicDataSource()
        dataSource.driverClassName = "org.postgresql.Driver"
        dataSource.url = environment["url"]
        dataSource.username = environment["username"]
        dataSource.password = environment["password"]
        return dataSource
    }
}

@Configuration
@EnableTransactionManagement
@Profile("heroku")
class PostgresHibernateHerokuConfig : DataSourceConfig() {

    @Bean
    override fun dataSource(): DataSource {
//        val dbUri = URI(System.getenv("spring.database.url"))
//
//        val username = dbUri.userInfo.split(":")[0]
//        val password = dbUri.userInfo.split(":")[1]
//        val dbUrl = "jdbc:postgresql://" + dbUri.host + ':' + dbUri.port + dbUri.path + "?sslmode=require"
//        println(dbUrl)
        val basicDataSource = BasicDataSource()
        basicDataSource.url = System.getenv("JDBC_DATABASE_URL")
        basicDataSource.driverClassName = "org.postgresql.Driver"
        basicDataSource.username = System.getenv("JDBC_DATABASE_USERNAME")
        basicDataSource.password = System.getenv("JDBC_DATABASE_PASSWORD")
        return basicDataSource
    }
}
