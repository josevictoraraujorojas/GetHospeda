package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public List<Imovel> findAll() {
        logger.info("findAll");
        return imovelRepository.findAll();
    }

    public Imovel findById(Long id) {
        logger.info("findById");
        return imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
    }

    public Imovel save(Imovel imovel) {
        logger.info("save");
        return imovelRepository.save(imovel);
    }

    public Imovel update(Imovel imovel) {
        logger.info("update");
        Imovel entity = imovelRepository.findById(imovel.getId()).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        entity.setTitulo(imovel.getTitulo());
        entity.setDescricao(imovel.getDescricao());
        entity.setEndereco(imovel.getEndereco());
        entity.setCidade(imovel.getCidade());
        entity.setEstado(imovel.getEstado());
        entity.setCep(imovel.getCep());
        entity.setPrecoDiaria(imovel.getPrecoDiaria());
        entity.setPoliticaDeCancelamento(imovel.getPoliticaDeCancelamento());
        entity.setStatus(imovel.getStatus());
        return imovelRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("delete");
        imovelRepository.deleteById(id);
    }


}
