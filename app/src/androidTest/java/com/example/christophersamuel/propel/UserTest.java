package com.example.christophersamuel.propel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserTest {

    private User u1;
    private User u2;

    @Before
    public void setUp() throws Exception {

        u1 = new User("csamuel", "pass123");
        u2 = new User("pdang1", "default321");
    }

    @Test
    public void testConstructor() {

        assertEquals("csamuel", u1.getUsername());
        assertEquals("pass123", u1.getPassword());
        assertEquals("pdang1", u2.getUsername());
        assertEquals("default321", u2.getPassword());

    }

    @After
    public void tearDown() throws Exception {
    }
}