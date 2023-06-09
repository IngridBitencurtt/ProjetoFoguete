package br.com.foguete.rpgproject.repository;

import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonagemRepository extends MongoRepository<PersonagemEntity,String> {
   Optional <PersonagemEntity> findByIdAndPlayer(String id, String playerId);
   Optional <PersonagemEntity> findByPlayerAndName(String playerId, String name);


}
