package com.example.christophersamuel.propel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static junit.framework.Assert.assertEquals;

public class UserManuallyGetSetTest {

    UserManuallyGetSet push = new UserManuallyGetSet();
    UserManuallyGetSet jump = new UserManuallyGetSet();
    UserManuallyGetSet steps = new UserManuallyGetSet();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testJumpSet() throws NoSuchFieldException, IllegalAccessException {

        jump.setJump("20");
        Field f = jump.getClass().getDeclaredField("value");
        f.setAccessible(true);
        assertEquals("no match", f.get(jump), "20");

    }

    @Test
    public void testJumpGet() throws NoSuchFieldException, IllegalAccessException {

        Field f = jump.getClass().getDeclaredField("value");
        f.setAccessible(true);
        f.set(jump, "arbitrary value");

        String res = jump.getJump();

        assertEquals("get failed", res, "arbitrary value");

    }

    @Test
    public void testStepsSet() throws NoSuchFieldException, IllegalAccessException {

        steps.setSteps("1000");
        Field f = steps.getClass().getDeclaredField("value");
        f.setAccessible(true);
        assertEquals("no match", f.get(steps), "1000");

    }

    @Test
    public void testStepsGet() throws NoSuchFieldException, IllegalAccessException {

        Field f = steps.getClass().getDeclaredField("value");
        f.setAccessible(true);
        f.set(steps, "arbitrary value");

        String res = steps.getSteps();

        assertEquals("get failed", res, "arbitrary value");

    }

    @Test
    public void testPushSet() throws NoSuchFieldException, IllegalAccessException {

        push.setPush("50");
        Field f = push.getClass().getDeclaredField("value");
        f.setAccessible(true);
        assertEquals("no match", f.get(push), "50");

    }

    @Test
    public void testPushGet() throws NoSuchFieldException, IllegalAccessException {

        Field f = push.getClass().getDeclaredField("value");
        f.setAccessible(true);
        f.set(push, "arbitrary value");

        String res = push.getSteps();

        assertEquals("get failed", res, "arbitrary value");

    }

    @After
    public void tearDown() throws Exception {
    }
}