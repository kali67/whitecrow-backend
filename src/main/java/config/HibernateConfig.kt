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
class PostgresHibernateConfigLocal : DataSourceConfig() {

    @Autowired
    private lateinit var environment: Environment

    @Bean
    override fun dataSource(): DataSource {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "org.postgresql.Driver"
        dataSource.url = environment["url"]
        dataSource.username = environment["username"]
        dataSource.password = environment["password"]
        return dataSource
    }
}

@Configuration
@EnableTransactionManagement
@Profile("production")
class PostgresHibernateConfigProd : DataSourceConfig() {

    /**
     * Production datasource, works with postgres ENV format from heroku
     */
    @Bean
    override fun dataSource(): DataSource {
        val dbUri = URI(System.getenv("DATABASE_URL"))
        val username = dbUri.userInfo.split(":")[0]
        val password = dbUri.userInfo.split(":")[1]
        val dbUrl =
            "jdbc:postgresql://" + dbUri.host + ':' + dbUri.port + dbUri.path + "?sslmode=require" // for remote connections
        val config = BasicDataSource()
        config.url = dbUrl
        config.username = username
        config.password = password
        config.driverClassName = "org.postgresql.Driver"
        return config
    }
}
