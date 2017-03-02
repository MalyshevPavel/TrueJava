import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneBook {
    Map<String, Set<String>> Phones;

    public PhoneBook() {
        Phones = new HashMap<>();
    }

    public void addPerson(String name, String... Telephone) {
        Set<String> tmp = new HashSet<>();
        for (String i : Telephone)
            tmp.add(i);
        Phones.put(name, tmp);
    }

    public void removePerson(String name) {
        if (!(Phones.containsKey(name))) throw new ExceptionInInitializerError("Нет такого человека");
        try {
            Phones.remove(name);
        } catch (NullPointerException e) {
            throw new ExceptionInInitializerError(e);
        }


    }

    public void addPhone(String name, String phone) throws NumberFormatException {
        Pattern p = Pattern.compile("(^[\\+\\-\\*\\#0-9]+$)");
        Matcher m = p.matcher(phone);
        if (!m.find()) throw new NumberFormatException();
        Phones.get(name).add(phone);
    }

    public void removePhone(String name, String phone) {
        if (phone.isEmpty()) throw new ExceptionInInitializerError("Телефонов нет");
        else
            try {
                Phones.get(name).remove(phone);
            } catch (NullPointerException e) {
                System.out.println("Не существует такого телефона");
            }
    }

    public Set<String> searchByPerson(String name) {
        if (!(Phones.containsKey(name))) throw new ExceptionInInitializerError("Нет такого человека");
        else return Phones.get(name);
    }

    public String searchByPhone(String phone) {
        for (Map.Entry<String, Set<String>> entry : Phones.entrySet()) {
            Set<String> setOfPhones = entry.getValue();
            if (setOfPhones.contains(phone)) return entry.getKey();
        }
        return null;
    }
}