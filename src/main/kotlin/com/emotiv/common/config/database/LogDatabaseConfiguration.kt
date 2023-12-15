package com.emotiv.common.config.database

import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

/**
 * @fileName LogDatabaseConfiguration
 * @author yunjeong
 * @since 2023/10/18
 * @version 1.0
 *
 * @Modification Information
 * @
 * @    DATE           AUTHOR          NOTE
 * @ -----------     ----------    -------------------
 * @ 2023/10/18     yunjeong       최초 작성
 */
@Configuration
@MapperScan(
    basePackages = ["com.emotiv.common.api.repository"],
    sqlSessionFactoryRef = "logSqlSessionFactory"
)
@EnableTransactionManagement
class LogDatabaseConfiguration {

    @Bean(name = ["logSqlDataSource"])
    @ConfigurationProperties(prefix = "spring.log.datasource.hikari")
    fun dataSource(): DataSource {
        val dataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()
        dataSource.connectionInitSql = "SET NAMES utf8mb4"
        return dataSource
    }

    @Bean(name = ["logSqlSessionFactory"])
    @Throws(Exception::class)
    fun sqlSessionFactory(@Qualifier("logSqlDataSource") dataSource: DataSource?): SqlSessionFactory? {
        val sessionFactory = SqlSessionFactoryBean()
        sessionFactory.setDataSource(dataSource)
        sessionFactory.setTypeAliasesPackage("com.emotiv.common.api.model")
        sessionFactory.setMapperLocations(*PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/actionLog/*.xml"))
        sessionFactory.vfs = SpringBootVFS::class.java
        return sessionFactory.`object`!!
    }

    @Bean(name = ["logSqlSessionFactory"])
    @Throws(Exception::class)
    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate? {
        return SqlSessionTemplate(sqlSessionFactory)
    }

}