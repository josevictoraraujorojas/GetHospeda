package br.gov.ifgoiano.gethospeda.testes;

import br.gov.ifgoiano.gethospeda.dto.EventoDTO;
import br.gov.ifgoiano.gethospeda.dto.ImovelResumoDTO;
import br.gov.ifgoiano.gethospeda.dto.ServicoDTO;
import br.gov.ifgoiano.gethospeda.model.Evento;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.model.Servico;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataMapperTest {

    @Test
    void testEntityToDTOConversion() {
        Imovel imovel = new Imovel();
        imovel.setId(1L);

        Evento evento = new Evento();
        evento.setId(100L);
        evento.setNome("Festa Junina");
        evento.setLocal("Praça Central");
        evento.setDescricao("Evento cultural");
        evento.setDataInicio(new Date());
        evento.setDataFim(new Date(System.currentTimeMillis() + 86400000)); // +1 dia
        evento.setCapacidade(200);
        evento.setImovel(imovel);

        EventoDTO dto = DataMapper.parseObject(evento, EventoDTO.class);

        assertNotNull(dto);
        assertEquals(evento.getId(), dto.getId());
        assertEquals(evento.getNome(), dto.getNome());
        assertEquals(evento.getLocal(), dto.getLocal());
        assertEquals(evento.getDescricao(), dto.getDescricao());
        assertEquals(evento.getDataInicio(), dto.getDataInicio());
        assertEquals(evento.getDataFim(), dto.getDataFim());
        assertEquals(evento.getCapacidade(), dto.getCapacidade());

        assertNotNull(dto.getImovel(), "O imóvel não foi mapeado automaticamente (verifique configuração do ModelMapper)");
    }

    @Test
    void testDTOToEntityConversion() {
        ImovelResumoDTO imovelResumoDTO = new ImovelResumoDTO();
        imovelResumoDTO.setId(2L);

        EventoDTO dto = new EventoDTO();
        dto.setId(200L);
        dto.setNome("Feira de Ciências");
        dto.setLocal("IF Goiano");
        dto.setDescricao("Apresentação de projetos");
        dto.setDataInicio(new Date());
        dto.setDataFim(new Date(System.currentTimeMillis() + 172800000)); // +2 dias
        dto.setCapacidade(150);
        dto.setImovel(imovelResumoDTO);

        Evento evento = DataMapper.parseObject(dto, Evento.class);

        assertNotNull(evento);
        assertEquals(dto.getId(), evento.getId());
        assertEquals(dto.getNome(), evento.getNome());
        assertEquals(dto.getLocal(), evento.getLocal());
        assertEquals(dto.getDescricao(), evento.getDescricao());
        assertEquals(dto.getDataInicio(), evento.getDataInicio());
        assertEquals(dto.getDataFim(), evento.getDataFim());
        assertEquals(dto.getCapacidade(), evento.getCapacidade());

        assertNotNull(evento.getImovel(), "O imóvel não foi mapeado automaticamente (verifique configuração do ModelMapper)");
    }

    @Test
    public void testServicoToServicoDTOConversion() {
        // Dado um Servico
        Servico servico = new Servico();
        servico.setId(1L);
        servico.setNome("Limpeza diária");
        servico.setDescricao("Serviço de limpeza realizado diariamente.");
        servico.setPreco(150.0);
        servico.setDisponibilidade(true);

        Imovel imovel = new Imovel();
        imovel.setId(10L);
        servico.setImovel(imovel);

        ServicoDTO dto = DataMapper.parseObject(servico, ServicoDTO.class);

        assertEquals(servico.getId(), dto.getId());
        assertEquals(servico.getNome(), dto.getNome());
        assertEquals(servico.getDescricao(), dto.getDescricao());
        assertEquals(servico.getPreco(), dto.getPreco());
        assertEquals(servico.isDisponibilidade(), dto.isDisponibilidade());
        assertNotNull(dto.getImovel());
        assertEquals(servico.getImovel().getId(), dto.getImovel().getId());
    }

    @Test
    public void testServicoDTOToServicoConversion() {

        ServicoDTO dto = new ServicoDTO();
        dto.setId(2L);
        dto.setNome("Transporte");
        dto.setDescricao("Translado do aeroporto");
        dto.setPreco(300.0);
        dto.setDisponibilidade(false);

        ImovelResumoDTO imovelDTO = new ImovelResumoDTO();
        imovelDTO.setId(20L);
        dto.setImovel(imovelDTO);

        Servico servico = DataMapper.parseObject(dto, Servico.class);

        assertEquals(dto.getId(), servico.getId());
        assertEquals(dto.getNome(), servico.getNome());
        assertEquals(dto.getDescricao(), servico.getDescricao());
        assertEquals(dto.getPreco(), servico.getPreco());
        assertEquals(dto.isDisponibilidade(), servico.isDisponibilidade());
        assertNotNull(servico.getImovel());
        assertEquals(dto.getImovel().getId(), servico.getImovel().getId());
    }
}