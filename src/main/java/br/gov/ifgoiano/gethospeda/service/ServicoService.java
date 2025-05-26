package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.ServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.ServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.repository.ServicoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public List<ServicoDTOOutput> findAll() {
        var eventos = repository.findAll();
        return DataMapper.parseListObjects(eventos, ServicoDTOOutput.class);
    }

    public ServicoDTOOutput findById(Long id) {
        var servicoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        // Aqui garantimos que o objeto é Evento para o ModelMapper
        return DataMapper.parseObject(servicoEntity, ServicoDTOOutput.class);
    }

    public ServicoDTO save(ServicoDTO servicoDTO) {
        var servicoEntity = DataMapper.parseObject(servicoDTO, br.gov.ifgoiano.gethospeda.model.Servico.class);

        var servicoSaved = repository.save(servicoEntity);
        return DataMapper.parseObject(servicoSaved, ServicoDTO.class);
    }

    public ServicoDTO update(ServicoDTO servicoDTO) {
        var entity = repository.findById(servicoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        // Atualiza campos manualmente para evitar erros
        entity.setNome(servicoDTO.getNome());
        entity.setDescricao(servicoDTO.getDescricao());
        entity.setPreco(servicoDTO.getPreco());
        entity.setDisponibilidade(servicoDTO.isDisponibilidade());

        Imovel imovel = new Imovel();
        imovel.setId(servicoDTO.getImovel().getId());
        entity.setImovel(imovel);

        var updated = repository.save(entity);
        return DataMapper.parseObject(updated, ServicoDTO.class);
    }

    public void delete(Long id) {
        var servicoEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(servicoEntity);
    }
}