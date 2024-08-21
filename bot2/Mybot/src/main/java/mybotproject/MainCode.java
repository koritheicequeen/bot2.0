package mybotproject;

import javax.imageio.spi.IIORegistry;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import com.twelvemonkeys.imageio.plugins.webp.WebPImageReaderSpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainCode {
    
    private static final Logger logger = LoggerFactory.getLogger(MainCode.class);

    public static void main(String[] args) throws LoginException {
        String token = System.getenv("DISCORD_BOT_TOKEN");
        System.out.println(token);
        if (token == null || token.isEmpty()) {
            logger.error("Token is not set. Please set the DISCORD_BOT_TOKEN environment variable.");
            return;
        }
        IIORegistry.getDefaultInstance().registerServiceProvider(new WebPImageReaderSpi());

        // Your code to handle Discord event and download image
        logger.info("Token successfully retrieved");

        // Create an instance of MyListener and add it to the JDA builder
        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(new MyListener())
                .addEventListeners(new ButtonClickListener())
                .setChunkingFilter(ChunkingFilter.ALL) // enable member chunking for all guilds
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build();
    }
}

  //JDA jda = JDABuilder.createDefault(token).addEventListeners(new MyListener()).enableIntents(GatewayIntent.MESSAGE_CONTENT).enableIntents(GatewayIntent.GUILD_MEMBERS).build();

//.enableIntents(GatewayIntent.GUILD_MEMBERS)