package sirvaro.com;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
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
            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage(chat_id, "App Menu:")
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
                try {
                    sendApiMethod(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/settings")) {
                SendMessage message = new SendMessage(chat_id, "Settings Menu:")
                        .setReplyMarkup(ReplyKeyboardBuilder.createReply()
                                .row()
                                .addText("Setting 1")
                                .addText("Setting 2")
                                .row()
                                .addText("Setting 3")
                                .addText("Setting 4")
                                .row()
                                .addText("Exit")
                                .build()
                        );
                try {
                    sendApiMethod(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/inline")) {
                SendMessage message = new SendMessage(chat_id, "Inline Menu:")
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
                try {
                    sendApiMethod(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

                // Example
                SendMessage message = new SendMessage(chat_id, "You have selected " + message_text + ".");
                if(message_text.equals("Exit")) {
                    ReplyKeyboardRemove keyboard = new ReplyKeyboardRemove();
                    keyboard.getRemoveKeyboard();
                    message.setReplyMarkup(keyboard);
                    message.setText("Bye");
                }
                try {
                    sendApiMethod(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
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
