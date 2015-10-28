package com.urcraft.wurm.sickle.server.creatures;

import com.urcraft.wurm.sickle.common.SickleCommon;
import com.wurmonline.server.creatures.CreatureTemplate;
import com.wurmonline.server.creatures.CreatureTemplateFactory;
import com.wurmonline.server.creatures.NoSuchCreatureTemplateException;
import com.wurmonline.server.skills.Skills;
import com.wurmonline.server.skills.SkillsFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SickleCreatureTemplate
{
    private int _id;
    private String _name, _longDesc;
    private Skills _skills;

    /**
     *
     * @param id A unique ID for the creature, SickleCreatureTemplate.getNextAvailableID can be used to get a free ID.
     * @param name The name of the mob
     * @param longDesc A description of the mob
     * @param modelName
     * @param types
     * @param bodyType
     * @param skills Use SkillsFactory.createSkills(name).
     * @param vision
     * @param sex
     * @param cmHigh
     * @param cmLong
     * @param cmWide
     * @param maleDeathSound
     * @param femaleDeathSound
     * @param maleHitSnd
     * @param femaleHitSnd
     * @param naturalArmor
     * @param handDam
     * @param kickDam
     * @param biteDam
     * @param headDam
     * @param breathDam
     * @param speed
     * @param moveActivity
     * @param butcherItems
     * @param maxHuntDist
     * @param aggress
     */
    public SickleCreatureTemplate(int id, String name, String longDesc, String modelName, CreatureType[] types, CreatureBodyType bodyType, Skills skills, int vision, CreatureSex sex, short cmHigh, short cmLong, short cmWide, String maleDeathSound, String femaleDeathSound, String maleHitSnd, String femaleHitSnd, float naturalArmor, float handDam, float kickDam, float biteDam, float headDam, float breathDam, float speed, float moveActivity, int[] butcherItems, int maxHuntDist, int aggress)
    {

        skills.learnTemp(102, 20.0f);
        skills.learnTemp(104, 20.0f);
        skills.learnTemp(103, 20.0f);
        skills.learnTemp(100, 20.0f);
        skills.learnTemp(101, 20.0f);
        skills.learnTemp(105, 20.0f);
        skills.learnTemp(106, 20.0f);
        if(id <= 104)
            id = getNextAvailableID();

        _id = id;
        _name = name;
        _longDesc = longDesc;
        _skills = skills;
    }

    public static int getNextAvailableID()
    {
        int highestKey = 0;
        CreatureTemplate[] templates = CreatureTemplateFactory.getInstance().getTemplates();
        for(int i = 0; i < templates.length+10; i++)
        {
            try
            {
                CreatureTemplateFactory.getInstance().getTemplate(i);
            }
            catch(NoSuchCreatureTemplateException e)
            {
                highestKey = i;
                break;
            }
        }
        return highestKey;
    }

    public static Skills createSkills(String name)
    {
        return SkillsFactory.createSkills(name);
    }

    public static CreatureTemplate createCreatureTemplate(int id, String name, String longDesc, String modelName, CreatureType[] types, CreatureBodyType bodyType, Skills skills, int vision, CreatureSex sex, short cmHigh, short cmLong, short cmWide, String maleDeathSound, String femaleDeathSound, String maleHitSnd, String femaleHitSnd, float naturalArmor, float handDam, float kickDam, float biteDam, float headDam, float breathDam, float speed, float moveActivity, int[] butcherItems, int maxHuntDist, int aggress)
    {
        CreatureTemplateFactory ctf = CreatureTemplateFactory.getInstance();
        try
        {
            Method m = ctf.getClass().getDeclaredMethod("createCreatureTemplate", int.class, String.class, String.class, String.class, int[].class, byte.class, Skills.class, short.class, byte.class, short.class, short.class, short.class, String.class, String.class, String.class, String.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class, int.class, int.class);
            m.setAccessible(true);
            int[] iArray = new int[types.length];
            for(int i=0; i < types.length; i++)
                iArray[i] = types[i].id;
            CreatureTemplate toReturn = (CreatureTemplate) m.invoke(id, name, longDesc, modelName, iArray, bodyType.bodyType, skills, vision, sex.sex, cmHigh, cmLong, cmWide, maleDeathSound, femaleDeathSound, maleHitSnd, femaleHitSnd, naturalArmor, handDam, biteDam, headDam, breathDam, speed, moveActivity, butcherItems, maxHuntDist, aggress);
            System.out.println(SickleCommon.LOG_TAG + "Created creature '" + name + "' at ID: " + id);
            return toReturn;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            System.out.println(SickleCommon.LOG_TAG + "Failed to create creature '" + name + "' at ID: " + id);
            e.printStackTrace();
        }
        return null;
    }

//    private static Tuple<Map<Integer, CreatureTemplate>, Map<String, CreatureTemplate>> getTemplateMaps()
//    {
//        Method method;
//        try
//        {
//            method = CreatureTemplateFactory.class.getMethod("getTemplateMaps");
//            return (Tuple<Map<Integer, CreatureTemplate>, Map<String, CreatureTemplate>>)method.invoke(CreatureTemplateFactory.getInstance());
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public static Map<Integer, CreatureTemplate> getIntKeyedTemplates()
//    {
//        return getTemplateMaps().x;
//    }
//
//    public static Map<String, CreatureTemplate> getStringKeyedTemplates()
//    {
//        return getTemplateMaps().y;
//    }
}
