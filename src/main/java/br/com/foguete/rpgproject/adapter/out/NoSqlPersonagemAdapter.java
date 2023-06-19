package br.com.foguete.rpgproject.adapter.out;

import br.com.foguete.rpgproject.adapter.in.exception.NotFoundException;
import br.com.foguete.rpgproject.domain.Dado;
import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.PersonagemRepository;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class NoSqlPersonagemAdapter implements  PersonagemAdapterOut {

    private  final PersonagemRepository personagemRepository;
    private final MongoTemplate mongoTemplate;







    public NoSqlPersonagemAdapter(PersonagemRepository personagemRepository, MongoTemplate mongoTemplate) {
        this.personagemRepository = personagemRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public String criaPersonagem(Personagem personagem) {
        PersonagemEntity personagemEntity = PersonagemEntity.personagemEntity(personagem);
        personagemEntity.setCreatedAt(Instant.now());
        PersonagemEntity personagemSave = this.personagemRepository.save(personagemEntity);
        return personagemSave.getId();
    }

    @Override
    public Personagem findPersonagemPorIdEPlayerId(String id, String playerId) {
        Optional<PersonagemEntity> personagemEntityOptional = this.personagemRepository.findByIdAndPlayer(id, playerId);

        if (personagemEntityOptional.isEmpty()){
            throw new NotFoundException();
        }

        PersonagemEntity personagemEntity = personagemEntityOptional.get();
        return Personagem.from(personagemEntity);
    }

    public Optional<PersonagemEntity> findByPersonagemPorPlayerIdENome(String playerId, String nome){
        return this.personagemRepository.findByPlayerAndName(playerId, nome);
    }

    @Override
    public void atualizaPersonagemPorId(String id, Personagem personagem) {
        PersonagemEntity personagemEntity = this.personagemRepository.findByIdAndPlayer(id, personagem.getIdJogador())
                .orElseThrow(NotFoundException::new);

        PersonagemEntity personagemAtualizado = PersonagemEntity.atualizaPersonagem(personagemEntity, personagem);
        this.personagemRepository.save(personagemAtualizado);

    }
    @Override
    public void deletePersonagem(String id, String playerId) {
        PersonagemEntity personagem = this.personagemRepository.findByIdAndPlayer(id, playerId)
                .orElseThrow(NotFoundException::new);

        this.personagemRepository.delete(personagem);


    }

    @Override
    public List<PersonagemEntity> findPersonagens(Integer strength, Integer dexterity, Integer constitution,
                                                  Integer intelligence, Integer wisdom, Integer charisma, String playerId) {
        Query query = this.buildQuery(strength,dexterity,
                constitution,intelligence,wisdom,charisma,playerId);
        return mongoTemplate.find(query, PersonagemEntity.class);
    }

    private Query buildQuery(Integer strength, Integer dexterity, Integer constitution, Integer intelligence,
                             Integer wisdom, Integer charisma, String playerId) {
        Query query = new Query();

        query.addCriteria(Criteria.where("player").is(playerId));

        if (!ObjectUtils.isEmpty(strength)){
            query.addCriteria(Criteria.where("strength").is(strength));
        }
        if (!ObjectUtils.isEmpty(dexterity)){
            query.addCriteria(Criteria.where("dexterity").is(dexterity));
        }
        if (!ObjectUtils.isEmpty(constitution)){
            query.addCriteria(Criteria.where("constitution").is(constitution));
        }
        if (!ObjectUtils.isEmpty(intelligence)){
            query.addCriteria(Criteria.where("intelligence").is(intelligence));
        }
        if (!ObjectUtils.isEmpty(wisdom)){
            query.addCriteria(Criteria.where("wisdom").is(wisdom));
        }
        if (!ObjectUtils.isEmpty(charisma)){
            query.addCriteria(Criteria.where("charisma").is(charisma));
        }


        return  query;
    }


}
