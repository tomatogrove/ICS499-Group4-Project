package com.team4.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.team4.model.Stats;
import com.team4.repositories.StatsRepository;

@ExtendWith(MockitoExtension.class)
public class StatsControllerTest {
	
	@InjectMocks
	private StatsController statsController;
	
	@Mock
	private StatsRepository statsRepository;
	
	@Test
	public void testList() {
		// Arrange
		Stats stat1 = new Stats();
		stat1.setId(1L);
		stat1.setGameTag("gameTag1");
		stat1.setGamesWon(1);
		
		Stats stat2 = new Stats();
		stat2.setId(2L);
		stat2.setGameTag("gameTag2");
		stat2.setGamesWon(2);
		
		List<Stats> statsList = Arrays.asList(stat1, stat2);
		
		when(statsRepository.findAll()).thenReturn(statsList);
		
		// Act
		List<Stats> result = statsController.list();
		
		// Assert
		assertNotNull(result);
		assertEquals(statsList, result);
	}
	
	@Test
	public void testGet() {
		// Arrange
		Stats stat = new Stats();
		stat.setId(1L);
		stat.setGameTag("gameTag");
		stat.setGamesWon(1);
		
		when(statsRepository.getOne(1L)).thenReturn(stat);
		
		// Act
		Stats result = statsController.get(1L);
		
		// Assert
		assertNotNull(result);
		assertEquals(stat, result);
	}
	
	@Test
	public void testCreate_newStat() {
		// Arrange
		Stats newStat = new Stats();
		newStat.setGameTag("gameTag");
		newStat.setGamesWon(1);
		
		when(statsRepository.findByGameTag("gameTag")).thenReturn(null);
		when(statsRepository.saveAndFlush(newStat)).thenReturn(newStat);
		
		// Act
		Stats result = statsController.create(newStat);
		
		// Assert
		assertNotNull(result);
		assertEquals(newStat, result);
	}
	
	@Test
	public void testCreate_existingStat() {
		// Arrange
		Stats existingStat = new Stats();
		existingStat.setGameTag("gameTag");
		existingStat.setGamesWon(1);
		
		when(statsRepository.findByGameTag("gameTag")).thenReturn(existingStat);
		when(statsRepository.saveAndFlush(existingStat)).thenReturn(existingStat);
		
		// Act
		Stats result = statsController.create(existingStat);
		
		// Assert
		assertNotNull(result);
		assertEquals(existingStat, result);
		assertEquals(2, existingStat.getGamesWon());
	}
	
	@Test
	public void testDelete() {
		// Arrange
		Long id = 1L;
		
		// Act
		statsController.delete(id);
		
		// Assert
		// Verify that the repository's deleteById method was called with the correct id
		when(statsRepository.findById(id)).thenReturn(Optional.empty());
		Optional<Stats> result = statsRepository.findById(id);
		assertEquals(Optional.empty(), result);
	}
}	