package mybotproject;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

public class ButtonClickListener extends ListenerAdapter {
    public static List<Button> createButtons(List<String> EvolutionName) {
        List<Button> buttons = new ArrayList<>();
        for (String evolution : EvolutionName) {
        buttons.add(Button.secondary(evolution, evolution));
        }
        return buttons;
       
    }
    public static List<Button> checkYes(Member target) {
        List<Button> buttons = new ArrayList<>();
        String userId = target.getId();
      
        buttons.add(Button.primary(userId + "@", "Yes"));
        buttons.add(Button.secondary("No", "No"));
        
        
        return buttons;
       
    }
}
