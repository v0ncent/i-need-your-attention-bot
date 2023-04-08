import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public final class ThreadManager {
    private static Thread thread = null;
    private static boolean isAlive = false;

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
