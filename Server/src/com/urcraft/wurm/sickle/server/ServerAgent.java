package com.urcraft.wurm.sickle.server;

import com.urcraft.wurm.sickle.common.SickleCommon;
import com.urcraft.wurm.sickle.common.asm.transformers.SickleTransformer;
import com.urcraft.wurm.sickle.server.asm.ServerVisitor;
import com.urcraft.wurm.sickle.server.asm.transformers.CreaturesTransformer;
import com.urcraft.wurm.sickle.server.asm.transformers.ServerTransformer;
import com.urcraft.wurm.sickle.common.asm.transformers.TransformersHandler;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServerAgent
{
    private static boolean transformersInitialized = false;

    public static void premain(String agentArgs, Instrumentation inst)
    {
        SickleCommon common = new SickleCommon();
        inst.addTransformer(new Transformer()
        {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException
            {
                ClassReader cr = new ClassReader(classfileBuffer);
                ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);

                initTransformers();

                ClassVisitor serverVisitor = new ServerVisitor(cw, className);
                cr.accept(serverVisitor, 0);

                return cw.toByteArray();
            }
        });
    }

    private static void initTransformers()
    {
        if(transformersInitialized)
            return;
        TransformersHandler handler = TransformersHandler.getInstance();
        new ServerTransformer();
        new CreaturesTransformer();
        transformersInitialized = true;
    }
}

abstract class Transformer implements ClassFileTransformer
{
    public abstract byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException;
}
