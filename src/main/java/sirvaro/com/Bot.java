package sirvaro.com;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            SendMessage message = new SendMessage();
            switch (message_text) {
                case "/reply":
                    // Create a ReplyMarkupBuilder
                    message.setText("Reply Menu")
                            .setChatId(chat_id)
                            .setReplyMarkup(ReplyKeyboardBuilder.createReply()
                                    .row()
                                    .addText("Option 1")
                                    .addText("Option 2")
                                    .row()
                                    .addText("Option 3")
                                    .addText("Option 4")
                                    .row()
                                    .addText("Exit")
                                    .build()
                            );
                    // Finish
                    break;
                case "/inline":
                    message.setText("Inline Menu")
                            .setChatId(chat_id)
                            .setReplyMarkup(ReplyKeyboardBuilder.createInline()
                                    .row()
                                    .addCallbackData("Button 1", "btn 1")
                                    .addCallbackData("Button 2", "btn 2")
                                    .row()
                                    .addCallbackData("Button 3", "btn 3")
                                    .addCallbackData("Button 4", "btn 4")
                                    .row()
                                    .addCallbackData("Exit", "exit")
                                    .build()
                            );
                    // Finish
                    break;
                case "Exit":
                    ReplyKeyboardRemove keyboard = new ReplyKeyboardRemove();
                    keyboard.getRemoveKeyboard();
                    message.setReplyMarkup(keyboard);
                    message.setChatId(chat_id);
                    message.setText("Bye");
                    break;
                default:
                    message = new SendMessage(chat_id, "You have selected " + message_text + ".");
            }
            try {
                sendApiMethod(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        } else if (update.hasCallbackQuery()) {
            CallbackQuery query = update.getCallbackQuery();
            AnswerCallbackQuery answer = new AnswerCallbackQuery()
                    .setCallbackQueryId(query.getId());
            if (query.getData() != null) {
                answer.setText(query.getData());
            } else if (query.getGameShortName() != null) {
                answer.setText(query.getGameShortName());
            } else {
                answer.setText("Button has no text");
            }
            if (query.getData().equals("exit")) {
                EditMessageText edit = new EditMessageText()
                        .setChatId(query.getMessage().getChatId())
                        .setMessageId(query.getMessage().getMessageId());
                try {
                    sendApiMethod(edit);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String getBotUsername() {
        // Change by your bot username
        return "BOT_USERNAME";
    }

    public String getBotToken() {
        // Change by your bot token
        return "BOT_TOKEN";
    }
}
