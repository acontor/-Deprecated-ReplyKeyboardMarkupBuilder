package sirvaro.com;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                // Create a ReplyMarkupBuilder
                SendMessage message = ReplyKeyboardMarkupBuilder.create()
                        .setText("App Menu:")
                        .setChatId(chat_id)
                        .row()
                        .addOption("Option 1")
                        .addOption("Option 2")
                        .endRow()
                        .row()
                        .addOption("Option 3")
                        .addOption("Option 4")
                        .endRow()
                        .row()
                        .addOption("Exit")
                        .endRow()
                        .build();
                // Finish
                try {
                    sendApiMethod(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/settings")) {
                // Create a ReplyMarkupBuilder
                SendMessage message = ReplyKeyboardMarkupBuilder.create()
                        .setText("Settings Menu:")
                        .setChatId(chat_id)
                        .row()
                        .addOption("Setting 1")
                        .addOption("Setting 2")
                        .endRow()
                        .row()
                        .addOption("Setting 3")
                        .addOption("Setting 4")
                        .endRow()
                        .row()
                        .addOption("Exit")
                        .endRow()
                        .build();
                // Finish
                try {
                    sendApiMethod(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            // Example
            SendMessage message = new SendMessage();
            switch (message_text) {
                case "Option 1":
                    message.setText("You have selected Option 1.");
                    message.setChatId(chat_id);
                    break;
                case "Option 2":
                    message.setText("You have selected Option 2.");
                    message.setChatId(chat_id);
                    break;
                case "Option 3":
                    message.setText("You have selected Option 3.");
                    message.setChatId(chat_id);
                    break;
                case "Option 4":
                    message.setText("You have selected Option 4.");
                    message.setChatId(chat_id);
                    break;
                case "Setting 1":
                    message.setText("You have selected Setting 1.");
                    message.setChatId(chat_id);
                    break;
                case "Setting 2":
                    message.setText("You have selected Setting 2.");
                    message.setChatId(chat_id);
                    break;
                case "Setting 3":
                    message.setText("You have selected Setting 3.");
                    message.setChatId(chat_id);
                    break;
                case "Setting 4":
                    message.setText("You have selected Setting 4.");
                    message.setChatId(chat_id);
                    break;
                case "Exit":
                    ReplyKeyboardRemove keyboard = new ReplyKeyboardRemove();
                    keyboard.getRemoveKeyboard();
                    message.setReplyMarkup(keyboard);
                    message.setText("Bye");
                    message.setChatId(chat_id);
                    break;
            }
            try {
                sendApiMethod(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }


    public String getBotUsername() {
        // Change by your bot username
        return "ReplyKeyboardMarkupBuilderBot";
    }

    public String getBotToken() {
        // Change by your bot token
        return "622576390:AAHLIzOTTlwS46I60-U3D7u952LVqYPfcgY";
    }
}
