package sirvaro.com;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;
import java.util.ArrayList;

public class ReplyKeyboardMarkupBuilder {

    private Long chatId;
    private String text;

    private List<KeyboardRow> keyboard = new ArrayList<>();
    private KeyboardRow row = new KeyboardRow();

    public static ReplyKeyboardMarkupBuilder create() {
        return new ReplyKeyboardMarkupBuilder();
    }

    public ReplyKeyboardMarkupBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ReplyKeyboardMarkupBuilder setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public ReplyKeyboardMarkupBuilder row() {
        this.row = new KeyboardRow();
        return this;
    }

    public ReplyKeyboardMarkupBuilder addOption(String text) {
        row.add(text);
        return this;
    }

    public ReplyKeyboardMarkupBuilder endRow() {
        this.keyboard.add(this.row);
        this.row = null;
        return this;
    }


    public SendMessage build() {
        SendMessage message = new SendMessage();

        message.setChatId(chatId);
        message.setText(text);

        ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();

        replyKeyboard.setKeyboard(keyboard);
        replyKeyboard.setResizeKeyboard(true);
        message.setReplyMarkup(replyKeyboard);

        return message;
    }
}
