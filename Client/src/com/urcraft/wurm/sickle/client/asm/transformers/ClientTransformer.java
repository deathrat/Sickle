package com.urcraft.wurm.sickle.client.asm.transformers;

import com.urcraft.wurm.sickle.client.SickleClient;
import com.urcraft.wurm.sickle.common.asm.ISickleMethodVisitor;
import com.urcraft.wurm.sickle.common.asm.transformers.SickleTransformer;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClientTransformer extends SickleTransformer
{
    public ClientTransformer()
    {
        super("com/wurmonline/client/launcherfx/WurmMain");
    }

    @Override
    public void visitCode(ISickleMethodVisitor smv)
    {
        if("(Ljavafx/stage/Stage;)V".equals(smv.getDesc()) && "start".equals(smv.getName()))
        {
            MethodVisitor mv = smv.getParent();
            String clientClass = SickleClient.class.getName().replace(".", "/");
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitTypeInsn(Opcodes.NEW, clientClass);
            mv.visitInsn(Opcodes.DUP);
            mv.visitIntInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, clientClass, "<init>", "(Lcom/wurmonline/client/launcherfx/WurmMain;)V", false);
            mv.visitIntInsn(Opcodes.ASTORE, 1);
        }
    }
}
