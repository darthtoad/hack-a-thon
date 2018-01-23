package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void TeamInstantiatesCorrectly() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        assertEquals(true, testTeam instanceof Team);
    }

    @Test
    public void getName_getsName_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        assertEquals("The A-Team", testTeam.getName());
    }

    @Test
    public void getDescription_getsDescription_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        assertEquals("In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", testTeam.getDescription());
    }
//

    @Test
    public void setName_setsName_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        testTeam.setName("A Team");
        assertEquals("A Team", testTeam.getName());
    }

    @Test
    public void setDescription_setsDescription_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        testTeam.setDescription("A Team");
        assertEquals("A Team", testTeam.getDescription());
    }
}