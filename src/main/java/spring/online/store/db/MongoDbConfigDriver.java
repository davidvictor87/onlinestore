package spring.online.store.db;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


@Configuration
@EnableMongoRepositories
public class MongoDbConfigDriver extends AbstractReactiveMongoConfiguration{
	
	@Value("${}")
	private String connectionString;
	
	@Override
	@Bean
	public MongoClient reactiveMongoClient() {
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		MongoClientURI uri = new MongoClientURI(connectionString);
		return MongoClients.create(MongoClientSettings.builder().applyConnectionString(new ConnectionString(uri.getURI()))
				.codecRegistry(codecRegistry).build());
	}
	
	@Override
	protected String getDatabaseName() {
		return reactiveMongoClient().getDatabase("chapters").getName();
	}

}
