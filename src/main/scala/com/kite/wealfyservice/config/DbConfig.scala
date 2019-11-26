package com.kite.wealfyservice.config

import javax.sql.DataSource
import org.jooq.{ExecuteContext, SQLDialect}
import org.jooq.impl.{DataSourceConnectionProvider, DefaultConfiguration, DefaultDSLContext, DefaultExecuteListener, DefaultExecuteListenerProvider}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.jdbc.datasource.{DataSourceTransactionManager, TransactionAwareDataSourceProxy}
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
class DbConfig @Autowired() (
  //private val datasource: DataSource,
  //@Value private val sqlDialect: String
) {
  /*@Bean
  def connectionProvider: DataSourceConnectionProvider =
    new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(datasource))

  def configuration: DefaultConfiguration = {
    val config = new DefaultConfiguration()
    config.set(connectionProvider)
    config.set(new DefaultExecuteListenerProvider(ExceptionTranslator))
    config.set(SQLDialect.valueOf(sqlDialect))
    config
  }

  @Bean
  def transactionManager = new DataSourceTransactionManager(datasource)

  object ExceptionTranslator extends DefaultExecuteListener {
    override def exception(ctx: ExecuteContext): Unit = {
      val dialect = ctx.configuration.dialect
      val translator = new SQLErrorCodeSQLExceptionTranslator(dialect.name)
      ctx.exception(translator.translate("Jooq", ctx.sql, ctx.sqlException))
    }
  }

  @Bean
  def dsl = new DefaultDSLContext(configuration)*/
}
