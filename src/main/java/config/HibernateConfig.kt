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
import java.util.*
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

    override fun hibernateProperties(): Properties {
        val hibernateProperties = Properties()
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop")
        hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false")
        hibernateProperties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor", "org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor")
        return hibernateProperties
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

    override fun hibernateProperties(): Properties {
        val hibernateProperties = Properties()
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop")
        hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false")
        hibernateProperties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor", "org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor")
        return hibernateProperties
    }
}

@Configuration
@EnableTransactionManagement
@Profile("test")
class H2TestProfileJPAConfig : DataSourceConfig() {

    /**
     * Test DB, sets up H2 in memory database
     */
    @Bean
    override fun dataSource(): DataSource {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "org.h2.Driver"
        dataSource.url = "jdbc:h2:mem:test;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false"
        dataSource.username = "sa"
        dataSource.password = ""
        return dataSource
    }

    override fun hibernateProperties(): Properties {
        val hibernateProperties = Properties()
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop")
        hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false")
        hibernateProperties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor", "org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor")
        return hibernateProperties
    }


}
