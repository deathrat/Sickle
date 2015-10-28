package com.urcraft.wurm.sickle.client.asm;


import com.urcraft.wurm.sickle.client.asm.transformers.ClientTransformer;
import com.urcraft.wurm.sickle.common.asm.SickleAdviceAdapter;
import com.urcraft.wurm.sickle.common.asm.ISickleClassVisitor;
import com.urcraft.wurm.sickle.common.asm.SickleMethodVisitor;
import com.urcraft.wurm.sickle.common.asm.transformers.TransformersHandler;
import org.objectweb.asm.*;

public class ClientVisitor extends ClassVisitor implements ISickleClassVisitor
{
    private String _className;

    public ClientVisitor(ClassWriter cw, String className)
    {
        super(Opcodes.ASM5, cw);
        _className = className;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
    {
        initTransformers();
        if(TransformersHandler.getInstance().transformers.containsKey(_className))
        {
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
            mv = new SickleMethodVisitor(mv, access, name, desc, signature, exceptions, _className);
            return mv;
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }

    private void initTransformers()
    {
        new ClientTransformer();
    }

    @Override
    public String getClassName()
    {
        return _className;
    }
}
