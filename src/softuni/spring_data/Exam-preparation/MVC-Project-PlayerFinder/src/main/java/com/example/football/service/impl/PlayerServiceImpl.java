package com.example.football.service.impl;

import com.example.football.models.dto.xml.PlayerRootSeedDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final StatService statService;
    private final TownService townService;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, XmlParser xmlParser,
                             ValidationUtil validationUtil, StatService statService, TownService townService,
                             TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.statService = statService;
        this.townService = townService;
        this.teamService = teamService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerRootSeedDto.class)
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && !ExistingPlayerWithEmail(playerSeedDto.getEmail());
                    sb
                            .append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition())
                                    : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);
                    player.setStat(statService.findByStatId(playerSeedDto.getStat().getId()));
                    player.setTeam(teamService.findTeamByName(playerSeedDto.getTeam().getName()));
                    player.setTown(townService.findTownByName(playerSeedDto.getTown().getName()));

                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();

    }

    private boolean ExistingPlayerWithEmail(String email) {
        if (playerRepository.findByEmail(email) == null) {
            return false;
        }
        return true;
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        List<Player> allPlayersBetweenDates = playerRepository
                .findAllByBirthDateAfterAndBirthDateBefore(LocalDate.of(1995, 1, 1),
                        LocalDate.of(2003, 1, 1));

        allPlayersBetweenDates
                .stream()
                .sorted((a, b) -> {
                    int result = Double.compare(b.getStat().getShooting(), a.getStat().getShooting());
                    if (result == 0) {
                        int resultTwo = Double.compare(b.getStat().getPassing(), a.getStat().getPassing());
                        if (resultTwo == 0) {
                            int resultThree = Double.compare(b.getStat().getEndurance(), a.getStat().getEndurance());
                            if (resultThree == 0) {
                                a.getLastName().compareTo(b.getLastName());
                            }
                        }
                    }
                    return result;
                })
                .forEach(player -> {
                    sb
                            .append(String.format("Player - %s %s\n" +
                                            "Position - %s\n" +
                                            "Team - %s\n" +
                                            "Stadium - %s\n",
                                    player.getFirstName(), player.getLastName(), player.getPosition().name(),
                                    player.getTeam().getName(), player.getTeam().getStadiumName()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
