package com.urcraft.wurm.sickle.client;


import com.urcraft.wurm.sickle.client.asm.ClientVisitor;
import com.urcraft.wurm.sickle.client.asm.transformers.ClientTransformer;
import com.urcraft.wurm.sickle.common.SickleCommon;
import com.urcraft.wurm.sickle.common.asm.transformers.TransformersHandler;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.ArrayList;

public class ClientAgent
{
    public static ArrayList<String> classes = new ArrayList<>();
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

                ClassVisitor clientVisitor = new ClientVisitor(cw, className);

                cr.accept(clientVisitor, 0);

                return cw.toByteArray();
            }
        });
    }

    private static void initTransformers()
    {
        if(transformersInitialized)
            return;
        TransformersHandler handler = TransformersHandler.getInstance();
        new ClientTransformer();
        transformersInitialized = true;
    }

}

abstract class Transformer implements ClassFileTransformer
{
    public abstract byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException;
}
