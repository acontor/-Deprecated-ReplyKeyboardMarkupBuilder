package sirvaro.com;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboardMarkupBuilder {

    private List<KeyboardRow> keyboard = new ArrayList<>();
    private KeyboardRow row = null;

    public static ReplyKeyboardMarkupBuilder create() {
        return new ReplyKeyboardMarkupBuilder();
    }

    public ReplyKeyboardMarkupBuilder row() {
        if (row != null) {
            keyboard.add(row);
        }
        row = new KeyboardRow();
        return this;
    }

    public ReplyKeyboardMarkupBuilder addOption(String text) {
        row.add(text);
        return this;
    }


    public ReplyKeyboardMarkup build() {
        if (row != null) {
            keyboard.add(row);
        }
        return new ReplyKeyboardMarkup()
                .setKeyboard(keyboard)
                .setResizeKeyboard(true);
    }
}
