import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class PhoneBookTest {
    private PhoneBook phoneBook = new PhoneBook();
    @Before
    public void setPhoneBook(){
        phoneBook.addPerson("Vlad", "+79214683546", "+79114783512");
        phoneBook.addPerson("Veronika", "+79212285654");
        phoneBook.addPerson("Pavel", "+79992176286", "+79211889604", "89313456754");
    }

    @Test
    public void addPerson() throws Exception {
        phoneBook.addPerson("Nikita", "+79142784635", "88005553535");

        Set<String> setOfPhones = new HashSet<>();
        setOfPhones.add("+79142784635");
        setOfPhones.add("88005553535");

        assertEquals(setOfPhones, phoneBook.Phones.get("Nikita"));
    }

    @Test
    public void removePerson() throws Exception {
        phoneBook.removePerson("Vlad");
        assertFalse(phoneBook.Phones.containsKey("Vlad"));
    }

    @Test
    public void addPhone() throws Exception {
        phoneBook.addPhone("Vlad", "89246731545");

        Set<String> setOfPhones = phoneBook.Phones.get("Vlad");
        assertTrue(setOfPhones.contains("89246731545"));
    }

    @Test
    public void removePhone() throws Exception {
        phoneBook.removePhone("Vlad", "+79114783512");

        Set<String> setOfPhones = phoneBook.Phones.get("Vlad");
        assertFalse(setOfPhones.contains("+79114783512"));
    }

    @Test
    public void searchByPerson() throws Exception {
        Set<String> setOfPhones = phoneBook.Phones.get("Vlad");
        assertEquals(setOfPhones, phoneBook.searchByPerson("Vlad"));
    }

    @Test
    public void searchByPhone() throws Exception {
        assertEquals("Vlad", phoneBook.searchByPhone("+79214683546"));
    }

}