package com.urcraft.wurm.sickle.common.asm.transformers;

import java.util.HashMap;

public class TransformersHandler
{
    public HashMap<String, SickleTransformer> transformers;
    private static TransformersHandler _instance;

    public TransformersHandler()
    {
        transformers = new HashMap<>();
    }

    public static TransformersHandler getInstance()
    {
        if(_instance == null)
            _instance = new TransformersHandler();
        return _instance;
    }
}
