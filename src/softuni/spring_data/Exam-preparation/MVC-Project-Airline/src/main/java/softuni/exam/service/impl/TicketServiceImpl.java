package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.TickerSeedRootDto;
import softuni.exam.models.entity.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final TicketRepository ticketRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PassengerService passengerService;
    private final PlaneService planeService;
    private final TownService townService;

    public TicketServiceImpl(TicketRepository ticketRepository, XmlParser xmlParser, ModelMapper modelMapper,
                             ValidationUtil validationUtil, PassengerService passengerService, PlaneService planeService,
                             TownService townService) {
        this.ticketRepository = ticketRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.passengerService = passengerService;
        this.planeService = planeService;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();
      xmlParser.fromFile(TICKETS_FILE_PATH, TickerSeedRootDto.class)
              .getTickets()
              .stream()
              .filter(ticketSeedDto -> {
                  boolean isValid = validationUtil.isValid(ticketSeedDto);

                  sb
                          .append(isValid? String.format("Successfully imported Ticket %s - %s",
                                  ticketSeedDto.getFromTown().getName(), ticketSeedDto.getToTown().getName())
                                  : "Invalid Ticket")
                          .append(System.lineSeparator());

                  return isValid;
              })
              .map(ticketSeedDto -> {
                  Ticket ticket = modelMapper.map(ticketSeedDto, Ticket.class);
                  ticket.setPassenger(passengerService.findPassengerByEmail(ticketSeedDto.getPassenger().getEmail()));
                  ticket.setPlane(planeService.findByRegisterNumber(ticketSeedDto.getPlane().getRegisterNumber()));
                  ticket.setFromTown(townService.findTownByName(ticketSeedDto.getFromTown().getName()));
                  ticket.setToTown(townService.findTownByName(ticketSeedDto.getToTown().getName()));

                  return ticket;
              })
              .forEach(ticketRepository::save);

        return sb.toString();
    }
}
