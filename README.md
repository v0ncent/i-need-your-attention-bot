# i-need-your-attention-bot
One of the most annoying things to me is when I need to get someones attention in discord and they arent responding. So to counter this I created this simple bot to spam ping a target until they send a message.

# You too can use this bot!
Yes you heard me right, you as well can use this bot. All you need is a discord bot application created in your discord developer portal and you can use this bot's code to spam ping anyone you want.

**How to use**
1. Clone this repository onto your desktop 
2. Rename ```.env.template``` to just ```.env```
3. Open ```.env``` in a text editor of your choice
   - set ```TOKEN``` equal to your discord bot token
   - set ```PREFIX``` equal to any character you wish (this is what you will use to invoke commands from the bot)

*Here you can now chose to run the bot within an IDE or Code editor of your choosing but if you wish to build the project for hosting continue forward*\
4. Open the folder ```i-need-your-attention-bot\IneedYourAttention``` (this is the main project folder and we will need to be in this folder in order to use maven to build the project)
5. Open a CMD or Terminal window in ```i-need-your-attention-bot\IneedYourAttention``` directory
6. In CMD or terminal type ```mvn compile```
7. Then in CMD or terminal type ```mvn package```
8. In the project directory you should now see a folder titled ```target``` open up that directory and within it you should now see a jar file titled ```IneedYourAttention-version.jar```!
