package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.PassengersSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final PassengerRepository passengerRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengersSeedDto[].class))
                .filter(passengersSeedDto -> {
                    boolean isValid = validationUtil.isValid(passengersSeedDto);

                    sb
                            .append(isValid ? String.format("Successfully imported Passenger %s - %s",
                                    passengersSeedDto.getLastName(), passengersSeedDto.getEmail())
                                    : "Invalid Passenger")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(passengersSeedDto -> modelMapper.map(passengersSeedDto, Passenger.class))
                .forEach(passengerRepository::save);

        return sb.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        List<Passenger> allPassengers = passengerRepository.findAll();
        allPassengers
                .stream()
                .sorted(Comparator.comparingInt((Passenger a) -> a.getTickets().size()).thenComparing(Passenger::getEmail))
                .forEach(passenger -> {
                    sb.append(String.format("Passenger %s  %s\n" +
                                    "\tEmail - %s\n" +
                                    "Phone - %s\n" +
                                    "\tNumber of tickets - %d\n",
                            passenger.getFirstName(), passenger.getLastName(), passenger.getEmail(),
                            passenger.getPhoneNumber(), passenger.getTickets().size()
                    ))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }

    @Override
    public Passenger findPassengerByEmail(String email) {
        return passengerRepository.findPassengerByEmail(email);
    }
}
