<h2>Reply Keyboard Markup Builder</h2>

<p><a href="http://mvnrepository.com/artifact/org.telegram/telegrambots" rel="nofollow"><img src="https://camo.githubusercontent.com/144f319f28796e8b16d31c5f1e883a4439ac7161/68747470733a2f2f6d6176656e2d6261646765732e6865726f6b756170702e636f6d2f6d6176656e2d63656e7472616c2f6f72672e74656c656772616d2f74656c656772616d626f74732f62616467652e737667" alt="Maven Central" data-canonical-src="https://maven-badges.herokuapp.com/maven-central/org.telegram/telegrambots/badge.svg" style="max-width:100%;"></a></p>
<p>A simple builder Reply Keyboard Markup for Telegram Bot.
Using a Telegram Bots API https://github.com/rubenlagus/TelegramBots</p>

<h2>Create a Reply Keyboard Markup using Builder</h2>
<pre>
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
try {
  sendApiMethod(message);
} catch (TelegramApiException e) {
  e.printStackTrace();
}
</pre>
</ol>
<h2>Examples</h2>
<img src="https://github.com/sirvaro/ReplyKeyboardMarkupBuilder/blob/master/App%20Menu.png" alt="Img Menu 1" width="265">
<img src="https://github.com/sirvaro/ReplyKeyboardMarkupBuilder/blob/master/Settings%20Menu.png" alt="Img Menu 2" width="258">

<h2>Credits</h2>
<p><a href="https://github.com/rubenlagus">Rubelangus Telegram Bot API</a></p>
