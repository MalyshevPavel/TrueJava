import java.util.*;

public class PhoneBook {
    Map<String, Set<String>> Phones;

    PhoneBook() {
        Phones = new HashMap<String, Set<String>>();
    }

    public void addPerson(String name, String... Telephone) {
        Set<String> tmp = new HashSet<>();
        for (String i : Telephone)
            tmp.add(i);
        Phones.put(name, tmp);
    }

    public void removePerson (String name) {
        Phones.remove(name);
    }

    public void addPhone(String name, String phone) {
        Phones.get(name).add(phone);
    }

    public void removePhone(String name, String phone) {
        Phones.get(name).remove(phone);
    }

    public Set<String> searchByPerson (String name) {
        return Phones.get(name);
    }

    public String searchByPhone (String phone) {
        for (Map.Entry<String, Set<String>> entry : Phones.entrySet()) {
            Set<String> setOfPhones = entry.getValue();
            if (setOfPhones.contains(phone)) return entry.getKey();
        }
        return null;
    }

}