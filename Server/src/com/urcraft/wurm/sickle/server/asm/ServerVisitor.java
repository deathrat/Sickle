package com.urcraft.wurm.sickle.server.asm;

import com.urcraft.wurm.sickle.common.SickleCommon;
import com.urcraft.wurm.sickle.common.asm.SickleAdviceAdapter;
import com.urcraft.wurm.sickle.common.asm.ISickleClassVisitor;
import com.urcraft.wurm.sickle.common.asm.SickleMethodVisitor;
import com.urcraft.wurm.sickle.common.asm.transformers.TransformersHandler;
import com.urcraft.wurm.sickle.common.event.SickleClassVisitEvent;
import org.objectweb.asm.*;

import java.util.ArrayList;

public class ServerVisitor extends ClassVisitor implements ISickleClassVisitor
{
    private static ArrayList<String> visitedClassesList = new ArrayList<String>();
    private String _className;
    private boolean hasTransformer = false;

    public ServerVisitor(ClassWriter cw, String className)
    {
        super(Opcodes.ASM5, cw);
        _className = className;
        if(TransformersHandler.getInstance().transformers.containsKey(_className))
            hasTransformer = true;
    }

    @Override
    public void visitSource(String source, String debug)
    {
        super.visitSource(source, debug);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        if(hasTransformer)
        {
            SickleCommon.EVENTBUS.post(new SickleClassVisitEvent(this, name, signature, superName, interfaces));
            visitedClassesList.add(_className);
        }
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
    {
        if(hasTransformer)
        {
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
            mv = new SickleMethodVisitor(mv, access, name, desc, signature, exceptions, _className);
            return mv;
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }

    @Override
    public String getClassName()
    {
        return _className;
    }
}
