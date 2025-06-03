package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.ServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.ServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.model.SolicitaServicoId;
import br.gov.ifgoiano.gethospeda.repository.SolicitaServicoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitaServicoService {

    @Autowired
    private SolicitaServicoRepository repository;

    public SolicitaServicoService(SolicitaServicoRepository repository) {
        this.repository = repository;
    }

    public List<SolicitaServicoDTOOutput> findAll() {
        var eventos = repository.findAll();
        return DataMapper.parseListObjects(eventos, SolicitaServicoDTOOutput.class);
    }

    public SolicitaServicoDTO save(SolicitaServicoDTO solicitacao) {
        var servicoEntity = DataMapper.parseObject(solicitacao, br.gov.ifgoiano.gethospeda.model.SolicitaServico.class);

        var servicoSaved = repository.save(servicoEntity);
        return DataMapper.parseObject(servicoSaved, SolicitaServicoDTO.class);
    }

    public SolicitaServicoDTO update(SolicitaServicoDTO dto) {
        SolicitaServicoId id = new SolicitaServicoId(dto.getReservaId(), dto.getServicoId());

        SolicitaServico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitação de serviço não encontrada!"));

        entity.setDataSolicitacao(dto.getDataSolicitacao());

        SolicitaServicoDTO servicoEntity = DataMapper.parseObject(entity, SolicitaServicoDTO.class);

        return servicoEntity;
    }

    public void delete(SolicitaServicoDTO solicitacao) {
        SolicitaServicoId id = new SolicitaServicoId(solicitacao.getReservaId(), solicitacao.getServicoId());

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitação de serviço não encontrada!"));

        repository.delete(entity);
    }
}