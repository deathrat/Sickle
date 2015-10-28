package com.urcraft.wurm.sickle.common;

import com.google.common.eventbus.Subscribe;
import com.urcraft.wurm.sickle.common.event.InitEvent;
import com.urcraft.wurm.sickle.common.event.PostInitEvent;
import com.urcraft.wurm.sickle.common.event.PreInitEvent;
import com.urcraft.wurm.sickle.common.json.Json;
import com.urcraft.wurm.sickle.common.json.JsonArray;
import com.urcraft.wurm.sickle.common.json.JsonObject;
import com.urcraft.wurm.sickle.common.json.JsonValue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public abstract class Mod
{
    private JarFile _jarFile;
    private ModMetadata _meta;

    public Mod(JarFile jarFile)
    {
        _jarFile = jarFile;
        try
        {
            processMod();
            System.out.println("[Sickle] Loaded mod: " + _meta.getModName());
            SickleCommon.addMod(this);
            SickleCommon.EVENTBUS.register(this);
        } catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    @Subscribe
    public abstract void preInit(PreInitEvent event);
    @Subscribe
    public abstract void init(InitEvent event);
    @Subscribe
    public abstract void postInit(PostInitEvent event);

    public ModMetadata getMeta() {return _meta;}

    private void processMod() throws IOException
    {
        JarEntry modMeta = _jarFile.getJarEntry("modmeta.json");
        if(modMeta != null)
        {
            InputStream stream = _jarFile.getInputStream(modMeta);
            InputStreamReader reader = new InputStreamReader(stream);
            JsonValue value = Json.parse(reader);
            JsonObject metaObj = value.asObject();
            _meta = new ModMetadata(metaObj.getString("modName", this.getClass().toString()));
            _meta.setTag(metaObj.getString("modTag", ""));
            _meta.setDesc(metaObj.getString("desc", ""));
            _meta.setVersion(metaObj.getString("", ""));
            _meta.setURL(metaObj.getString("", ""));
            if(metaObj.get("author") != null)
            {
                JsonArray authorArray = metaObj.get("authors").asArray();
                if (authorArray != null)
                {
                    String[] authors = new String[authorArray.size()];
                    int i = 0;
                    for (JsonValue entry : authorArray)
                    {
                        authors[i] = entry.asString();
                        i++;
                    }
                    _meta.setAuthors(authors);
                }
            }
        }
    }
}
