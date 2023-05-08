package scooterthecat.restaurantvote.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import scooterthecat.restaurantvote.MenuTestData;
import scooterthecat.restaurantvote.service.MenuService;
import scooterthecat.restaurantvote.user.UserTestData;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MenuControllerTest extends AbstractControllerTest {

    @Autowired
    private MenuService service;
    private static String URL = "/api/admin/menu/";

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + MenuTestData.AKOP_MENU_ID)
                .with(userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MenuTestData.MENU_MATCHER.contentJson(MenuTestData.akop_menu));

    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NoSuchElementException.class, () -> service.get(100));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(URL + MenuTestData.AKOP_MENU_ID)
                .with(userHttpBasic(UserTestData.admin)))
                .andExpect(status().isNoContent())
                .andDo(print());
        assertThrows(NoSuchElementException.class, () -> service.get(MenuTestData.AKOP_MENU_ID));
    }

    @Test
    void create() {

    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }

    @Test
    void addMealToMenu() {
    }
    @Test
    void deleteMealFromMenu()
    {}
}