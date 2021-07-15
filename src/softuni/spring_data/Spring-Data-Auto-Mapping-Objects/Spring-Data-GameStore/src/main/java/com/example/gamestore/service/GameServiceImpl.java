package com.example.gamestore.service;

import com.example.gamestore.model.dto.GameAddDto;
import com.example.gamestore.model.entity.Game;
import com.example.gamestore.repository.GameRepository;
import com.example.gamestore.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper,
                           ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository.save(game);

        System.out.println("Added game " + gameAddDto.getTitle());
    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("Not existing game.");
            return;
        }
        game.setPrice(price);
        game.setSize(Integer.parseInt(String.valueOf(size)));
        gameRepository.save(game);

        System.out.println("Edited " + game.getTitle());
    }

    @Override
    public void deleteGame(Long gameId) {

        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("You are trying to delete not existing game.");
            return;
        }
        gameRepository.delete(game);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public void allGames() {
        List<Game> allGames = gameRepository.findAll();
        allGames.stream().forEach(game -> String.format("%s %.2f", game.getTitle(), game.getPrice()));
    }

    @Override
    public void detailsGame(String gameTitle) {
        Game game = gameRepository.findByTitle(gameTitle);

        if (game == null) {
            System.out.println("Not existing game.");
        }
        System.out.println(String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s",
                game.getTitle(), game.getPrice(), game.getDescription(), game.getReleaseDate()));
    }
}
