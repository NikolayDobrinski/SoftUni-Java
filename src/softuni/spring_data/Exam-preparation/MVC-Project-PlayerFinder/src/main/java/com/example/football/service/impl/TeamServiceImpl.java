package com.example.football.service.impl;

import com.example.football.models.dto.json.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {

    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final TownService townService;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, TownService townService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class))
                .filter(teamSeedDto -> {
                    boolean isValid = validationUtil.isValid(teamSeedDto)
                            && !teamExistIntoDb(teamSeedDto.getName());
                    sb
                            .append(isValid ? String.format("Successfully imported Team %s - %d",
                                    teamSeedDto.getName(), teamSeedDto.getFanBase())
                                    : "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team team = modelMapper.map(teamSeedDto, Team.class);
                    team.setTown(townService.findTownByName(teamSeedDto.getName()));
                    return team;
                })
                .forEach(teamRepository::save);

        return sb.toString();
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findTeamByName(name);
    }

    private boolean teamExistIntoDb(String name) {
        if (teamRepository.findTeamByName(name) == null) {
            return false;
        }
        return true;
    }

}
