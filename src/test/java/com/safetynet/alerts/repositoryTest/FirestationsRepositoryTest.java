package com.safetynet.alerts.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.repository.FirestationsRepository;

@ExtendWith(MockitoExtension.class)
public class FirestationsRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private FirestationsRepository firestationsRepository;

    @Test
    @DisplayName("Test getListFirestationsTest")
    public void getListFirestationsTest() {
        // GIEVEN
        List<Firestations> firestationsList = new ArrayList<Firestations>();

        // WHEN
        when(database.getFirestations()).thenReturn(firestationsList);
        List<Firestations> getListFirestations = firestationsRepository.getListFirestations();
        assertSame(firestationsList, getListFirestations);

        // THEN
        assertTrue(getListFirestations.isEmpty());
        verify(database).getFirestations();
    }
}
