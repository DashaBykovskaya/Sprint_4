public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.

         */
        boolean validName = false;
        if (name != null) {
            validName = name.matches("^\\S+\\s\\S+$(?<=^.{3,19}$)");
        }
        return validName;
    }
}

