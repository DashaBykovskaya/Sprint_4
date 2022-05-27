import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestForAccount {

    private String cardName;
    private boolean nameIsCorrect;

    public TestForAccount(String cardName, boolean nameIsCorrect) {
        this.cardName = cardName;
        this.nameIsCorrect = nameIsCorrect;
    }
    @Parameterized.Parameters(name = "Тестовые данные: {0},{1}")
    public static Object[][] getFoodTestAnimal() {
        return new Object[][]{
                {null, false}, //проверка null
                {"", false}, //пустая строка
                {"Tes", false}, //3 символа без пробела
                {"Te s", true}, //3 символа с 1 пробелом
                {"ab", false}, //2 символа
                {"Te st", true}, //проверка граничного значения: 4
                {"TestTestTestTestTes", false}, //19 символов без пробела
                {"TestTest TestTestTe", true}, //19 символов с пробелом
                {"TestTest TestTestTest",false}, //20 символов
                {"TestTest TestTestTe", true}, //проверка граничного значения: 18
                {"Test Test", true}, //значение внутри класса [3,19]
                {" Test Test", false}, //с пробелом вначале
                {"Test Test ", false}, //с пробелом в конце
                {"Test  Test", false}, //два пробела между 2мя словами
                {" ", false}, //пробел в пустой строке
                {"Te St Te", false} //три слова два пробела
        };
    }
    @Test
    public void testCheckCorrectName(){
        Account account = new Account(cardName);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Имя должно состоять из 3ех символов, но не более 19ти, а также содержать только 1 пробел в середине строки",nameIsCorrect, actual);
    }
}

