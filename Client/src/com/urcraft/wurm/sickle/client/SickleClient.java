package com.urcraft.wurm.sickle.client;

import com.urcraft.wurm.sickle.common.SickleCommon;
import com.urcraft.wurm.sickle.common.event.InitEvent;
import com.urcraft.wurm.sickle.common.event.PostInitEvent;
import com.urcraft.wurm.sickle.common.event.PreInitEvent;
import com.urcraft.wurm.sickle.common.event.SickleEventHandler;
import com.wurmonline.client.launcherfx.WurmMain;

public class SickleClient
{
    private static SickleClient _instance;
    private WurmMain _client;

    public SickleClient(WurmMain wm)
    {
        _instance = this;
        _client = wm;
        SickleEventHandler.getInstance().EVENT_BUS.post(new PreInitEvent());
        SickleEventHandler.getInstance().EVENT_BUS.post(new InitEvent());
        SickleEventHandler.getInstance().EVENT_BUS.post(new PostInitEvent());
        System.out.println(SickleCommon.LOG_TAG + "Client Loader initialized.");
    }

    public SickleClient instance()
    {
        return _instance;
    }

    public WurmMain getClient()
    {
        return _client;
    }
}
