package spring.online.store.db;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.mysql.util.URLParser;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class MySqlDb extends AbstractR2dbcConfiguration {

	@Override
	public ConnectionFactory connectionFactory() {
		final String dbURL = "jdbc:mysql://localhost:3306/login?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		return new JasyncConnectionFactory(
				new MySQLConnectionFactory(URLParser.INSTANCE.parseOrDie(dbURL, StandardCharsets.UTF_8)));
	}

}
