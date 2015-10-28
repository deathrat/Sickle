package com.urcraft.wurm.sickle.server.asm.transformers;

import com.urcraft.wurm.sickle.common.asm.ISickleMethodVisitor;
import com.urcraft.wurm.sickle.common.asm.transformers.SickleTransformer;
import com.urcraft.wurm.sickle.server.SickleServer;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ServerTransformer extends SickleTransformer
{
    public ServerTransformer()
    {
        super("com/wurmonline/server/Server");
    }

    @Override
    public void visitCode(ISickleMethodVisitor smv)
    {
        MethodVisitor mv = smv.getParent();
        if("()V".equals(smv.getDesc()) && "startRunning".equals(smv.getName()))
        {
            String serverClass = SickleServer.class.getName().replace(".", "/");
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitTypeInsn(Opcodes.NEW, serverClass);
            mv.visitInsn(Opcodes.DUP);
            mv.visitIntInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, serverClass, "<init>", "(Lcom/wurmonline/server/Server;)V", false);
            mv.visitIntInsn(Opcodes.ASTORE, 3);
            mv.visitMaxs(0,0);
        }
    }

    @Override
    public void onMethodEnter(ISickleMethodVisitor smv)
    {

    }

    @Override
    public void onMethodExit(int opcode, ISickleMethodVisitor smv)
    {

    }
}
