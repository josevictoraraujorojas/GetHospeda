package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.AvaliacaoImovel;
import br.gov.ifgoiano.gethospeda.repository.AvaliacaoImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AvaliacaoImovelService {
    @Autowired
    private AvaliacaoImovelRepository avaliacaoImovelRepository;
    private Logger logger = Logger.getLogger(AvaliacaoImovelService.class.getName());

    public List<AvaliacaoImovel> findAll(){
        logger.info("findAll");
        return avaliacaoImovelRepository.findAll();
    }

    public AvaliacaoImovel findById(Long id){
        logger.info("findById");
        return avaliacaoImovelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for thi id"));
    }


    public AvaliacaoImovel save(AvaliacaoImovel avaliacaoImovel){
        logger.info("save");
        return avaliacaoImovelRepository.save(avaliacaoImovel);
    }

    public AvaliacaoImovel update(AvaliacaoImovel avaliacaoImovel){
        logger.info("update");
        AvaliacaoImovel newAvaliacaoImovel = avaliacaoImovelRepository.findById(avaliacaoImovel.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for thi id"));
        newAvaliacaoImovel.setNota(avaliacaoImovel.getNota());
        newAvaliacaoImovel.setComentario(avaliacaoImovel.getComentario());
        newAvaliacaoImovel.setDataAvaliacao(avaliacaoImovel.getDataAvaliacao());
        return avaliacaoImovelRepository.save(newAvaliacaoImovel);
    }

    public void delete(Long id){
        logger.info("delete");
        avaliacaoImovelRepository.deleteById(id);
    }
}
