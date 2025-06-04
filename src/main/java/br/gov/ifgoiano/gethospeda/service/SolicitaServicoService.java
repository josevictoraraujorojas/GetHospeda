package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.ReservaController;
import br.gov.ifgoiano.gethospeda.controller.ServicoController;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTO;
import br.gov.ifgoiano.gethospeda.dto.SolicitaServicoDTOOutput;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.SolicitaServico;
import br.gov.ifgoiano.gethospeda.model.SolicitaServicoId;
import br.gov.ifgoiano.gethospeda.repository.SolicitaServicoRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SolicitaServicoService {

    @Autowired
    private SolicitaServicoRepository repository;

    public List<SolicitaServicoDTOOutput> findAll() {
        var solicitaServicos = repository.findAll();
        var servicosDto = DataMapper.parseListObjects(solicitaServicos, SolicitaServicoDTOOutput.class);
        servicosDto
                .stream()
                .forEach(p ->
                        p.add(linkTo(methodOn(ReservaController.class).findById(p.getReservaId())).withSelfRel()));
        servicosDto
                .stream()
                .forEach(p ->
                        p.add(linkTo(methodOn(ServicoController.class).buscarPorId(p.getServicoId())).withSelfRel()));

        return servicosDto;
    }

    public SolicitaServicoDTOOutput findById(Long reservaId, Long servicoId) {
        SolicitaServicoId id = new SolicitaServicoId(reservaId, servicoId);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitação de serviço não encontrada!"));

        SolicitaServicoDTOOutput vo = DataMapper.parseObject(entity, SolicitaServicoDTOOutput.class);
        vo.add(linkTo(methodOn(ReservaController.class).findById(entity.getReserva().getId())).withSelfRel());
        vo.add(linkTo(methodOn(ServicoController.class).buscarPorId(entity.getServico().getId())).withSelfRel());
        return vo;
    }

    public SolicitaServicoDTO save(SolicitaServicoDTO solicitacao) {
        var servicoEntity = DataMapper.parseObject(solicitacao, br.gov.ifgoiano.gethospeda.model.SolicitaServico.class);

        var servicoSaved = repository.save(servicoEntity);
        var vo = DataMapper.parseObject(servicoSaved, SolicitaServicoDTO.class);

        vo.add(linkTo(methodOn(ReservaController.class).findById(servicoSaved.getReserva().getId())).withSelfRel());
        vo.add(linkTo(methodOn(ServicoController.class).buscarPorId(servicoSaved.getServico().getId())).withSelfRel());
        return vo;
    }

    public SolicitaServicoDTO update(SolicitaServicoDTO dto) {
        SolicitaServicoId id = new SolicitaServicoId(dto.getReservaId(), dto.getServicoId());

        SolicitaServico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitação de serviço não encontrada!"));

        entity.setDataSolicitacao(dto.getDataSolicitacao());

        var vo = DataMapper.parseObject(entity, SolicitaServicoDTO.class);
        vo.add(linkTo(methodOn(ReservaController.class).findById(entity.getReserva().getId())).withSelfRel());
        vo.add(linkTo(methodOn(ServicoController.class).buscarPorId(entity.getServico().getId())).withSelfRel());

        return vo;
    }

    public void delete(SolicitaServicoDTO solicitacao) {
        SolicitaServicoId id = new SolicitaServicoId(solicitacao.getReservaId(), solicitacao.getServicoId());

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitação de serviço não encontrada!"));

        repository.delete(entity);
    }
}