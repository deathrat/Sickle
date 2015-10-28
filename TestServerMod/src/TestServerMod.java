import com.google.common.eventbus.Subscribe;
import com.urcraft.wurm.sickle.common.Mod;
import com.urcraft.wurm.sickle.common.event.InitEvent;
import com.urcraft.wurm.sickle.common.event.PostInitEvent;
import com.urcraft.wurm.sickle.common.event.PreInitEvent;
import com.urcraft.wurm.sickle.server.creatures.CreatureBodyType;
import com.urcraft.wurm.sickle.server.creatures.CreatureSex;
import com.urcraft.wurm.sickle.server.creatures.CreatureType;
import com.urcraft.wurm.sickle.server.creatures.SickleCreatureTemplate;
import com.wurmonline.server.creatures.CreatureTemplate;
import com.wurmonline.server.skills.Skills;

import java.util.jar.JarFile;

public class TestServerMod extends Mod
{

    public TestServerMod(JarFile jarFile)
    {
        super(jarFile);
        System.out.println("Mod loaded!");
    }

    @Override
    @Subscribe
    public void preInit(PreInitEvent event)
    {
        System.out.println("Pre Init Called!");
    }

    @Override
    @Subscribe
    public void init(InitEvent event)
    {
        System.out.println("Init Called!");
        Skills skills = SickleCreatureTemplate.createSkills("Dong");
        CreatureType[] types = new CreatureType[] {CreatureType.ANIMAL, CreatureType.MOVE_LOCAL, CreatureType.DOMESTIC, CreatureType.OMNIVORE, CreatureType.LEADABLE, CreatureType.DOMINATBLE};
        CreatureTemplate temp = SickleCreatureTemplate.createCreatureTemplate(SickleCreatureTemplate.getNextAvailableID(), "Dong", "PiggyDong", "model.creature.quadraped.pig", types, CreatureBodyType.DOG, skills, (short) 10, CreatureSex.MALE, (short) 50, (short) 50, (short) 150, "sound.death.pig", "sound.death.pig", "sound.combat.hit.pig", "sound.combat.hit.pig", 1.0f, 1.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.8f, 20, new int[]{303, 140, 310}, 10, 54);

    }

    @Override
    @Subscribe
    public void postInit(PostInitEvent event)
    {
        System.out.println("Post Init Called!");
    }
}
