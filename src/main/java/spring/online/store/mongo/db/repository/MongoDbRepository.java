package spring.online.store.mongo.db.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import spring.online.store.mongo.model.FileModel;

@Repository
public interface MongoDbRepository extends ReactiveCrudRepository<FileModel, Integer>{

}
