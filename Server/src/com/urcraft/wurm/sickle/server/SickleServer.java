package com.urcraft.wurm.sickle.server;

import com.urcraft.wurm.sickle.common.ModLoader;
import com.urcraft.wurm.sickle.common.SickleCommon;
import com.urcraft.wurm.sickle.common.event.InitEvent;
import com.urcraft.wurm.sickle.common.event.PostInitEvent;
import com.urcraft.wurm.sickle.common.event.PreInitEvent;
import com.wurmonline.server.Server;

public class SickleServer
{
    private static SickleServer _instance;
    private Server _server;
    private ModLoader _loader;

    public SickleServer(Server server)
    {
        _instance = this;
        _server = server;
        _loader = new ModLoader();
        _loader.addMods();
        SickleCommon.EVENTBUS.post(new PreInitEvent());
        SickleCommon.EVENTBUS.post(new InitEvent());
        SickleCommon.EVENTBUS.post(new PostInitEvent());
        System.out.println(SickleCommon.LOG_TAG + "Server Initialized");
    }

    public static SickleServer getInstance()
    {
        return _instance;
    }

    public Server getServer()
    {
        return _server;
    }
}
