/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.memorygame.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roli
 */
public class RekListazasaTest {

    public RekListazasaTest() {
    }

    @Test
    public void testNevProperty() {

        RekListazasa list = new RekListazasa("alma", 1, 1);
        assertEquals("StringProperty [value: alma]", list.nevProperty().toString());
        assertEquals("IntegerProperty [value: 1]", list.helyesProperty().toString());
        assertEquals("IntegerProperty [value: 1]", list.helytelenProperty().toString());

    }

}
