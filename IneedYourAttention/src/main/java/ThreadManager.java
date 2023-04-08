import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public final class ThreadManager {
    /**A thread instance to run spamming on.*/
    private static Thread thread = null;
    /**Attribute to check if current spamming thread is alive.*/
    private static boolean isAlive = false;

    /**
     * While the spam thread is active, spam the mentioned target in the wanted text channel until they reply.
     * @param target Mentioned member to spam.
     * @param channel TextChannel command was executed in.
     * @param lastMessaged Single instance of LastMessage object to read incoming messages while command is running.
     */
    private static void spamTarget(Member target, TextChannel channel, LastMessaged lastMessaged) {
        while (isAlive) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            channel.sendMessage("Need your attention " + target.getAsMention() + "!").queue();

            if(lastMessaged.getLastMessaged().equals(target.getUser()) && lastMessaged.getInChannel().equals(channel)) {
                channel.sendMessage("Attention received!").queue();
                thread.interrupt();
                isAlive = false;
            }

        }

        thread = null;
    }

    /**
     * Create a spam thread and spam target until target sends message to channel.
     * @param target Mentioned member to spam.
     * @param channel TextChannel command was executed in.
     * @param lastMessaged Single instance of LastMessage object to read incoming messages while command is running.
     */
    public static void runSpamThread(Member target, TextChannel channel, LastMessaged lastMessaged) {
        if (!(thread == null)) {
            channel.sendMessage("A user is currently being spammed. Please wait until their attention has been gotten!").queue();
            return;
        }

        thread = new Thread(
                () -> {
                    isAlive = thread.isAlive();
                    spamTarget(target,channel,lastMessaged);
                }
        );

        thread.start();
    }
}
