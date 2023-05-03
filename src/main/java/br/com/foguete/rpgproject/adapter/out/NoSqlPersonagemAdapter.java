package br.com.foguete.rpgproject.adapter.out;

import br.com.foguete.rpgproject.adapter.in.exception.NotFoundException;
import br.com.foguete.rpgproject.domain.Personagem;
import br.com.foguete.rpgproject.repository.PersonagemRepository;
import br.com.foguete.rpgproject.repository.entity.PersonagemEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NoSqlPersonagemAdapter implements  PersonagemAdapterOut {

    private  final PersonagemRepository personagemRepository;

    public NoSqlPersonagemAdapter(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
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

}
