package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.model.Reserva;
import br.gov.ifgoiano.gethospeda.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    private Logger logger = Logger.getLogger(ReservaService.class.getName());

    public List<Reserva> findAll() {
        logger.info("Findall");
        return reservaRepository.findAll();
    }

    public Reserva findById(Long id) {
        logger.info("FindById");
        return reservaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public Reserva save(Reserva reserva) {
        logger.info("Save");
        return reservaRepository.save(reserva);
    }
    public Reserva update(Reserva reserva) {
        logger.info("Update");
        Reserva newReserva = reservaRepository.save(reserva);
        newReserva.setDataInicio(reserva.getDataInicio());
        newReserva.setDataFim(reserva.getDataFim());
        newReserva.setReserva(reserva.getReserva());
        newReserva.setValorTotal(reserva.getValorTotal());
        newReserva.setStatus(reserva.getStatus());

        return save(newReserva);
    }
    public void delete(Long id) {
        logger.info("Delete");
        reservaRepository.deleteById(id);
    }


}
